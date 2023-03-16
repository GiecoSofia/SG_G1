package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeopleModel {
    private int dni;
    private String name;
    private String lastName;
    private String birthday;
    @Email(message = "Por favor ingrese un e-mail válido")
    private String mail;
}
