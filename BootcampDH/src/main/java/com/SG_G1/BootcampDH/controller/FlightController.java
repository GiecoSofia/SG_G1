package com.SG_G1.BootcampDH.controller;

import com.SG_G1.BootcampDH.dto.FlightModelDTO;
import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createHotel(@RequestBody FlightModelDTO flightDTO) {
        MessageDTO message = flightService.saveEntity(flightDTO);
        return ResponseEntity.ok(message);
    }
    @PutMapping("/edit")
    public ResponseEntity<MessageDTO> updateHotel(@RequestParam("flightNumber") String hotelCode,
                                                  @RequestBody FlightModelDTO hotelDTO) {
        MessageDTO message = flightService.updateEntity(hotelCode, hotelDTO);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/")
    public ResponseEntity<List<FlightModelDTO>> getAll(){
        return ResponseEntity.ok(flightService.getAllEntities());
    }

    @GetMapping
    public List<FlightModelDTO> getAvailableFlight(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam("destination") String destination, @RequestParam("origin") String origin) {

        return flightService.findDate(dateFrom, dateTo, destination, origin);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<MessageDTO> deleteFlightByNumber(@RequestParam("flightNumber") String code) {
        MessageDTO message = flightService.deleteEntity(code);
        return ResponseEntity.ok(message);
    }


    //PRACTICA INDIVIDUAL
    @GetMapping("/city")
    public List<FlightModelDTO> getFlightByCity(@RequestParam("city") String destination) {
        return flightService.findDestination(destination);
    }

    @GetMapping("/type")
    public List<FlightModelDTO> getFlightBySeatType(@RequestParam("seatType") String seatType) {
        return flightService.findBySeatType(seatType);
    }

}
