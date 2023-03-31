package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;


//LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// JPA

@Entity
@Table(name = "PeopelModel")
public class PeopleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 8)
    private int dni;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String lastName;
    @Column(length = 20)
    private String birthday;
    @Column(length = 100)
    private String mail;
}
