package com.SG_G1.BootcampDH.service;


import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import com.SG_G1.BootcampDH.service.HotelService;
import com.SG_G1.BootcampDH.utils.HotelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {
    @Mock
    IHotelRepository hotelRepository;

    @InjectMocks
    HotelService hotelService;

    ModelMapper mapper = new ModelMapper();



    //Test de service requerimiento individual//
    // ---------------------------------------------//
    @Test
    public void testGetAllEntities() {
        //arrange
        List<HotelModel> hotelList = HotelFactory.hotelList();
        List<HotelModelDTO> expected = hotelList.stream().map(hotel -> mapper.map(hotel, HotelModelDTO.class)).collect(Collectors.toList());

        //act
        Mockito.lenient().when(hotelRepository.findAll()).thenReturn(hotelList);
        List<HotelModelDTO> result = hotelService.getAllEntities();

        //assert
        assertThat(result, containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void GetAllEntitiesTest() {
        //arrange
        List<HotelModel> hotelList = new ArrayList<>(); //Lista vacía
        Mockito.lenient().when(hotelRepository.findAll()).thenReturn(hotelList);

        //act & assert
        assertThrows(ValidationParams.class, () -> hotelService.getAllEntities());
    }

    @Test
    public void testGetEntityByCodeValid() {
        // Crear un objeto HotelModel simulado con un código de hotel válido
        HotelModel hotelValido = new HotelModel();
        hotelValido.setCode("ABC123");

        // Configurar el objeto HotelRepository simulado para que devuelva el objeto HotelModel simulado cuando se llame a findByCode("ABC123")
        when(hotelRepository.findByCode("ABC123")).thenReturn(Optional.of(hotelValido));
        // Llamar al método getEntityByCode() con el código de hotel válido
        HotelModelDTO hotelDTO = hotelService.getEntityByCode("ABC123");

        // Verificar que se devolvió un objeto HotelModelDTO con los datos esperados
        assertEquals("ABC123", hotelDTO.getCode());
    }

    @Test
    public void testGetEntityByCodeInvalid() {
        // Configurar el objeto HotelRepository simulado para que no encuentre ningún hotel cuando se llame a findByCode("XYZ789")
        when(hotelRepository.findByCode("XYZ789")).thenReturn(Optional.empty());

        // Llamar al método getEntityByCode() con un código de hotel no válido y verificar que se lance una excepción de tipo ValidationParams
        assertThrows(ValidationParams.class, () -> hotelService.getEntityByCode("XYZ789"));
    }

    @Test
    public void testFindDate() {
        LocalDate dateFrom = LocalDate.parse("2022-02-10");
        LocalDate dateTo = LocalDate.parse("2023-02-15");
        String place = "Buenos Aires";

        List<HotelModel> hotels = new ArrayList<>();
        hotels.add(new HotelModel("Hotel1", "Buenos Aires", LocalDate.parse("2022-02-10"), LocalDate.parse("2023-02-15"), 100.0));
        hotels.add(new HotelModel("Hotel2", "Buenos Aires", LocalDate.parse("2022-02-10"), LocalDate.parse("2023-02-15"), 200.0));

        Mockito.when(hotelRepository.findByFromEqualsAndToEqualsAndPlaceEquals(dateFrom, dateTo, place))
                .thenReturn(hotels);

        HotelModelDTO hotelADTO = new HotelModelDTO("Hotel1", "Buenos Aires", LocalDate.parse("2022-02-10"), LocalDate.parse("2023-02-15"), 100.0);
        HotelModelDTO hotelBDTO = new HotelModelDTO("Hotel2", "Buenos Aires", LocalDate.parse("2022-02-10"), LocalDate.parse("2023-02-15"), 200.0);
        List<HotelModelDTO> expected = new ArrayList<>();
        expected.add(hotelADTO);
        expected.add(hotelBDTO);


        List<HotelModelDTO> result = hotelService.findDate(dateFrom, dateTo, place);


        assertEquals(expected, result);
    }

}













