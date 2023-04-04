
//package com.SG_G1.BootcampDH.unit.controller;
//
//import com.SG_G1.BootcampDH.controller.FlightController;
//import com.SG_G1.BootcampDH.controller.HotelController;
//import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
//import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
//import com.SG_G1.BootcampDH.exception.ValidationParams;
//import com.SG_G1.BootcampDH.model.FlightModel;
//import com.SG_G1.BootcampDH.model.HotelModel;
//import com.SG_G1.BootcampDH.repository.HotelRepository;
//import com.SG_G1.BootcampDH.service.FlightService;
//import com.SG_G1.BootcampDH.service.HotelService;
//import com.SG_G1.BootcampDH.utils.DTORequestHotelFactory;
//import com.SG_G1.BootcampDH.utils.DTOResponseHotelFactory;
//import com.SG_G1.BootcampDH.utils.FlightFactory;
//import com.SG_G1.BootcampDH.utils.HotelFactory;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class HotelControllerTest {
//    @Mock
//    HotelService servicio;
//
//    @InjectMocks
//    HotelController controller;
//
//    @Test
//    @DisplayName("Testea que hay hoteles registrados")
//    public void hotelServiceListTest() {
//        //arrange
//        var expected = new ResponseEntity<>(HotelFactory.hotelList(), HttpStatus.OK);
//        //act
//        Mockito.lenient().when(servicio.hotelRepositoryList()).thenReturn(HotelFactory.hotelList());
//        var result = controller.listHotel();
//        //assert
//        Assertions.assertEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Testea que trae la excepción cuando la lista de hoteles viene vacia")
//    public void hotelServiceListWithEmptyTest() {
//        //arrange
//        var expected = HotelFactory.hotelList();
//        //act
//        Mockito.lenient().when(servicio.hotelRepositoryList()).thenReturn(HotelFactory.hotelListNull());
//
//        //assert
//        Assertions.assertThrows(NullPointerException.class, () -> controller.listHotel());
//
//    }
//
//    @Test
//    @DisplayName("Testeamos que nos traiga los hoteles disponibles en un rango de fechas y destino")
//    public void findDateServicioTest(){
//        //Arrange
//        LocalDate dateFrom = LocalDate.parse("2022-02-10");
//        LocalDate dateTo = LocalDate.parse("2023-03-20");
//        String place ="Puerto Iguazú" ;
//
//
//        List<HotelModel> hoteles = new ArrayList<>();
//        HotelModel hotel = HotelFactory.hotel1();
//        hoteles.add(hotel);
//        var expected = new ResponseEntity<>(hoteles, HttpStatus.OK);
//
//        //Act
//        Mockito.lenient().when(servicio.hotelRepositoryListDisp(dateFrom,dateTo,place)).thenReturn(hoteles);
//        var result = controller.listHotelDips(dateFrom,dateTo,place);
//
//
//        //Assert
//        Assertions.assertEquals(expected, result);
//
//    }
//
//    @Test
//    @DisplayName("Testea que trae la excepción cuando los parametros no coinciden")
//    public void hotelServiListWithEmptyTest(){
//        //arrange
//        LocalDate dateFrom = LocalDate.parse("2024-02-10");
//        LocalDate dateTo = LocalDate.parse("2023-03-20");
//        String place ="Catamarca" ;
//
//        List<HotelModel> hoteles = new ArrayList<>();
//        HotelModel hotel = HotelFactory.hotel1();
//
//
//
//        //act
//        Mockito.lenient().when(servicio.hotelRepositoryListDisp(dateFrom,dateTo,place)).thenReturn(hoteles);
//
//        //assert
//        Assertions.assertThrows(NullPointerException.class,() -> controller.listHotelDips(dateFrom,dateTo,place));
//    }
//
//
//    @Test
//    @DisplayName("Testeamos cuando se da de alta la nueva reserva")
//    public void hotelReservationTest() {
//        //arrange
//        DTOresquest3 params = DTORequestHotelFactory.DTORequest3();
//        var expected =  new ResponseEntity<>(DTOResponseHotelFactory.DTOResponsive3(), HttpStatus.OK);
//
//        //act
//        Mockito.lenient().when(servicio.booking(params)).thenReturn(DTOResponseHotelFactory.DTOResponsive3());
//        var result = controller.booking(params);
//
//
//        //assert
//        Assertions.assertEquals(expected, result);
//
//    }
//}

