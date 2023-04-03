package com.SG_G1.BootcampDH.utils;

import com.SG_G1.BootcampDH.dto.resquest.HotelRequestDTO;
import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.PaymentMethod;
import com.SG_G1.BootcampDH.model.PeopleModel;

import java.time.LocalDate;
import java.util.List;

public class DTORequestHotelFactory {
    public static HotelRequestDTO DTORequest3(){
        return HotelRequestDTO.builder()
                .userName("arjonamiguel@gmail.com")
                .booking(booking())
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

    private static BookingModel booking() {
        return BookingModel.builder()
                .dateFrom(LocalDate.parse("2022-04-17"))
                .dateTo(LocalDate.parse("2023-05-23"))
                .destination("Tucumán")
                .hotelCode("SH-0002")
                .peopleAmount(2)
                .roomType("DOUBLE")
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
