package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelModel {

    private String code;
    private String name;
    private String place;
    private String type;
    private Double price;
    private Date from;
    private Date to;
    private Boolean booking;
}
