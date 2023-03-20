package com.SG_G1.BootcampDH.unit.controller;

import com.SG_G1.BootcampDH.controller.FlightController;
import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.repository.FlightRepository;
import com.SG_G1.BootcampDH.service.FlightService;
import com.SG_G1.BootcampDH.utils.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlightControllerTest {
    @Mock
    FlightService servicio;

    @InjectMocks
    FlightController controller;

    @Test
    @DisplayName("Testea que hay vuelos registrados")
    public void flightServiceListTest() {
        //arrange
        var expected = new ResponseEntity<>(FlightFactory.flightList(), HttpStatus.OK);
        //act
        Mockito.lenient().when(servicio.flightRepositoryList()).thenReturn(FlightFactory.flightList());
        var result = controller.listFlight();
        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testea que trae la excepción cuando la lista de hoteles viene vacia")
    public void hotelServiceListWithEmptyTest() {
        //arrange
        var expected = HotelFactory.hotelList();
        //act
        Mockito.lenient().when(servicio.flightRepositoryList()).thenReturn(FlightFactory.flightList());

        //assert
        Assertions.assertThrows(NullPointerException.class, () -> controller.listFlight());

    }

    @Test
    @DisplayName("Testeamos que nos traiga los vuelos disponibles en un rango de fechas, origen y destino")
    public void findDateTest(){
        //Arrange
        LocalDate dateFrom = LocalDate.parse("2022-02-10");
        LocalDate dateTo = LocalDate.parse("2023-02-15");
        String origin ="Buenos Aires" ;
        String destination = "Puerto Iguazú";


        FlightModel flight = FlightFactory.flight1();
        List<FlightModel> flights = new ArrayList<>();
        flights.add(flight);
        var expected = new ResponseEntity<>(flights, HttpStatus.OK);

        //Act
        Mockito.lenient().when(servicio.flightRepositoryListDisp(dateFrom,dateTo,origin,destination)).thenReturn(flights);
        var result = controller.listFlightDisp(dateFrom,dateTo,origin,destination);


        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Testeamos cuando se da de alta la nueva reserva")
    public void FlightReservationTest() {
        //arrange
        DTOrequest6 params = DTORequestFlightFactory.DTORequest6();
        var expected =  new ResponseEntity<>(DTOResponseFlightFactory.DTOResponsive6(), HttpStatus.OK);

        //act
        Mockito.lenient().when(servicio.flightReservation(params)).thenReturn(DTOResponseFlightFactory.DTOResponsive6());
        var result = controller.flightReservation(params);


        //assert
        Assertions.assertEquals(expected, result);

    }
}
