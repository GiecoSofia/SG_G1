package com.SG_G1.BootcampDH.dto.responsive;

import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.FlightReservationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DTOresponsive6 {
    private String userName;
    private double total;
    private FlightReservationModel flightReservation;
}

