package com.SG_G1.BootcampDH.controller;

import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel-booking")
public class HotelBookingController {

    @Autowired
    HotelBookingService bookingService;

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createBooking (@RequestBody DTOresquest3 reservation) {
        var message = bookingService.saveEntity(reservation.getBooking());
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit")
    public ResponseEntity<MessageDTO> updateBooking(@RequestParam("id") Integer id,
                                                    @RequestBody DTOresquest3 reservation) {
       var message = bookingService.updateEntity(id, reservation.getBooking());
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<List<BookingModel>> getAllBookings() {
        List<BookingModel> bookings = bookingService.getAllEntities();
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MessageDTO> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteEntity(id);
        return ResponseEntity.ok(new MessageDTO("La reserva se eliminó correctamente."));
    }

}
