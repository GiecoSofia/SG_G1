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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class HotelService  {

    @Autowired
    IHotelRepository hotelRepository;

    ModelMapper mapper = new ModelMapper();

    public MessageDTO saveEntity(HotelModelDTO hotelDTO) {
        HotelModel existingHotel = hotelRepository.findByPlaceAndNameAndFromAndTo(hotelDTO.getPlace(), hotelDTO.getName(), hotelDTO.getFrom(), hotelDTO.getTo());
        if (existingHotel != null) {
            throw new ValidationParams("Ya existe un hotel con características idénticas");
        }
        Long count = hotelRepository.countBookingsByHotelCode(hotelDTO.getCode());
        if (count > 0) {
            throw new ValidationParams( "El hotel está actualmente en una reserva.");
        }
        HotelModel hotel = mapper.map(hotelDTO, HotelModel.class);
        hotelRepository.save(hotel);
        return MessageDTO.builder()
                .message("El hotel se dio de alta correctamente.")
                .build();
    }


    public MessageDTO updateEntity(String hotelCode, HotelModelDTO DTO) {
        HotelModel hotel = hotelRepository.findByCode(hotelCode)
                .orElseThrow(() -> new ValidationParams("El hotel con el código " + hotelCode + " no existe"));

        mapper.map(DTO, hotel);
        hotelRepository.save(hotel);

        return new MessageDTO("Hotel modificado correctamente");
    }


    public List<HotelModelDTO> getAllEntities() {
        var list = hotelRepository.findAll();

        if (list.isEmpty()) {
            throw new ValidationParams("No hay hoteles cargados");
        }
        return list.stream().map(
                        hotel -> mapper.map(hotel, HotelModelDTO.class)
                )
                .collect(Collectors.toList());
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

    @Transactional
    public MessageDTO deleteEntity(String hotelCode) {
        if (hotelRepository.countBookingsByHotelCode(hotelCode) > 0) {
            throw new ValidationParams("No se puede eliminar el hotel porque se encuentra en reserva");
        }

        if(hotelRepository.existsByCode(hotelCode)) {
            hotelRepository.deleteByCode(hotelCode);
            return MessageDTO.builder()
                    .message("Se elimino el hotel con CODE " + hotelCode)
                    .build();
        }
        else{
            throw new ValidationParams("No se pudo encontrar un hotel con ese codigo");
        }
    }


    //PRACTICA INDIVIDUAL
    public List<HotelModelDTO> findPlace(String place) {
        List<HotelModel> hotelByCity = hotelRepository.findByPlaceEquals(place);
        if (hotelByCity.isEmpty()) {
            throw new ValidationParams("No hay hoteles en el destino indicado");
        }
        return hotelByCity.stream()
                .map(hotel -> mapper.map(hotel, HotelModelDTO.class))
                .collect(Collectors.toList());
    }


    public List<HotelModelDTO> findByRoomType(String type) {
        List<HotelModel> hotelByRoomType = hotelRepository.findByTypeEquals(type);
        if(hotelByRoomType.isEmpty()) {
            throw new ValidationParams("No existe ese tipo de habitacion");
        }
        return hotelByRoomType.stream()
                .map(hotel -> mapper.map(hotel, HotelModelDTO.class))
                .collect(Collectors.toList());
    }
}






