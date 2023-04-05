package com.SG_G1.BootcampDH.controller;

import com.SG_G1.BootcampDH.dto.BookingModelDTO;
import com.SG_G1.BootcampDH.dto.FlightReservationModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.HotelReservationDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.dto.resquest.HotelRequestDTO;
import com.SG_G1.BootcampDH.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel-booking")
public class HotelBookingController {

    @Autowired
    HotelBookingService bookingService;

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createBooking (@RequestBody HotelRequestDTO reservation) {
        var message = bookingService.saveEntity(reservation.getBooking());
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit")
    public ResponseEntity<MessageDTO> updateBooking(@RequestParam("id") Integer id,
                                                    @RequestBody HotelRequestDTO reservation) {
       var message = bookingService.updateEntity(id, reservation.getBooking());
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity <HotelReservationDTO> getAllBookings() {
        return new ResponseEntity <HotelReservationDTO> (new HotelReservationDTO(bookingService.getAllEntities()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<MessageDTO> deleteBooking(@RequestParam Integer id) {
        return ResponseEntity.ok(bookingService.deleteEntity(id));
    }

    @PostMapping("/findByPeopleDni")
    public ResponseEntity<BookingModelDTO> findByPeopleDni(@RequestParam("dni") Integer dni){
        return ResponseEntity.ok(bookingService.findByPeopleDni(dni));
    }

    @PostMapping("/findByPeopleMail")
    public ResponseEntity<BookingModelDTO> findByPeopleMail(@RequestParam("mail") String mail){
        return ResponseEntity.ok(bookingService.findByPeopleMail(mail));
    }
}



