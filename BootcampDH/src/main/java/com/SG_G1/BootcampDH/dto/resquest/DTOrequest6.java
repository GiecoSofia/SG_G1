package com.SG_G1.BootcampDH.dto.resquest;

import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.FlightReservationModel;
import com.SG_G1.BootcampDH.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DTOrequest6 {

    private String userName;
    private FlightReservationModel flightReservation;
    private PaymentMethod paymentMethod;
}

