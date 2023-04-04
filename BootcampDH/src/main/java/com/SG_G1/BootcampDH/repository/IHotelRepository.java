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

      @Query("SELECT COUNT(b) FROM BookingModel b WHERE b.hotelCode = :hotelCode")
      Long countBookingsByHotelCode(@Param("hotelCode") String hotelCode);
   /* La consulta busca todas las reservas que tengan el mismo código de hotel que se pasa como parámetro y
    devuelve el número de resultados. Si el número de reservas es mayor que cero, entonces el hotel está actualmente
    en una reserva y no debe eliminarse o actualizarse.*/


    void deleteByCode(String code);

    boolean existsByCode(String code);
    Optional<HotelModel> findByCode(String code);

    List<HotelModel> findByFromEqualsAndToEqualsAndPlaceEquals(LocalDate from, LocalDate to, String place);




    //PRACTICA INDIVIDUAL
    List<HotelModel> findByPlaceEquals(String place);

    List<HotelModel> findByTypeEquals(String type);

}

