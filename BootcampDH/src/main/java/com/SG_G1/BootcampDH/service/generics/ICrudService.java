package com.SG_G1.BootcampDH.service.generics;

import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;

import java.util.List;

public interface ICrudService<T, ID> {

    MessageDTO saveEntity(T DTO);

    MessageDTO updateEntity(String id, T DTO);

    List<T> getAllEntities();

    MessageDTO deleteEntity(String id);
}
