package com.SG_G1.BootcampDH.utils;

import com.SG_G1.BootcampDH.dto.responsive.FlightReservationDTO;
import com.SG_G1.BootcampDH.model.FlightReservationModel;
import com.SG_G1.BootcampDH.model.PeopleModel;
import com.SG_G1.BootcampDH.model.StatusCode;

import java.time.LocalDate;
import java.util.List;

public class DTOResponseFlightFactory {

    public static FlightReservationDTO DTOResponsive6() {
        return FlightReservationDTO.builder()
                .userName("arjona@gmail.com")
                .total(51240.0)
                .flightReservation(flightReservation())
                .status(StatusCodeDTO())
                .build();
    }

    private static StatusCode StatusCodeDTO() {
        return StatusCode.builder()
                .code(200)
                .message("El proceso termino satisfactoriamente")
                .build();
    }

    public static FlightReservationModel flightReservation(){
        return FlightReservationModel.builder()
                .dateFrom(LocalDate.parse("2022-02-10"))
                .dateTo(LocalDate.parse("2022-02-17"))
                .origin("Buenos Aires")
                .destination("Tucumán")
                .flightNumber("BATU-5536")
                .seats(2)
                .seatType("ECONOMY")
                .people((List.of(peopleDTO())))
                .build();

    }

    public static PeopleModel peopleDTO() {
        return PeopleModel.builder()
                .dni(42403088)
                .name("pepito")
                .lastName("gomez")
                .birthday("12/02/1999")
                .mail("pepito@gmail.com")
                .build();
    }

}

