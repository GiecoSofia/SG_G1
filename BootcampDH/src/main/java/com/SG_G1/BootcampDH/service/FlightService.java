package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.model.StatusCode;
import com.SG_G1.BootcampDH.repository.FlightRepository;
import com.SG_G1.BootcampDH.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
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

        LocalDate dateFrom = null;

        LocalDate dateTo = null;
        try {
            dateFrom = LocalDate.parse(from,formatter);

            dateTo = LocalDate.parse(to,formatter);
        } catch (DateTimeParseException exception) {
            throw new RuntimeException("La formato de la fecha es invalido, dd/MM/yyyy ");
        }
        for(FlightModel flight: lista.getFlights()){
            if(destination.equals(flight.getDestination()) && dateFrom.equals(flight.getFrom()) && dateTo.equals(flight.getTo())){
                nuevaLista.add(flight);
            }
        }
        return nuevaLista;
    }

    public DTOresponsive6 flightReservation(DTOrequest6 flightReservation){
        DTOresponsive6 responsive = new DTOresponsive6();
        responsive.setUserName(flightReservation.getUserName());

        double total ;

        ZoneId defaultZoneId = ZoneId.systemDefault();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        ParsePosition position = new ParsePosition(0);
        ParsePosition position1 = new ParsePosition(0);

        System.out.println(flightReservation.getFlightReservation().getDateTo());
        System.out.println(flightReservation.getFlightReservation().getDateFrom());

        Date fechaActual = null;

        Date fechaInicio = null;
        try {
            fechaActual = formato.parse(flightReservation.getFlightReservation().getDateTo(),position);

            fechaInicio = formato.parse(flightReservation.getFlightReservation().getDateFrom(),position1);

        }catch (DateTimeParseException exception){
            throw new RuntimeException("La formato de la fecha es invalido, dd/MM/yyyy ");
        }

        int dias = (int) ((fechaActual.getTime()-fechaInicio.getTime()) / 86400000);

        FlightRepository flights = new FlightRepository();

        FlightModel flight = new FlightModel();

        for (FlightModel flight1:flights.getFlights()) {
            System.out.println(flightReservation.getFlightReservation().getFlightNumber());
            System.out.println(flight1.getCode());
            if (flightReservation.getFlightReservation().getFlightNumber().equals(flight1.getCode())){
                flight = flight1;
            }
        }
        System.out.println(flight);
        total = dias * flight.getPrice();


        responsive.setTotal(total);


        responsive.setFlightReservation(flightReservation.getFlightReservation());

        responsive.setStatus(new StatusCode(200,"El proceso termino satisfactoriamente"));

        return responsive;
    }
}

