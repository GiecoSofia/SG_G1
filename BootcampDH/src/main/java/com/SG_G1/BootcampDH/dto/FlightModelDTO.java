package com.SG_G1.BootcampDH.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightModelDTO {

    private String code;
    private String origin;
    private String destination;
    private String seatType;
    private Double price;
    private LocalDate from;
    private LocalDate to;


}
