package com.SG_G1.BootcampDH.repository;

import com.SG_G1.BootcampDH.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHotelBookingRepository extends JpaRepository<BookingModel,Integer> {

    Optional<BookingModel> findByDateFromAndDateToAndDestinationAndHotelCodeAndPeopleAmountAndRoomType(
            LocalDate dateFrom, LocalDate dateTo, String destination, String hotelCode, int peopleAmount, String roomType);
    Optional<BookingModel> findById(Integer id);

    @Query("SELECT B FROM BookingModel B JOIN B.people P WHERE P.dni= :dni")
    BookingModel findByPeopleDni(@Param("dni") int dni);

    @Query("SELECT B FROM BookingModel B JOIN B.people P WHERE P.mail= :mail")
    BookingModel findByPeopleMail(@Param("mail") String mail);
}
