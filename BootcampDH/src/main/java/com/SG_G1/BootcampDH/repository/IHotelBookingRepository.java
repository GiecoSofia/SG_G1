package com.SG_G1.BootcampDH.repository;

import com.SG_G1.BootcampDH.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface IHotelBookingRepository extends JpaRepository<BookingModel,Integer> {

    Optional<BookingModel> findByDateFromAndDateToAndDestinationAndHotelCodeAndPeopleAmountAndRoomType(
            LocalDate dateFrom, LocalDate dateTo, String destination, String hotelCode, int peopleAmount, String roomType);
    Optional<BookingModel> findById(Integer id);
}
