package com.SG_G1.BootcampDH.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDTO {

    String explanation;

    List<String> messages;



}
