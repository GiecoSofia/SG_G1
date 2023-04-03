package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.BookingModelDTO;
import com.SG_G1.BootcampDH.dto.FlightReservationModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.FlightReservationModel;
import com.SG_G1.BootcampDH.repository.IFlightReservationRepository;
import com.SG_G1.BootcampDH.repository.IHotelBookingRepository;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import com.SG_G1.BootcampDH.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightReservationService{

    @Autowired
    IFlightReservationRepository flightReservationRepository;


    ModelMapper mapper = new ModelMapper();


    public MessageDTO saveEntity(FlightReservationModelDTO DTO) {
        FlightReservationModel reservation = mapper.map(DTO, FlightReservationModel.class);


        // Comprobar si existe una reserva con idénticas características
        Optional<FlightReservationModel> existingBooking = flightReservationRepository.findByDateFromAndDateToAndDestinationAndOriginAndFlightNumberAndSeatsAndSeatType(
                reservation.getDateFrom(), reservation.getDateTo(), reservation.getDestination(), reservation.getOrigin(), reservation.getFlightNumber(), reservation.getSeats(), reservation.getSeatType());

        if (existingBooking.isPresent()) {
            // Comprobar si existe una reserva con idénticas características
            throw new ValidationParams("Ya existe una reserva con características idénticas.");
        } else {
            //Si no existe una reserva de idénticas características, graba la nueva reserva
            flightReservationRepository.save(reservation);
            return new MessageDTO("La reserva se creó correctamente.");
        }
    }



    public MessageDTO updateEntity(Integer id, FlightReservationModelDTO DTO) {


        FlightReservationModel reservation = flightReservationRepository.findById(id)
                .orElseThrow(() -> new ValidationParams("La reserva con el " + id + "no existe"));
        

        mapper.map(DTO, reservation);
        flightReservationRepository.save(reservation);
        return new MessageDTO("La reserva se modifico correctamente.");

    }



    public List<FlightReservationModelDTO> getAllEntities() {

        List<FlightReservationModel> list = flightReservationRepository.findAll();

        if (list.isEmpty()) {
            throw new ValidationParams("No hay reservas de vuelos");
        }
        return list.stream()
                .map(flightList -> mapper.map(flightList, FlightReservationModelDTO.class))
                .collect(Collectors.toList());
    }


    public MessageDTO deleteEntity(Integer id) {
        FlightReservationModel reservation = flightReservationRepository.findById(id)
                .orElseThrow(() -> new ValidationParams("La reserva con el id " + id + " no existe"));
        flightReservationRepository.delete(reservation);
        return new MessageDTO("La reserva se eliminó correctamente.");
    }
}
