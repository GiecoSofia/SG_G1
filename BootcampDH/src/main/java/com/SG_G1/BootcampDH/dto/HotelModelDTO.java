package com.SG_G1.BootcampDH.dto;

import com.SG_G1.BootcampDH.model.HotelModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelModelDTO {

    private String code;
    private String name;
    private String place;
    private String type;
    private Double price;
    private LocalDate from;
    private LocalDate to;
    private Boolean booking;

}
