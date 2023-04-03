package com.SG_G1.BootcampDH.dto.resquest;

import com.SG_G1.BootcampDH.dto.BookingModelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class HotelRequestDTO {
    @Email(message = "Por favor ingrese un e-mail válido")
    private String userName;

    private @Valid BookingModelDTO booking;

}
