package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightModel {

    private String code;
    private String origin;
    private String destination;
    private String seatType;
    private Double price;
    private LocalDate from;
    private LocalDate to;


}
