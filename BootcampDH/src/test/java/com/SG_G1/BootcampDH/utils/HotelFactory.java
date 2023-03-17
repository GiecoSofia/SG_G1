package com.SG_G1.BootcampDH.utils;

import com.SG_G1.BootcampDH.model.HotelModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {
    public static HotelModel hotel1(){
        return HotelModel.builder()
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
    public static HotelModel hotel2(){
        return HotelModel.builder()
                .code("CH-0003")
                .name("Cataratas Hotel")
                .place("Puerto Iguazú")
                .type("Triple")
                .price(8200.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-03-23"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel3(){
        return HotelModel.builder()
                .code("HD-0001")
                .name("Hotel Bristol")
                .place("Buenos Aires")
                .type("Single")
                .price(5635.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-03-19"))
                .booking(false)
                .build();
    }public static HotelModel hotel4(){
        return HotelModel.builder()
                .code("BH-0002")
                .name("Hotel Bristol2")
                .place("Buenos Aires")
                .type("Doble")
                .price(7200.0)
                .from(LocalDate.parse("2022-02-12"))
                .to(LocalDate.parse("2022-04-17"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel5(){
        return HotelModel.builder()
                .code("SH-0002")
                .name("Sheraton")
                .place("Tucumán")
                .type("Doble")
                .price(5790.0)
                .from(LocalDate.parse("2022-04-17"))
                .to(LocalDate.parse("2022-05-23"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel6(){
        return HotelModel.builder()
                .code("SH-0001")
                .name("Sheraton 2")
                .place("Tucumán")
                .type("Single")
                .price(4500.0)
                .from(LocalDate.parse("2022-01-02"))
                .to(LocalDate.parse("2022-02-17"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel7(){
        return HotelModel.builder()
                .code("SE-0001")
                .name("Selina")
                .place("Bogota")
                .type("Single")
                .price(3900.0)
                .from(LocalDate.parse("2022-01-23"))
                .to(LocalDate.parse("2022-11-23"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel8(){
        return HotelModel.builder()
                .code("SE-0002")
                .name("Selina 2")
                .place("Bogotá")
                .type("Doble")
                .price(5840.0)
                .from(LocalDate.parse("2022-01-23"))
                .to(LocalDate.parse("2022-10-15"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel9(){
        return HotelModel.builder()
                .code("EC-0003")
                .name("El Campín")
                .place("Bogotá")
                .type("Triple")
                .price(7020.0)
                .from(LocalDate.parse("2022-02-15"))
                .to(LocalDate.parse("2022-03-27"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel10(){
        return HotelModel.builder()
                .code("CP-0004")
                .name("Central Plaza")
                .place("Medellin")
                .type("Multiple")
                .price(8600.0)
                .from(LocalDate.parse("2022-03-01"))
                .to(LocalDate.parse("2022-04-17"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel11(){
        return HotelModel.builder()
                .code("CP-0002")
                .name("Central Plaza 2")
                .place("Medellin")
                .type("Doble")
                .price(6400.0)
                .from(LocalDate.parse("2022-02-10"))
                .to(LocalDate.parse("2022-03-20"))
                .booking(false)
                .build();
    }
    public static HotelModel hotel12(){
        return HotelModel.builder()
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
    public static List<HotelModel>hotelList(){
        List<HotelModel> lista = new ArrayList<>();
        lista.add(hotel1());
        lista.add(hotel2());
        lista.add(hotel3());
        lista.add(hotel4());
        lista.add(hotel5());
        lista.add(hotel6());
        lista.add(hotel7());
        lista.add(hotel8());
        lista.add(hotel9());
        lista.add(hotel10());
        lista.add(hotel11());
        lista.add(hotel12());

        return lista;
    }
    public static List<HotelModel>hotelListNull(){
        List<HotelModel> lista = new ArrayList<>();

        return lista;
    }

}

