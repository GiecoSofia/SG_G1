package com.SG_G1.BootcampDH.repository;


import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.FlightReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface IFlightReservationRepository extends JpaRepository<FlightReservationModel,Integer> {

    Optional<FlightReservationModel> findByDateFromAndDateToAndDestinationAndOriginAndFlightNumberAndSeatsAndSeatType(
            LocalDate dateFrom, LocalDate dateTo,String destination, String origin, String flightNumber, int seats, String seatType);

    Optional<FlightReservationModel> findById(Integer id);
}
