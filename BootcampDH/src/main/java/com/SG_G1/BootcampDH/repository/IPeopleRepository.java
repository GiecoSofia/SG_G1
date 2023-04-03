package com.SG_G1.BootcampDH.repository;

import com.SG_G1.BootcampDH.model.PeopleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeopleRepository extends JpaRepository<PeopleModel, Integer> {
}
