package com.SG_G1.BootcampDH.repository;

import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private List<FlightModel> flights;

    public FlightRepository() {
        this.flights = this.agregar();
    }

    public List<FlightModel> getFlights() {

        return flights;
    }

    public List<FlightModel> agregar(){
        FlightModel flight1 = new FlightModel(
                "BAPI-1235", "Buenos Aires", "Puerto Iguazú", "Economy", 6500.0, LocalDate.of(2022, 02, 10), LocalDate.of(2023, 02, 15)
        );
        FlightModel flight2 = new FlightModel(
                "PIBA-1420", "Puerto Iguazú", "Bogotá", "Business", 43200.0, LocalDate.of(2022,02,10), LocalDate.of(2022,02,20)
        );
        FlightModel flight3 = new FlightModel(
                "PIBA-1420", "Puerto Iguazú", "Bogotá", "Economy", 25735.00, LocalDate.of(2022,02,10), LocalDate.of(2022,02,21)
        );
        FlightModel flight4 = new FlightModel(
                "BATU-5536", "Buenos Aires", "Tucumán", "Economy", 7320.00, LocalDate.of(2022,02,10), LocalDate.of(2022,02,17)
        );
        FlightModel flight5 = new FlightModel(
                "TUPI-3369", "Tucumán", "Puerto Iguazú", "Business", 12530.0, LocalDate.of(2022,02,12), LocalDate.of(2022,02,23)
        );
        FlightModel flight6 = new FlightModel(
                "TUPI-3369", "Tucumán", "Puerto Iguazú", "Economy", 5400.0, LocalDate.of(2022,01,02), LocalDate.of(2022,01,16)
        );
        FlightModel flight7 = new FlightModel(
                "BOCA-4213", "Bogotá", "Cartagena", "Economy", 8000.00, LocalDate.of(2022,01,23), LocalDate.of(2022,02,5)
        );
        FlightModel flight8 = new FlightModel(
                "CAME-0321", "Cartagena", "Medellín", "Economy", 7800.00, LocalDate.of(2022,01,23), LocalDate.of(2022,01,31)
        );
        FlightModel flight9 = new FlightModel(
                "BOBA-6567", "Bogotá", "Buenos Aires", "Business", 57000.00, LocalDate.of(2022,02,15), LocalDate.of(2022,02,28)
        );
        FlightModel flight10 = new FlightModel(
                "BOBA-6567", "Bogotá", "Buenos Aires", "Economy", 39860.00, LocalDate.of(2022,03,01), LocalDate.of(2022,03,14)
        );
        FlightModel flight11 = new FlightModel(
                "BOME-4442", "Bogotá", "Medellín", "Economy", 11000.00, LocalDate.of(2022,02,10), LocalDate.of(2022,02,24)
        );
        FlightModel flight12 = new FlightModel(
                "MEPI-9986", "Medellín", "Puerto Iguazú", "Business", 41640.00, LocalDate.of(2022,04,17), LocalDate.of(2022,05,02)
        );

        List<FlightModel> lista = new ArrayList<>();

        lista.add(flight1);
        lista.add(flight2);
        lista.add(flight3);
        lista.add(flight4);
        lista.add(flight5);
        lista.add(flight6);
        lista.add(flight7);
        lista.add(flight8);
        lista.add(flight9);
        lista.add(flight10);
        lista.add(flight11);
        lista.add(flight12);

        return lista;

    }
    public List<FlightModel> flightList;
}
