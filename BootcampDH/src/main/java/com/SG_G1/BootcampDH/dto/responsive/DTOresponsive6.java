package com.SG_G1.BootcampDH.dto.responsive;

import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.FlightReservationModel;
import com.SG_G1.BootcampDH.model.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DTOresponsive6 {
    private String userName;
    private double total;
    private FlightReservationModel flightReservation;
    private StatusCode status;
}

