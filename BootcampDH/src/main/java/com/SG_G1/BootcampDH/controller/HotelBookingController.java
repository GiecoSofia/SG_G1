package com.SG_G1.BootcampDH.controller;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity <DTOresponsive3> getAllBookings() {
        return new ResponseEntity <DTOresponsive3> (new DTOresponsive3(bookingService.getAllEntities()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<MessageDTO> deleteBooking(@RequestParam Integer id) {
        return ResponseEntity.ok(bookingService.deleteEntity(id));
    }

}
