package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.StatusCode;
import com.SG_G1.BootcampDH.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class FlightService {

    @Autowired
    public List<FlightModel> flightRepositoryList(){
        FlightRepository lista = new FlightRepository();

        return lista.getFlights();

    }

    public List<FlightModel> flightRepositoryListDisp(LocalDate dateFrom, LocalDate dateTo, String destination){
        FlightRepository lista = new FlightRepository();
        List<FlightModel> nuevaLista = new ArrayList<>();

        for(FlightModel flight: lista.getFlights()){
            if(destination.equals(flight.getDestination()) && dateFrom.equals(flight.getFrom()) && dateTo.equals(flight.getTo())){
                nuevaLista.add(flight);
            }
        }
        return nuevaLista;
    }

    public DTOresponsive6 flightReservation(DTOrequest6 flightReservation) {

        Validaciones(flightReservation.getFlightReservation().getDateFrom(), flightReservation.getFlightReservation().getDateTo(), flightReservation.getFlightReservation().getDestination());

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
        FlightRepository flights = new FlightRepository();

        FlightModel flight = new FlightModel();

        for (FlightModel flight1 : flights.getFlights()) {

            if (flightNumber.equals(flight1.getCode())) {
                flight = flight1;
            }
        }
        return flight;
    }


    //Validaciones
    private void Validaciones(LocalDate dateFrom, LocalDate dateTo, String destination) {

        if (dateFrom.compareTo(dateTo) > 0) {
            throw new ValidationParams("La fecha de entrada debe ser menor a la de salida" +
                    "" + "La fecha de entrada debe ser mayor a la de entrada");
        }

        //FlightRepository listaOrigen = new FlightRepository(); falta agregar los parametros en el controller
        // para terminar esta validacion, intente pero tiraba error :/


        FlightRepository listaDestino = new FlightRepository();

        listaDestino.getFlights().stream()
                .filter(flight -> flight.getDestination().equals(destination))
                .findFirst().orElseThrow(() -> new ValidationParams("El destino elegido no existe"));


    }


}




