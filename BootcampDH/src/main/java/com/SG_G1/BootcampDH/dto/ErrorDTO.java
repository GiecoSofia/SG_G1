package com.SG_G1.BootcampDH.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ErrorDTO {

    String explanation;

    List<String> messages;



}
