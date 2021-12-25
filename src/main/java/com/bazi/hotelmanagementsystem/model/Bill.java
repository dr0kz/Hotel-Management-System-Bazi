package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//entity model
//ManyToOne kon site
//novo ili kompozitno id
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bill")
    private Long id;
    @OneToOne
    @JoinColumn(name="id_reservation")
    private Reservation id_reservation;
    private Integer amount;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    public Bill(Integer amount, String firstName, String lastName) {
        this.amount = amount;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Bill(){}
}
