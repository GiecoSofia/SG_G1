package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightModel {

    private String flightNumber;
    private String origin;
    private String destination;
    private String seatType;
    private Double price;
    private Date from;
    private Date to;


}
