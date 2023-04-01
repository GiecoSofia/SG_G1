package com.SG_G1.BootcampDH.repository;

import com.SG_G1.BootcampDH.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHotelRepository extends JpaRepository<HotelModel,Integer> {
    HotelModel findByPlaceAndNameAndFromAndTo(String name, String place, LocalDate from, LocalDate to);

    Optional<HotelModel> findByCode(String code);

    List<HotelModel> findByFromEqualsAndToEqualsAndPlaceEquals(LocalDate from, LocalDate to, String place);

}

