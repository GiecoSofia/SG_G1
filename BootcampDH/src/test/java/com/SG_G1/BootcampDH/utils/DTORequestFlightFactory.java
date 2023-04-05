package com.SG_G1.BootcampDH.utils;

import com.SG_G1.BootcampDH.dto.FlightReservationModelDTO;
import com.SG_G1.BootcampDH.dto.PaymentMethodDTO;
import com.SG_G1.BootcampDH.dto.resquest.FlightRequestDTO;
import com.SG_G1.BootcampDH.model.PaymentMethod;
import com.SG_G1.BootcampDH.model.PeopleModel;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

public class DTORequestFlightFactory {

    public static FlightRequestDTO DTORequest6(){
        return FlightRequestDTO.builder()
                .userName("arjona@gmail.com")
                .flightReservation(flightReservation())
                .build();
    }

    private static PaymentMethodDTO paymentMethod() {
        return PaymentMethodDTO.builder()
                .type("CREDIT")
                .number("1234-1234-1234-1234")
                .dues(6)
                .build();
    }

    private static @Valid FlightReservationModelDTO flightReservation() {
        return FlightReservationModelDTO.builder()
                .dateFrom(LocalDate.parse("2022-02-10"))
                .dateTo(LocalDate.parse("2022-02-17"))
                .origin("Buenos Aires")
                .destination("Tucumán")
                .flightNumber("BATU-5536")
                .seats(2)
                .seatType("ECONOMY")
                .people((List.of(peopleDTO())))
                .paymentMethod(paymentMethod())
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

/*}*/



