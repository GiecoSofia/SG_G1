package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.FlightRepository;
import com.SG_G1.BootcampDH.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    public List<FlightModel> flightRepositoryList(){
        FlightRepository lista = new FlightRepository();

        return lista.getFlights();

    }

    public List<FlightModel> flightRepositoryListDisp(String from, String to, String destination){
        FlightRepository lista = new FlightRepository();
        List<FlightModel> nuevaLista = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dateFrom = LocalDate.parse(from,formatter);

        LocalDate dateTo = LocalDate.parse(to,formatter);

        for(FlightModel flight: lista.getFlights()){
            if(destination.equals(flight.getDestination()) && dateFrom.equals(flight.getFrom()) && dateTo.equals(flight.getTo())){
                nuevaLista.add(flight);
            }
        }
        return nuevaLista;
    }
}

