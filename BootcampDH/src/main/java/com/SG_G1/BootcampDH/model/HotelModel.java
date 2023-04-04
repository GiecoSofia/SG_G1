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
@Table(name = "hotel")
public class HotelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private String place;

    @Column(name = "type")
    private String type;

    @Column(name = "price", precision = 2)
    private Double price;

    @Column(name = "date_from")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate from;

    @Column(name = "date_to")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate to;

    @Column(name = "booking")
    private Boolean booking;
}
