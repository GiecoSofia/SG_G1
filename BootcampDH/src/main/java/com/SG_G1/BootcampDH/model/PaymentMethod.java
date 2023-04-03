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
@Table(name = "PaymentMethod")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name= "number")
    private String number;
    @Column(name = "dues")
    private int dues;

}
