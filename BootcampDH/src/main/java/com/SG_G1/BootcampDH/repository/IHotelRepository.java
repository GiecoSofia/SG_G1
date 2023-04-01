package com.SG_G1.BootcampDH.repository;

import com.SG_G1.BootcampDH.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHotelRepository extends JpaRepository<HotelModel,Integer> {
    Optional<HotelModel> findByCode(String code);

}
