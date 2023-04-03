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
@Table(name = "Booking")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBooking")
    private Integer id;
    @Column(name = "date_from")
    private LocalDate dateFrom;
    @Column(name = "date_to")
    private LocalDate dateTo;
    @Column(name = "destination")
    private String destination;
    @Column(name = "hotel_code")
    private String hotelCode;
    @Column(name = "people_amount")
    private int peopleAmount;
    @Column(name = "room_type")
    private String roomType;

    @OneToMany(cascade ={CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<PeopleModel> people;

    @OneToOne(cascade ={CascadeType.ALL}, fetch = FetchType.LAZY)
    private PaymentMethod paymentMethod;

    @OneToOne(cascade ={CascadeType.ALL}, fetch = FetchType.LAZY)
    private HotelModel id_hotel;
}
