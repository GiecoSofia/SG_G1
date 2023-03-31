package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.BookingModelDTO;
import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.model.PeopleModel;
import com.SG_G1.BootcampDH.repository.IBookingRepository;
import com.SG_G1.BootcampDH.repository.IPeopleRepository;
import com.SG_G1.BootcampDH.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements ICrudService<BookingModelDTO, Integer> {

    @Autowired
    IBookingRepository bookingRepository;
    ModelMapper mapper = new ModelMapper();
    @Autowired
    IPeopleRepository peopleRepository;

    @Override
    public MessageDTO saveEntity(BookingModelDTO DTO) {
        BookingModel booking = mapper.map(DTO, BookingModel.class);

         bookingRepository.save(booking);


        return new MessageDTO("se creo correctamente");
    }

    @Override
    public MessageDTO updateEntity(Integer integer, BookingModelDTO DTO) {
        return null;
    }

    @Override
    public List<BookingModelDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }
}
