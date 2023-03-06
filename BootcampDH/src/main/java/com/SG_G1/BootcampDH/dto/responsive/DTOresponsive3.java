package com.SG_G1.BootcampDH.dto.responsive;

import com.SG_G1.BootcampDH.model.BookingModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DTOresponsive3 {

    private String userName;
    private double total;
    private BookingModel booking;

}
