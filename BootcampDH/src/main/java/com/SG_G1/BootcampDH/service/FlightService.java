package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.FlightModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.service.generics.ICrudService;

import java.util.List;

public class FlightService implements ICrudService<FlightModelDTO, Integer> {
    @Override
    public MessageDTO saveEntity(FlightModelDTO DTO) {
        return null;
    }

    @Override
    public MessageDTO updateEntity(String integer, FlightModelDTO DTO) {
        return null;
    }

    @Override
    public List<FlightModelDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(String integer) {
        return null;
    }
}
