package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reservation")
    private Long id;
    @OneToOne
    @JoinColumn(name="id_room")
    private Room room;
    @ManyToOne
    @JoinColumn(name="ssn")
    private Customer customer;
    @Column(name="number_of_guests")
    private Integer numberOfGuests;
    @Column(name="date_from")
    private LocalDate dateFrom;
    @Column(name="date_to")
    private LocalDate dateTo;

    public Reservation(Integer numberOfGuests, LocalDate dateFrom, LocalDate dateTo) {
        this.numberOfGuests = numberOfGuests;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    public Reservation(){}
}
