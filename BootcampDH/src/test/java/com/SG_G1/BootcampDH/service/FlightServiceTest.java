package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.FlightModelDTO;
import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.IFlightRepository;
import com.SG_G1.BootcampDH.service.FlightService;
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
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {
    @Mock
    IFlightRepository flightRepository;

    @InjectMocks
    FlightService flightService;

    ModelMapper mapper = new ModelMapper();

    @Test
    void testGetAllEntities() {
        //arrange
        List<FlightModel> flightList = FlightFactory.flightList();
        List<FlightModelDTO> expected = flightList.stream().map(flight -> mapper.map(flight, FlightModelDTO.class)).collect(Collectors.toList());
        //act
        Mockito.lenient().when(flightRepository.findAll()).thenReturn(FlightFactory.flightList());
        var result = flightService.getAllEntities();

        //Assert
        assertEquals(expected, result);

    }

    //Testeo de service requerimiento individual
    @Test
    public void findAll() {
        // Crear una lista de objetos FlightModel simulados con un número de vuelo válido
        List<FlightModel> flightsValidos = new ArrayList<>();
        FlightModel flightValido1 = new FlightModel();
        flightValido1.setCode("ABC123");
        flightsValidos.add(flightValido1);
        FlightModel flightValido2 = new FlightModel();
        flightValido2.setCode("ABC123");
        flightsValidos.add(flightValido2);

        // Configurar el objeto FlightRepository simulado para que devuelva la lista de objetos FlightModel simulados cuando se llame a findAllByCode("ABC123")
        when(flightRepository.findAllByCode("ABC123")).thenReturn(flightsValidos);
        List<FlightModelDTO> flightDTOs = flightService.getEntitiesByCode("ABC123");

        // Verificar que se devolvió una lista de objetos FlightModelDTO con los datos esperados
        assertEquals(2, flightDTOs.size());
        assertEquals("ABC123", flightDTOs.get(0).getCode());
        assertEquals("ABC123", flightDTOs.get(1).getCode());
    }

    @Test
    public void EntitiesByCodeInvalid() {
        // Configurar el objeto FlightsRepository simulado para que no encuentre ningún vuelo cuando se llame a findAllByCode("XYZ789")
        when(flightRepository.findAllByCode("XYZ789")).thenReturn(Collections.emptyList());

        // Llamar al método getEntitiesByCode() con un código de vuelo no válido
        Throwable exception = assertThrows(ValidationParams.class, () -> flightService.getEntitiesByCode("XYZ789"));

        // Verificar que la excepción lanzada contiene el mensaje esperado
        assertEquals("No se encontraron vuelos con el código XYZ789", exception.getMessage());
    }

    @Test
    public void testFindDate() {
        // Arrange
        LocalDate from = LocalDate.parse("2023-04-01");
        LocalDate to = LocalDate.parse("2023-04-05");
        String destination = "New York";
        String origin = "London";

        List<FlightModel> availableFlights = new ArrayList<>();
        FlightModel flight1 = new FlightModel("AA123", from, to, origin, destination);
        availableFlights.add(flight1);
        // Act
        Mockito.when(flightRepository.findByFromEqualsAndToEqualsAndDestinationEqualsAndOriginEquals(from, to, destination, origin))
                .thenReturn(availableFlights);
        List<FlightModelDTO> expected = availableFlights.stream()
                .map(flight -> mapper.map(flight, FlightModelDTO.class))
                .collect(Collectors.toList());
        List<FlightModelDTO> result = flightService.findDate(from, to, destination, origin);

        // Assert
        Assertions.assertEquals(expected, result);
    }




}

