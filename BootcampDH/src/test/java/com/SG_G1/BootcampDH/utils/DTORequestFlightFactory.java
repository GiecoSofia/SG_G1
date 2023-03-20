package com.SG_G1.BootcampDH.utils;

import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.model.FlightReservationModel;
import com.SG_G1.BootcampDH.model.PaymentMethod;
import com.SG_G1.BootcampDH.model.PeopleModel;

import java.time.LocalDate;
import java.util.List;

import static com.SG_G1.BootcampDH.utils.DTOResponseFlightFactory.flightReservation;
import static com.SG_G1.BootcampDH.utils.DTOResponseFlightFactory.peopleDTO;

public class DTORequestFlightFactory {

    public static DTOrequest6 DTORequest6(){
        return DTOrequest6.builder()
                .userName("arjona@gmail.com")
                .flightReservation(flightReservation())
                .paymentMethod(paymentMethod())
                .build();
    }

    private static PaymentMethod paymentMethod() {
        return PaymentMethod.builder()
                .type("CREDIT")
                .number("1234-1234-1234-1234")
                .dues(6)
                .build();
    }

    private static FlightReservationModel flightReservation() {
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

    private static PeopleModel peopleDTO() {
        return PeopleModel.builder()
                .dni(42403088)
                .name("pepito")
                .lastName("gomez")
                .birthday("12/02/1999")
                .mail("pepito@gmail.com")
                .build();
    }

}



