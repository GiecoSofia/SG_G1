package com.SG_G1.BootcampDH.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PeopleModelDTO {
    private int dni;
    private String name;
    private String lastName;
    private String birthday;
    @Email(message = "Por favor ingrese un e-mail válido")
    private String mail;
}
