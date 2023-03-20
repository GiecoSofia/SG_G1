package com.SG_G1.BootcampDH.utils;


import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightFactory {
    public static FlightModel flight1() {
        return FlightModel.builder()
                .code("BAPI-1235")
                .origin("Buenos Aires")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .price(6500.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2023-02-15"))
                .build();
    }
    public static FlightModel flight2() {
        return FlightModel.builder()
                .code("PIBA-1420")
                .origin("Puerto Iguazú")
                .destination("Bogotá")
                .seatType("Business")
                .price(43200.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-02-20"))
                .build();
    }
    public static FlightModel flight3() {
        return FlightModel.builder()
                .code("PIBA-1420")
                .origin("Puerto Iguazú")
                .destination("Bogotá")
                .seatType("Economy")
                .price(25735.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-02-21"))
                .build();
    }
    public static FlightModel flight4() {
        return FlightModel.builder()
                .code("BATU-5536")
                .origin("Buenos Aires")
                .destination("Tucumán")
                .seatType("Economy")
                .price(7320.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-02-17"))
                .build();
    }
    public static FlightModel flight5() {
        return FlightModel.builder()
                .code("TUPI-3369")
                .origin("Tucumán")
                .destination("Puerto Iguazú")
                .seatType("Business")
                .price(12530.0)
                .from(LocalDate.parse("2022-02-12"))
                .to(LocalDate.parse("2022-02-23"))
                .build();
    }

    public static FlightModel flight6() {
        return FlightModel.builder()
                .code("TUPI-3369")
                .origin("Tucumán")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .price(5400.0)
                .from(LocalDate.parse("2022-01-02"))
                .to(LocalDate.parse("2022-01-16"))
                .build();
    }

    public static FlightModel flight7() {
        return FlightModel.builder()
                .code("BOCA-4213")
                .origin("Bogotá")
                .destination("Cartagena")
                .seatType("Economy")
                .price(8000.0)
                .from(LocalDate.parse("2022-01-23"))
                .to(LocalDate.parse("2022-02-05"))
                .build();
    }
    public static FlightModel flight8() {
        return FlightModel.builder()
                .code("CAME-0321")
                .origin("Cartagena")
                .destination("Medellín")
                .seatType("Economy")
                .price(7800.0)
                .from(LocalDate.parse("2022-01-23"))
                .to(LocalDate.parse("2022-01-31"))
                .build();
    }

    public static FlightModel flight9() {
        return FlightModel.builder()
                .code("BOBA-6567")
                .origin("Bogotá")
                .destination("Buenos Aires")
                .seatType("Business")
                .price(57000.0)
                .from(LocalDate.parse("2022-02-15"))
                .to(LocalDate.parse("2022-02-28"))
                .build();
    }

    public static FlightModel flight10() {
        return FlightModel.builder()
                .code("BOBA-6567")
                .origin("Bogotá")
                .destination("Buenos Aires")
                .seatType("Economy")
                .price(39860.0)
                .from(LocalDate.parse("2022-03-01"))
                .to(LocalDate.parse("2022-03-14"))
                .build();
    }

    public static FlightModel flight11() {
        return FlightModel.builder()
                .code("BOME-4442")
                .origin("Bogotá")
                .destination("Medellín")
                .seatType("Economy")
                .price(11000.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-02-24"))
                .build();
    }
    public static FlightModel flight12() {
        return FlightModel.builder()
                .code("MEPI-9986")
                .origin("Medellín")
                .destination("Puerto Iguazú")
                .seatType("Business")
                .price(41640.0)
                .from(LocalDate.parse("2022-04-17"))
                .to(LocalDate.parse("2022-05-02"))
                .build();
    }



    public static List<FlightModel> flightList() {
        List<FlightModel> lista = new ArrayList<>();
        lista.add(flight1());
        lista.add(flight2());
        lista.add(flight3());
        lista.add(flight4());
        lista.add(flight5());
        lista.add(flight6());
        lista.add(flight7());
        lista.add(flight8());
        lista.add(flight9());
        lista.add(flight10());
        lista.add(flight11());
        lista.add(flight12());

        return lista;
    }


}