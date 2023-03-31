package com.SG_G1.BootcampDH.model;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Flight Reservation")
public class FlightReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFlightReservation")
    private Integer id;
    @Column(name = "date_from")
    private LocalDate dateFrom;
    @Column(name = "date_to")
    private LocalDate dateTo;
    @Column(name = "origin")
    private String origin;
    @Column(name = "destination")
    private String destination;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "seats")
    private int seats;
    @Column(name = "seat_type")
    private String seatType;
    @Column(name = "people")
    private List<PeopleModel> people;
}
