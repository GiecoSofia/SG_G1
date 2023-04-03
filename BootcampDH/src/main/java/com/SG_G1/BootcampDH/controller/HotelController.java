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

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<MessageDTO> deleteHotelByCode(@PathVariable String code) {
        MessageDTO message = hotelService.deleteEntity(code);
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