package com.SG_G1.BootcampDH.unit.controller;

import com.SG_G1.BootcampDH.controller.HotelController;
import com.SG_G1.BootcampDH.dto.resquest.HotelRequestDTO;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.service.HotelService;
import com.SG_G1.BootcampDH.utils.DTORequestHotelFactory;
import com.SG_G1.BootcampDH.utils.DTOResponseHotelFactory;
import com.SG_G1.BootcampDH.utils.HotelFactory;
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
public class HotelControllerTest {
    @Mock
    HotelService servicio;

    @InjectMocks
    HotelController controller;

    @Test
    @DisplayName("Testea que hay hoteles registrados")
    public void hotelServiceListTest() {
        //arrange
        var expected = new ResponseEntity<>(HotelFactory.hotelList(), HttpStatus.OK);
        //act
        Mockito.lenient().when(servicio.hotelRepositoryList()).thenReturn(HotelFactory.hotelList());
        var result = controller.listHotel();
        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testea que trae la excepción cuando la lista de hoteles viene vacia")
    public void hotelServiceListWithEmptyTest() {
        //arrange
        var expected = HotelFactory.hotelList();
        //act
        Mockito.lenient().when(servicio.hotelRepositoryList()).thenReturn(HotelFactory.hotelListNull());

        //assert
        Assertions.assertThrows(NullPointerException.class, () -> controller.listHotel());

    }

    @Test
    @DisplayName("Testeamos que nos traiga los hoteles disponibles en un rango de fechas y destino")
    public void findDateServicioTest(){
        //Arrange
        LocalDate dateFrom = LocalDate.parse("2022-02-10");
        LocalDate dateTo = LocalDate.parse("2023-03-20");
        String place ="Puerto Iguazú" ;


        List<HotelModel> hoteles = new ArrayList<>();
        HotelModel hotel = HotelFactory.hotel1();
        hoteles.add(hotel);
        var expected = new ResponseEntity<>(hoteles, HttpStatus.OK);

        //Act
        Mockito.lenient().when(servicio.hotelRepositoryListDisp(dateFrom,dateTo,place)).thenReturn(hoteles);
        var result = controller.listHotelDips(dateFrom,dateTo,place);


        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Testea que trae la excepción cuando los parametros no coinciden")
    public void hotelServiListWithEmptyTest(){
        //arrange
        LocalDate dateFrom = LocalDate.parse("2024-02-10");
        LocalDate dateTo = LocalDate.parse("2023-03-20");
        String place ="Catamarca" ;

        List<HotelModel> hoteles = new ArrayList<>();
        HotelModel hotel = HotelFactory.hotel1();



        //act
        Mockito.lenient().when(servicio.hotelRepositoryListDisp(dateFrom,dateTo,place)).thenReturn(hoteles);

        //assert
        Assertions.assertThrows(NullPointerException.class,() -> controller.listHotelDips(dateFrom,dateTo,place));
    }


    @Test
    @DisplayName("Testeamos cuando se da de alta la nueva reserva")
    public void hotelReservationTest() {
        //arrange
        HotelRequestDTO params = DTORequestHotelFactory.DTORequest3();
        var expected =  new ResponseEntity<>(DTOResponseHotelFactory.DTOResponsive3(), HttpStatus.OK);

        //act
        Mockito.lenient().when(servicio.booking(params)).thenReturn(DTOResponseHotelFactory.DTOResponsive3());
        var result = controller.booking(params);


        //assert
        Assertions.assertEquals(expected, result);

    }
}
>>>>>>> 022cae696ee9cc94c315ab18b20de9dffc8cb87f
