package com.SG_G1.BootcampDH.utils;

import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {
    public static HotelModelDTO hotel13() {
        return HotelModelDTO.builder()
                .code("BG-0004")
                .name("Bocagranue")
                .place("Cartagena")
                .type("Multiple")
                .price(9370.0)
                .from(LocalDate.parse("2022-04-17"))
                .to(LocalDate.parse("2022-06-12"))
                .booking(false)
                .build();
    }

    public static HotelModelDTO hotel14() {
        return HotelModelDTO.builder()
                .code("CH-0002")
                .name("Cataratas Hotel")
                .place("Puerto Iguazú")
                .type("Doble")
                .price(6300.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2023-03-20"))
                .booking(false)
                .build();
    }

    public static List<HotelModelDTO> hotelList() {
        List<HotelModelDTO> lista = new ArrayList<>();

        lista.add(hotel13());
        lista.add(hotel14());

        return lista;

    }
}

