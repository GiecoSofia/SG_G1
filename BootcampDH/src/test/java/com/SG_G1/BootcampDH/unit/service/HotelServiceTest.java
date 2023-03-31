package com.SG_G1.BootcampDH.unit.service;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive6;
import com.SG_G1.BootcampDH.dto.resquest.DTOrequest6;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.HotelRepository;
import com.SG_G1.BootcampDH.service.HotelService;
import com.SG_G1.BootcampDH.utils.*;
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
public class HotelServiceTest {
    @Mock
    HotelRepository hotelRepository;

    @InjectMocks
    HotelService hotelService;



    @Test
    @DisplayName("Testea que hay hoteles registrados")
    public void hotelRepositoryListTest(){
        //arrange
        List<HotelModel> expected = HotelFactory.hotelList();
        //act
        Mockito.lenient().when(hotelRepository.getHotels()).thenReturn(HotelFactory.hotelList());
        var result = hotelService.hotelRepositoryList();
        //assert
        Assertions.assertEquals(expected, result);
    }


    @Test
    @DisplayName("Testeamos que nos traiga los hoteles disponibles en un rango de fechas y destino")
    public void findDateTest(){
        //Arrange
        LocalDate dateFrom = LocalDate.parse("2022-02-10");
        LocalDate dateTo = LocalDate.parse("2023-03-20");
        String place ="Puerto Iguazú" ;

        List<HotelModel> expected = new ArrayList<>();
        HotelModel hotel = HotelFactory.hotel1();
        expected.add(hotel);

        //Act
        Mockito.lenient().when(hotelRepository.getHotels()).thenReturn(HotelFactory.hotelList());
        var result = hotelService.hotelRepositoryListDisp(dateFrom,dateTo,place);


        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Testea que trae la excepción cuando los parametros no coinciden")
    public void hotelRepositoryListWithEmptyTest(){
        //arrange
        LocalDate dateFrom = LocalDate.parse("2024-02-10");
        LocalDate dateTo = LocalDate.parse("2023-03-20");
        String place ="Catamarca" ;


        //act
        Mockito.lenient().when(hotelRepository.getHotels()).thenReturn(HotelFactory.hotelList());

        //assert
        Assertions.assertThrows(ValidationParams.class,() -> hotelService.hotelRepositoryListDisp(dateFrom,dateTo,place));
    }

    @Test
    @DisplayName("Testeamos cuando se da de alta la nueva reserva")
    public void hotelReservationTest() {
        //arrange
        DTOresquest3 params = DTORequestHotelFactory.DTORequest3();
        DTOresponsive3 expected = DTOResponseHotelFactory.DTOResponsive3();

        //act
        Mockito.lenient().when(hotelRepository.getHotels()).thenReturn(HotelFactory.hotelList());
        var result = hotelService.booking(params);


        //assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Testeamos cuando la reserva no se puede concretar")
    public void flightNullReservationTest () {
            //arrange
            DTOresquest3 params = DTORequestHotelFactory.DTORequest3();
            params.getBooking().setDateFrom(LocalDate.parse("2025-02-10"));

            //act
            Mockito.lenient().when(hotelRepository.getHotels()).thenReturn(HotelFactory.hotelList());

            //assert
            Assertions.assertThrows(ValidationParams.class, () -> hotelService.booking(params));
        }

    }




