package com.SG_G1.BootcampDH.dto.resquest;

import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DTOresquest3 {
    @Email(message = "Por favor ingrese un e-mail válido")
    private String userName;

    private @Valid BookingModel booking;
    private PaymentMethod paymentMethod;
}
