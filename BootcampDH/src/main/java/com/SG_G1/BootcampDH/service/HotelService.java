package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
}


