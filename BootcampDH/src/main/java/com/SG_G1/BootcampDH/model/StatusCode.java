package com.SG_G1.BootcampDH.model;

import lombok.*;

import javax.persistence.*;

//LOMBOK
@Getter
@Setter
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
    @Column(name = "code")
    private int code;
    @Column(name = "message")
    private String message;


}
