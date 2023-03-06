package com.SG_G1.BootcampDH.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentMethod {
    private String type;
    private String number;
    private int dues;
}
