package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// JPA

@Entity
@Table(name = "PaymentMethod")
public class PaymentMethod {
    @Column(length = 10)
    private String type;
    @Column(length = 10)
    private String number;
    @Column(length = 10)
    private int dues;
}
