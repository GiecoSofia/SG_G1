package com.SG_G1.BootcampDH.repository;

import com.SG_G1.BootcampDH.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<BookingModel,Integer> {
}
