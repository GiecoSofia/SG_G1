package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.HotelModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import com.SG_G1.BootcampDH.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelService implements ICrudService<HotelModelDTO, Integer> {

    @Autowired
    IHotelRepository hotelRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDTO saveEntity(HotelModelDTO DTO) {
        HotelModel hotel = mapper.map(DTO, HotelModel.class);
         hotelRepository.save(hotel);
        return mapper.map(hotel, MessageDTO.class);
    }

    @Override
    public MessageDTO updateEntity(Integer integer, HotelModelDTO DTO) {
        return null;
    }

    @Override
    public List<HotelModelDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }
}
