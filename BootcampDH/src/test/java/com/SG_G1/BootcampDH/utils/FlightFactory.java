package com.SG_G1.BootcampDH.utils;


import com.SG_G1.BootcampDH.dto.FlightModelDTO;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightFactory {
    public static FlightModelDTO flight13() {
        return FlightModelDTO.builder()
                .code("BAPI-1235")
                .origin("Buenos Aires")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .price(6500.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2023-02-15"))
                .build();
    }
    public static FlightModelDTO flight14() {
        return FlightModelDTO.builder()
                .code("PIBA-1420")
                .origin("Puerto Iguazú")
                .destination("Bogotá")
                .seatType("Business")
                .price(43200.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-02-20"))
                .build();
    }


    public static List<FlightModelDTO> flightList() {
        List<FlightModelDTO> lista = new ArrayList<>();
        lista.add(flight13());
        lista.add(flight14());

        return lista;
    }

}