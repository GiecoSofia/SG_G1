package com.SG_G1.BootcampDH.dto.responsive;

import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.model.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DTOresponsive3 {

    private String userName;
    private double total;
    private BookingModel booking;
    private StatusCode status;

}
