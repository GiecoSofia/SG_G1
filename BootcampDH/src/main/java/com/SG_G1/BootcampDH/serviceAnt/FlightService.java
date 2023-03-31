package com.SG_G1.BootcampDH.serviceAnt;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class FlightService {
    @Autowired
    FlightRepository repository;

    public List<FlightModel> flightRepositoryList(){

        return repository.getFlights();

    }

    public List<FlightModel> flightRepositoryListDisp(LocalDate dateFrom, LocalDate dateTo, String origin, String destination){


        List<FlightModel> nuevaLista = new ArrayList<>();

        Validaciones(dateFrom,dateTo,origin,destination);

        for(FlightModel flight: repository.getFlights()){
            if(origin.equals(flight.getOrigin()) && destination.equals(flight.getDestination()) && dateFrom.equals(flight.getFrom()) && dateTo.equals(flight.getTo())){
                nuevaLista.add(flight);
            }
        }

        return nuevaLista;
    }

    public DTOresponsive6 flightReservation(DTOrequest6 flightReservation) {

        Validaciones(flightReservation.getFlightReservation().getDateFrom(), flightReservation.getFlightReservation().getDateTo(),flightReservation.getFlightReservation().getOrigin(), flightReservation.getFlightReservation().getDestination());

        DTOresponsive6 responsive = new DTOresponsive6();
        responsive.setUserName(flightReservation.getUserName());

        Long dias = DAYS.between(flightReservation.getFlightReservation().getDateFrom(), flightReservation.getFlightReservation().getDateTo());

        FlightModel flight = SearchFlight(flightReservation.getFlightReservation().getFlightNumber());

        double total = dias * flight.getPrice();

        responsive.setTotal(total);
        responsive.setFlightReservation(flightReservation.getFlightReservation());
        responsive.setStatus(new StatusCode(200, "El proceso termino satisfactoriamente"));

        return responsive;
    }


    private FlightModel SearchFlight(String flightNumber) {


        FlightModel flight = new FlightModel();

        for (FlightModel flight1 : repository.getFlights()) {

            if (flightNumber.equals(flight1.getCode())) {
                flight = flight1;
            }
        }
        return flight;
    }


    //Validaciones
    private void Validaciones(LocalDate dateFrom, LocalDate dateTo, String origin, String destination) {

        if (dateFrom.compareTo(dateTo) > 0) {
            throw new ValidationParams("La fecha de entrada debe ser menor a la de salida" +
                    "" + "La fecha de entrada debe ser mayor a la de entrada");
        }



        repository.getFlights().stream()
                .filter(flight -> flight.getOrigin().equals(origin))
                .findFirst().orElseThrow(() -> new ValidationParams("El origen elegido no existe"));




        repository.getFlights().stream()
                .filter(flight -> flight.getDestination().equals(destination))
                .findFirst().orElseThrow(() -> new ValidationParams("El destino elegido no existe"));


    }


}




