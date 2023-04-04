package com.SG_G1.BootcampDH.controller;


import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.service.HotelBookingService;
import com.SG_G1.BootcampDH.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelBookingService bookingService;


    @PostMapping("/new/")
    public ResponseEntity<MessageDTO> createHotel(@RequestBody HotelModelDTO hotelDTO) {
        MessageDTO message = hotelService.saveEntity(hotelDTO);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit")
    public ResponseEntity<MessageDTO> updateHotel(@RequestParam("hotelCode") String hotelCode,
                                                  @RequestBody HotelModelDTO hotelDTO) {
        MessageDTO message = hotelService.updateEntity(hotelCode, hotelDTO);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/")
    public ResponseEntity<List<HotelModelDTO>> getAll(){
        return ResponseEntity.ok(hotelService.getAllEntities());
    }


    @GetMapping
    public List<HotelModelDTO> getAvailableHotels(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam("destination") String destination) {

        return hotelService.findDate(dateFrom, dateTo , destination);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<MessageDTO> deleteHotelByCode(@RequestParam("hotelCode") String code) {
        MessageDTO message = hotelService.deleteEntity(code);
        return ResponseEntity.ok(message);
    }


    //PRACTICA INDIVIDUAL
    @GetMapping("/city")
    public List<HotelModelDTO> getHotelByCity(@RequestParam("city") String place) {
        return hotelService.findPlace(place);
    }


    @GetMapping("/type")
    public List<HotelModelDTO> getHotelByRoomType(@RequestParam("type") String type) {
        return hotelService.findByRoomType(type);
    }

}



