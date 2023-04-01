package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import com.SG_G1.BootcampDH.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HotelService implements ICrudService<HotelModelDTO, Integer> {

    @Autowired
    IHotelRepository hotelRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDTO saveEntity(HotelModelDTO DTO) {
        HotelModel hotel = mapper.map(DTO, HotelModel.class);
         hotelRepository.save(hotel);
        return mapper.map(hotel, MessageDTO.class);
    }

    @Override
    public MessageDTO updateEntity(String hotelCode, HotelModelDTO DTO) {
        HotelModel hotel = hotelRepository.findByCode(hotelCode)
                .orElseThrow(() -> new ValidationParams("El hotel con el código " + hotelCode + " no existe"));

        mapper.map(DTO, hotel);
        hotelRepository.save(hotel);

        return MessageDTO.builder()
                .message("Hotel modificado correctamente")
                .build();
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
        // Busca el hotel por código
        HotelModel hotel = hotelRepository.findByCode(hotelCode)
                .orElseThrow(() -> new ValidationParams("No se encontró ningún hotel con el código proporcionado"));

        // Elimina el hotel de la base de datos
        hotelRepository.delete(hotel);

        // Crea un objeto MessageDTO con el mensaje de éxito y lo devuelve
        return MessageDTO.builder()
                .message("Hotel eliminado correctamente")
                .build();
    }
    }

