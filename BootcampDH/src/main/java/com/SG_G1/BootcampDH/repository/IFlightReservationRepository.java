package com.SG_G1.BootcampDH.repository;


import com.SG_G1.BootcampDH.model.FlightReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightReservationRepository extends JpaRepository<FlightReservationModel,Integer> {
}
