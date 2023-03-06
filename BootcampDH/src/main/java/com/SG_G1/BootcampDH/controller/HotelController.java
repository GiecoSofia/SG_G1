package com.SG_G1.BootcampDH.controller;


import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/api/v1/hotels")
    public ResponseEntity<List<HotelModel>> listHotel(){
        return new ResponseEntity<>(hotelService.hotelRepositoryList(), HttpStatus.OK);
    }

    @GetMapping ("/api/v1/hotelss")
    public ResponseEntity<List<HotelModel>> listHotelDips(@RequestParam String dateFrom,
                                                          @RequestParam String dateTo,
                                                          @RequestParam String destination){
        return new ResponseEntity<>(hotelService.hotelRepositoryListDisp(dateFrom, dateTo, destination), HttpStatus.OK);
    }
}
