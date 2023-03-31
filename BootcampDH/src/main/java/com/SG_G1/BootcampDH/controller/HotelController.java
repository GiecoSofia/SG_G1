package com.SG_G1.BootcampDH.controller;


import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@Validated

public class HotelController {
    @Autowired
    private HotelService hotelService;


    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createHotel(@RequestBody HotelModelDTO hotelDTO) {
        hotelService.saveEntity(hotelDTO);
        MessageDTO message = MessageDTO.builder()
                .message("Hotel dado de alta correctamente")
                .build();
        return ResponseEntity.ok(message);
    }
    }

   /* @GetMapping("/api/v1/hotels")
    public ResponseEntity<List<HotelModel>> listHotel(){
        List<HotelModel> hoteles = hotelService.hotelRepositoryList();
        if(hoteles.isEmpty()){
            throw new NullPointerException();

        }
        return new ResponseEntity<>(hoteles, HttpStatus.OK);
    }

    @GetMapping ("/api/v1/hotelss")
    public ResponseEntity<List<HotelModel>> listHotelDips(@RequestParam ("dateFrom") @DateTimeFormat(pattern = "dd/MM/yyyy")  LocalDate dateFrom ,
                                                          @RequestParam ("dateTo") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
                                                          @RequestParam String destination){





        List<HotelModel> hoteles = hotelService.hotelRepositoryListDisp(dateFrom,dateTo, destination);
        if(hoteles.isEmpty()){
            throw new NullPointerException();

        }
        return new ResponseEntity<>(hoteles, HttpStatus.OK);
    }
    //Us006
    @PostMapping("/api/v1/booking")
    public ResponseEntity<DTOresponsive3> booking(@RequestBody @Valid DTOresquest3 booking){
        return new ResponseEntity<>(hotelService.booking(booking), HttpStatus.OK);
    }*/


