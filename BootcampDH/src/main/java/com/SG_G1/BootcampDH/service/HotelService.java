package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    public List<HotelModel> hotelRepositoryList(){
        HotelRepository lista = new HotelRepository();
        return lista.getHotels();
    };

    public List<HotelModel> hotelRepositoryListDisp(String from, String to, String destination){
        HotelRepository lista = new HotelRepository();
        List<HotelModel> nuevaLista = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dateFrom = LocalDate.parse(from,formatter);

        LocalDate dateTo = LocalDate.parse(to,formatter);

        for (HotelModel hotel:lista.getHotels()) {
            if(destination.equals(hotel.getPlace()) && dateFrom.equals(hotel.getFrom())){
                nuevaLista.add(hotel);
            }
        }
        return nuevaLista;
    }
     public DTOresponsive3 booking(DTOresquest3 booking){
        DTOresponsive3 responsive = new DTOresponsive3();
        responsive.setUserName(booking.getUserName());



        double total ;

        ZoneId defaultZoneId = ZoneId.systemDefault();

         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

         ParsePosition position = new ParsePosition(0);
         ParsePosition position1 = new ParsePosition(0);


        Date fechaActual = formato.parse(booking.getBooking().getDateTo(),position);

        Date fechaInicio = formato.parse(booking.getBooking().getDateFrom(),position1);


        int dias = (int) ((fechaActual.getTime()-fechaInicio.getTime()) / 86400000);

        HotelRepository hoteles = new HotelRepository();

        HotelModel hotel = new HotelModel();

         for (HotelModel hotel1:hoteles.getHotels()) {
             System.out.println(booking.getBooking().getHotelCode());
             System.out.println(hotel1.getCode());
             if (booking.getBooking().getHotelCode().equals(hotel1.getCode())){
                 hotel = hotel1;
             }
         }
         System.out.println(hotel);
        total = dias * hotel.getPrice();


         responsive.setTotal(total);


         responsive.setBooking(booking.getBooking());

         return responsive;
     }
}


