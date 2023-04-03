package com.SG_G1.BootcampDH.controller;


import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.service.FlightReservationService;
import com.SG_G1.BootcampDH.service.FlightService;
import com.SG_G1.BootcampDH.service.HotelBookingService;
import com.SG_G1.BootcampDH.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flight-reservation")
public class FlightReservationController {

    @Autowired
    FlightReservationService flightService;



    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createFlightre(@RequestBody DTOrequest6 DTO) {
        MessageDTO message = flightService.saveEntity(DTO.getFlightReservation());
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit")
    public ResponseEntity<MessageDTO> updateBooking(@RequestParam("id") Integer id,
                                                    @RequestBody DTOrequest6 reservation) {
        var message = flightService.updateEntity(id, reservation.getFlightReservation());
        return ResponseEntity.ok(message);
    }

}
