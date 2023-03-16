package com.SG_G1.BootcampDH.dto.resquest;

import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DTOresquest3 {

    private String userName;

    private @Valid BookingModel booking;
    private PaymentMethod paymentMethod;
}
