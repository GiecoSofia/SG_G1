package com.SG_G1.BootcampDH.controller;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/api/v1/flights")
    public ResponseEntity<List<FlightModel>> listFlight(){
        return new ResponseEntity<>(flightService.flightRepositoryList(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/flightss")
    public ResponseEntity<List<FlightModel>> listFlightDisp(@RequestParam String dateFrom,
                                                            @RequestParam String dateTo,
                                                            @RequestParam String destination){
        return new ResponseEntity<>(flightService.flightRepositoryListDisp(dateFrom,dateTo,destination), HttpStatus.OK);
    }

    @PostMapping("/api/v1/flight-reservation")
    public ResponseEntity<DTOresponsive6> flightReservation(@RequestBody DTOrequest6 flightReservation){
        return new ResponseEntity<>(flightService.flightReservation(flightReservation), HttpStatus.OK);
    }

}
