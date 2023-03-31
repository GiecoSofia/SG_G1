package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// JPA

@Entity
@Table(name = "Status Code")
public class StatusCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private int code;
    @Column(length = 100)
    private String message;


}
