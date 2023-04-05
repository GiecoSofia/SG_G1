package com.SG_G1.BootcampDH.controller;


import com.SG_G1.BootcampDH.dto.FlightReservationModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.FlightReservationDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.dto.resquest.FlightRequestDTO;
import com.SG_G1.BootcampDH.service.FlightReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flight-reservation")
public class FlightReservationController {

    @Autowired
    FlightReservationService flightService;



    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createFlightre(@RequestBody FlightRequestDTO DTO) {
        MessageDTO message = flightService.saveEntity(DTO.getFlightReservation());
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit")
    public ResponseEntity<MessageDTO> updateBooking(@RequestParam("id") Integer id,
                                                    @RequestBody FlightRequestDTO reservation) {
        var message = flightService.updateEntity(id, reservation.getFlightReservation());
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity <FlightReservationDTO> getAllBookings() {
        return new ResponseEntity <FlightReservationDTO> (new FlightReservationDTO(flightService.getAllEntities()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<MessageDTO> deleteBooking(@RequestParam Integer id) {
        return ResponseEntity.ok(flightService.deleteEntity(id));
    }

    @PostMapping("/findByPeopleDni")
    public ResponseEntity<FlightReservationModelDTO> findByPeopleDni(@RequestParam("dni") Integer dni){
        return ResponseEntity.ok(flightService.findByPeopleDni(dni));
    }

    @PostMapping("/findByPeopleMail")
    public ResponseEntity<FlightReservationModelDTO> findByPeopleMail(@RequestParam("mail") String mail){
        return ResponseEntity.ok(flightService.findByPeopleMail(mail));
    }
}
