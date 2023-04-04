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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

        var list = flightsRepository.findAll();

        if (list.isEmpty()) {
            throw new ValidationParams("No hay vuelos cargados");
        }
        return list.stream().map(
                        flight -> mapper.map(flight, FlightModelDTO.class)
                )
                .collect(Collectors.toList());
    }

    public List<FlightModelDTO> findDate(LocalDate from, LocalDate to, String destination, String origin) {
        List<FlightModel> availableFlight = flightsRepository.findByFromEqualsAndToEqualsAndDestinationEqualsAndOriginEquals(from, to, destination, origin);
        if (availableFlight.isEmpty()) {
            throw new ValidationParams("No hay vuelos disponibles para las fechas y el destino u origen indicados");
        }
        return availableFlight.stream()
                .map(flight -> mapper.map(flight, FlightModelDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public MessageDTO deleteEntity(String flightNumber) {

        if (flightsRepository.countFlightsReservationByHotelCode(flightNumber) > 0) {
            throw new ValidationParams("No se puede eliminar el vuelo porque se encuentra en reserva");
        }

        if(flightsRepository.existsByCode(flightNumber)) {
            flightsRepository.deleteByCode(flightNumber);
            return MessageDTO.builder()
                    .message("Se elimino el vuelo con Number " + flightNumber)
                    .build();
        }
        else{
            throw new ValidationParams("No se pudo encontrar un vuelo con ese codigo");
        }

    }


    //PRACTICA INDIVIDUAL
    public List<FlightModelDTO> findDestination(String destination) {
        List<FlightModel> flightByCity = flightsRepository.findByDestinationEquals(destination);
        if (flightByCity.isEmpty()) {
            throw new ValidationParams("No hay vuelos disponibles para el destino indicado");
        }
        return flightByCity.stream()
                .map(flight -> mapper.map(flight, FlightModelDTO.class))
                .collect(Collectors.toList());
    }

    public List<FlightModelDTO> findBySeatType(String seatType) {
        List<FlightModel> flightBySeatType = flightsRepository.findBySeatTypeEquals(seatType);
//        if (flightBySeatType.isEmpty()) {
//            throw new ValidationParams("No hay vuelos disponibles para el destino indicado");
//        }
        return flightBySeatType.stream()
                .map(flight -> mapper.map(flight, FlightModelDTO.class))
                .collect(Collectors.toList());
    }

}

