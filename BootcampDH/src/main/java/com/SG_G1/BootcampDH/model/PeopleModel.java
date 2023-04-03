package com.SG_G1.BootcampDH.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;


//LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// JPA

@Entity
@Table(name = "PeopleModel")
public class PeopleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "DNI")
    private int dni;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "mail")
    private String mail;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "idBooking")*/
    /*@JoinColumn(foreignKey = @ForeignKey(name = "fk_PeopleModel_booking_id"), name="booking_id", referencedColumnName = "id", nullable = false)*/
  /*  private BookingModel bookingModel;*/


}
