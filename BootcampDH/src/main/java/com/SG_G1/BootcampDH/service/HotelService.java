package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.model.StatusCode;
import com.SG_G1.BootcampDH.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;



@Service
public class HotelService {
    @Autowired
    public List<HotelModel> hotelRepositoryList() {
        HotelRepository lista = new HotelRepository();
        return lista.getHotels();
    }

    ;

    public List<HotelModel> hotelRepositoryListDisp(LocalDate dateFrom, LocalDate dateTo, String destination) {
        HotelRepository lista = new HotelRepository();
        List<HotelModel> nuevaLista = new ArrayList<>();

        Validaciones(dateFrom, dateTo, destination);


        for (HotelModel hotel : lista.getHotels()) {
            if (destination.equals(hotel.getPlace()) && dateFrom.equals(hotel.getFrom()) && dateTo.equals(hotel.getTo())) {
                nuevaLista.add(hotel);
            }
        }
        return nuevaLista;
    }


    public DTOresponsive3 booking(DTOresquest3 booking) {

        Validaciones(booking.getBooking().getDateFrom(), booking.getBooking().getDateTo(), booking.getBooking().getDestination());

        ValidationRoomType(booking.getBooking().getRoomType(), booking.getBooking().getPeopleAmount());

        DTOresponsive3 responsive = new DTOresponsive3();
        responsive.setUserName(booking.getUserName());

        Long dias = DAYS.between(booking.getBooking().getDateFrom(), booking.getBooking().getDateTo());

        HotelModel hotel = SearchHotel(booking.getBooking().getHotelCode());
        double total = dias * hotel.getPrice();

        responsive.setTotal(total);
        responsive.setBooking(booking.getBooking());
        responsive.setStatus(new StatusCode(200, "El proceso termino satisfactoriamente"));

        return responsive;
    }

    private void ValidationRoomType(String roomType, int peopleAmount) {

        if(roomType.equals("SINGLE") && peopleAmount == 1){
            return;
        }
        else if (roomType.equals("DOUBLE") && peopleAmount == 2) {
            return;
        }
        else if (roomType.equals("TRIPLE") && peopleAmount == 3) {
            return;
        }
        else if (roomType.equals("MULTIPLE") && peopleAmount > 3) {
            return;
        }
        else {
            throw new RuntimeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
    }

    private HotelModel SearchHotel(String hotelCode) {
        HotelRepository hoteles = new HotelRepository();

        HotelModel hotel = new HotelModel();

        for (HotelModel hotel1 : hoteles.getHotels()) {

            if (hotelCode.equals(hotel1.getCode())) {
                hotel = hotel1;
            }
        }
        return hotel;
    }


    //Validaciones
    private void Validaciones(LocalDate dateFrom, LocalDate dateTo, String destination) {

        if (dateFrom.compareTo(dateTo) > 0) {
            throw new ValidationParams("La fecha de entrada debe ser menor a la de salida" +
                    "" + "La fecha de entrada debe ser mayor a la de entrada");
        }

        HotelRepository lista = new HotelRepository();

        lista.getHotels().stream()
                .filter(hoteles -> hoteles.getPlace().equals(destination))
                .findFirst().orElseThrow(() -> new ValidationParams("El destino elegido no existe"));
    }


}


