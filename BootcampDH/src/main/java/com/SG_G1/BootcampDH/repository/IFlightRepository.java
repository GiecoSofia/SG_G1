package com.SG_G1.BootcampDH.repository;


import com.SG_G1.BootcampDH.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<FlightModel,Integer> {
}
