package com.SG_G1.BootcampDH.repository;


import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IFlightRepository extends JpaRepository<FlightModel,Integer> {
   FlightModel findByDestinationAndOriginAndFromAndTo( String destination, String origin, LocalDate from, LocalDate to);

    @Query("SELECT COUNT(b) FROM FlightReservationModel b WHERE b.flightNumber = :flightNumber")
    Long countFlightsReservationByHotelCode(@Param("flightNumber") String hotelCode);
   /* La consulta busca todas las reservas que tengan el mismo código de hotel que se pasa como parámetro y
    devuelve el número de resultados. Si el número de reservas es mayor que cero, entonces el hotel está actualmente
    en una reserva y no debe eliminarse o actualizarse.*/

    void deleteByCode(String code);

    boolean existsByCode(String code);
    Optional<FlightModel> findByCode(String code);

 @Query("SELECT f FROM FlightModel f WHERE f.code = :code")
 List<FlightModel> findAllByCode(@Param("code") String code);

    List<FlightModel> findByFromEqualsAndToEqualsAndDestinationEqualsAndOriginEquals(LocalDate from, LocalDate to, String destination, String origin);



}
