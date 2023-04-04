package com.SG_G1.BootcampDH.unit.service;
import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import com.SG_G1.BootcampDH.service.HotelService;
import com.SG_G1.BootcampDH.utils.*;
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
public class HotelServiceTest {
    @Mock
    IHotelRepository hotelRepository;

    @InjectMocks
    HotelService hotelService;


    @Test
    public void saveEntityTest() {
        //arrange
        HotelModelDTO hotel = HotelFactory.hotel13();
        MessageDTO expected = MessageDTO.builder()
                .message("El hotel se dio de alta correctamente.")
                .build();

        //act
        Mockito.lenient().when(hotelRepository.findByPlaceAndNameAndFromAndTo(hotel.getName(), hotel.getPlace(), hotel.getTo(), hotel.getFrom())).thenReturn(null);
        Mockito.lenient().when(hotelRepository.countBookingsByHotelCode(hotel.getCode())).thenReturn(new Long(0));

        var result = hotelService.saveEntity(hotel);

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void findPlaceTest() {
        //arrange
        String place = "Cartagena";
        HotelModelDTO hotel13 = HotelFactory.hotel13();
        HotelModelDTO hotel14 = HotelFactory.hotel14();
        List<HotelModelDTO> hotelList = Arrays.asList(hotel13, hotel14);

        //act
        Mockito.lenient().when(hotelRepository.findByPlaceEquals(place)).thenReturn(Collections.emptyList());

        //assert
        try {
            hotelService.findPlace(place);
        } catch (ValidationParams ex) {
            assertEquals("No hay hoteles en el destino indicado", ex.getMessage());
        }
    }

    @Test
    public void findByRoomTypeTest() {
        String roomType = "Doble";
        HotelModelDTO hotel13 = HotelFactory.hotel13();
        HotelModelDTO hotel14 = HotelFactory.hotel14();
        List<HotelModelDTO> hotelList = Arrays.asList(hotel13, hotel14);

        Mockito.lenient().when(hotelRepository.findByTypeEquals(roomType)).thenReturn(Collections.emptyList());

        try {
            hotelService.findByRoomType(roomType);
        } catch (ValidationParams ex) {
            assertEquals("No existe ese tipo de habitacion", ex.getMessage());
        }
    }
}
