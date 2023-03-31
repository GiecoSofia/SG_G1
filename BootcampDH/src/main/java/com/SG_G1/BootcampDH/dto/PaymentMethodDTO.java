package com.SG_G1.BootcampDH.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentMethodDTO {
    private String type;
    private String number;
    private int dues;
}
