package com.SG_G1.BootcampDH.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name= "flight")
public class FlightModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "seatType")
    private String seatType;

    @Column(name = "price", precision = 2)
    private Double price;

    @Column(name = "date_from")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate from;

    @Column(name = "date_to")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate to;


    public FlightModel(String aa123, LocalDate from, LocalDate to, String origin, String destination) {
    }
}
