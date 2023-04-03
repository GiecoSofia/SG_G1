package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.FlightModelDTO;
import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.IFlightRepository;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import com.SG_G1.BootcampDH.service.generics.ICrudService;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FlightService {


    @Autowired
    IFlightRepository flightsRepository;

    ModelMapper mapper = new ModelMapper();

    public MessageDTO saveEntity(FlightModelDTO DTO) {
        FlightModel existingHotel = flightsRepository.findByDestinationAndOriginAndFromAndTo(DTO.getDestination(), DTO.getOrigin(), DTO.getFrom(), DTO.getTo());
        if (existingHotel != null) {
            throw new ValidationParams("Ya existe un vuelo con características idénticas");
        }
        Long count = flightsRepository.countFlightsReservationByHotelCode(DTO.getCode());
        if (count > 0) {
            throw new ValidationParams("El vuelo está actualmente en una reserva.");
        }
        FlightModel flight = mapper.map(DTO, FlightModel.class);
        flightsRepository.save(flight);
        return MessageDTO.builder()
                .message("El vuelo se dio de alta correctamente.")
                .build();

    }


    public MessageDTO updateEntity(String flightNumber, FlightModelDTO DTO) {


        FlightModel flight = flightsRepository.findByCode(flightNumber)
                .orElseThrow(() -> new ValidationParams("El vuelo con el código " + flightNumber + " no existe"));







        mapper.map(DTO, flight);
        flightsRepository.save(flight);



        return new MessageDTO("Vuelo modificado correctamente");
    }


    public List<FlightModelDTO> getAllEntities() {
        return null;
    }


    public MessageDTO deleteEntity(String integer) {
        return null;
    }
}
