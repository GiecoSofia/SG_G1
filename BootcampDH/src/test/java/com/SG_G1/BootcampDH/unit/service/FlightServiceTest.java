package com.SG_G1.BootcampDH.unit.service;

import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.FlightRepository;
import com.SG_G1.BootcampDH.repository.HotelRepository;
import com.SG_G1.BootcampDH.service.FlightService;
import com.SG_G1.BootcampDH.service.HotelService;
import com.SG_G1.BootcampDH.utils.FlightFactory;
import com.SG_G1.BootcampDH.utils.HotelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {
    @Mock
    FlightRepository flightRepository;

    @InjectMocks
    FlightService flightService;

    @Test
    @DisplayName("Testea que hay vuelos registrados")
    public void flightRepositoryListTest() {
        //arrange
        List<FlightModel> expected = FlightFactory.flightList();
        //act
        Mockito.lenient().when(flightRepository.getFlights()).thenReturn(FlightFactory.flightList());
        var result = flightService.flightRepositoryList();
        //assert
        Assertions.assertEquals(expected, result);
    }

   /* @Test
    @DisplayName("Testea que trae la excepción cuando la lista de vuelos viene vacia")*/

    @Test
    @DisplayName("Testeamos que nos traiga los vuelos disponibles en un rango de fechas, origen y destino")
    public void findDateTest(){
        //Arrange
        LocalDate dateFrom = LocalDate.parse("2022-02-10");
        LocalDate dateTo = LocalDate.parse("2023-02-15");
        String origin ="Buenos Aires" ;
        String destination = "Puerto Iguazú";

        List<FlightModel> expected = new ArrayList<>();
        FlightModel flight = FlightFactory.flight1();
        expected.add(flight);

        //Act
        Mockito.lenient().when(flightRepository.getFlights()).thenReturn(FlightFactory.flightList());
        var result = flightService.flightRepositoryListDisp(dateFrom,dateTo,origin,destination);


        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Testea que trae la excepción cuando los parametros no coinciden")
    public void flightRepositoryListWithEmptyTest(){
        //arrange
        LocalDate dateFrom = LocalDate.parse("2024-02-10");
        LocalDate dateTo = LocalDate.parse("2023-02-15");
        String origin ="Buenos Aires" ;
        String destination = "Santa Fe";


        //act
        Mockito.lenient().when(flightRepository.getFlights()).thenReturn(FlightFactory.flightList());

        //assert
        Assertions.assertThrows(ValidationParams.class,() -> flightService.flightRepositoryListDisp(dateFrom, dateTo,origin,destination));
    }
}