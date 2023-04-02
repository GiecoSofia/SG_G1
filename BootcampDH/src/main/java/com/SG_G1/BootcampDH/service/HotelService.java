package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import com.SG_G1.BootcampDH.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class HotelService implements ICrudService<HotelModelDTO, Integer> {

    @Autowired
    IHotelRepository hotelRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDTO saveEntity(HotelModelDTO hotelDTO) {
        HotelModel existingHotel = hotelRepository.findByPlaceAndNameAndFromAndTo(hotelDTO.getPlace(), hotelDTO.getName(), hotelDTO.getFrom(), hotelDTO.getTo());
        if (existingHotel != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe el hotel con características idénticas");
        }

        HotelModel hotel = mapper.map(hotelDTO, HotelModel.class);
        hotelRepository.save(hotel);

        MessageDTO message = MessageDTO.builder()
                .message("Hotel dado de alta correctamente")
                .build();
        return message;
    }

    @Override
    public MessageDTO updateEntity(String hotelCode, HotelModelDTO DTO) {
        HotelModel hotel = hotelRepository.findByCode(hotelCode)
                .orElseThrow(() -> new ValidationParams("El hotel con el código " + hotelCode + " no existe"));

        Long bookingsCount = hotelRepository.countBookingsByHotelCode(hotelCode);
        if (bookingsCount > 0) {
            return new MessageDTO("No se puede actualizar el hotel porque se encuentra en reserva");
        }

        mapper.map(DTO, hotel);
        hotelRepository.save(hotel);

        return new MessageDTO("Hotel modificado correctamente");
    }


    @Override
    public List<HotelModelDTO> getAllEntities() {
        var list = hotelRepository.findAll();
        return list.stream().map(
                        hotel -> mapper.map(hotel, HotelModelDTO.class)
                )
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(String hotelCode) {
        if (hotelRepository.countBookingsByHotelCode(hotelCode) > 0) {
            return new MessageDTO("No se puede eliminar el hotel porque se encuentra en reserva");
        }
        hotelRepository.deleteByCode(hotelCode);
        return new MessageDTO("El hotel ha sido eliminado exitosamente");
    }
    public List<HotelModelDTO> findDate(LocalDate from, LocalDate to, String place) {
        List<HotelModel> availableHotels = hotelRepository.findByFromEqualsAndToEqualsAndPlaceEquals(from, to, place);
        if (availableHotels.isEmpty()) {
            throw new ValidationParams("No hay hoteles disponibles para las fechas y el destino indicados");
        }
        return availableHotels.stream()
                .map(hotel -> mapper.map(hotel, HotelModelDTO.class))
                .collect(Collectors.toList());
    }
    }






