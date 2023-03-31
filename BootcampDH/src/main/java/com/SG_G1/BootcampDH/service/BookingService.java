package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.BookingModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.service.generics.ICrudService;

import java.util.List;

public class BookingService implements ICrudService<BookingModelDTO, Integer> {
    @Override
    public MessageDTO saveEntity(BookingModelDTO DTO) {
        return null;
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
