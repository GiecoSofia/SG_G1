package com.SG_G1.BootcampDH.unit.service;
import com.SG_G1.BootcampDH.dto.FlightModelDTO;
import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.repository.IFlightRepository;
import com.SG_G1.BootcampDH.service.FlightService;
import com.SG_G1.BootcampDH.utils.FlightFactory;
import com.SG_G1.BootcampDH.utils.HotelFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {
    @Mock
    IFlightRepository flightRepository;

    @InjectMocks
    FlightService flightService;


    @Test
    public void saveEntityTest() {
        //arrange
        FlightModelDTO flight = FlightFactory.flight13();
        MessageDTO expected = MessageDTO.builder()
                .message("El vuelo se dio de alta correctamente.")
                .build();

        //act
        Mockito.lenient().when(flightRepository.findByDestinationAndOriginAndFromAndTo(flight.getDestination(), flight.getOrigin(), flight.getTo(), flight.getFrom())).thenReturn(null);
        Mockito.lenient().when(flightRepository.countFlightsReservationByHotelCode(flight.getCode())).thenReturn(new Long(0));

        var result = flightService.saveEntity(flight);

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void findDestinationTest() {
        //arrange
        String destination = "Bogotá";
        FlightModelDTO flight13 = FlightFactory.flight13();
        FlightModelDTO flight14 = FlightFactory.flight13();
        List<FlightModelDTO> flightList = Arrays.asList(flight13, flight14);

        //act
        Mockito.lenient().when(flightRepository.findByDestinationEquals(destination)).thenReturn(Collections.emptyList());

        //assert
        try {
            flightService.findDestination(destination);
        } catch (ValidationParams ex) {
            assertEquals("No hay vuelos disponibles para el destino indicado", ex.getMessage());
        }
    }

    @Test
    public void findBySeatTypeTest() {
        String seatType = "Business";
        FlightModelDTO flight13 = FlightFactory.flight13();
        FlightModelDTO flight14 = FlightFactory.flight13();
        List<FlightModelDTO> flightList = Arrays.asList(flight13, flight14);

        Mockito.lenient().when(flightRepository.findBySeatTypeEquals(seatType)).thenReturn(Collections.emptyList());

        try {
            flightService.findBySeatType(seatType);
        } catch (ValidationParams ex) {
            assertEquals("No existe ese tipo de habitacion", ex.getMessage());
        }
    }
}


