package com.SG_G1.BootcampDH.unit.service;

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
}