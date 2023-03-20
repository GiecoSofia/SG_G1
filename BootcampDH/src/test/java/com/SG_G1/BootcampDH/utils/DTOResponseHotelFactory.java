package com.SG_G1.BootcampDH.utils;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.model.*;

import java.time.LocalDate;
import java.util.List;

public class DTOResponseHotelFactory {
    public static DTOresponsive3 DTOResponsive3() {
        return DTOresponsive3.builder()
                .userName("arjonamiguel@gmail.com")
                .total(2321790.0)
                .booking(booking())
                .status(statusCode())
                .build();
    }

    private static StatusCode statusCode() {
        return StatusCode.builder()
                .code(200)
                .message("El proceso termino satisfactoriamente")
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
