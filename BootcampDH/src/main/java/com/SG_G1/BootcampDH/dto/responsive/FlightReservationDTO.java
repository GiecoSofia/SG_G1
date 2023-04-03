package com.SG_G1.BootcampDH.dto.responsive;

import com.SG_G1.BootcampDH.dto.FlightReservationModelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightReservationDTO {

    private List<FlightReservationModelDTO> flight_bookings;

}

