package com.SG_G1.BootcampDH.dto;

import com.SG_G1.BootcampDH.model.PeopleModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightReservationModelDTO {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateTo;
    private String origin;
    private String destination;
    private String flightNumber;

    @Positive(message = "La cantidad de personas debe ser un valor numérico.")
    private int seats;
    private String seatType;
    private List<@Valid PeopleModel> people;
}
