package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.FlightReservationModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.repository.IFlightReservationRepository;
import com.SG_G1.BootcampDH.service.generics.ICrudService;

import java.util.List;

public class FlightReservationService implements ICrudService<FlightReservationModelDTO, Integer> {
    @Override
    public MessageDTO saveEntity(FlightReservationModelDTO DTO) {
        return null;
    }

    @Override
    public MessageDTO updateEntity(String integer, FlightReservationModelDTO DTO) {
        return null;
    }

    @Override
    public List<FlightReservationModelDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(String integer) {
        return null;
    }
}
