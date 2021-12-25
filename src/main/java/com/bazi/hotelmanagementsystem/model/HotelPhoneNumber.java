package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@IdClass(com.bazi.hotelmanagementsystem.model.CompositeKeys.HotelPhoneNumber.class)
@Table(name="hotel_phone_number")
@Data
public class HotelPhoneNumber {
    @Id
    @ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotel;

    @Id
    @Column(name="phone_number")
    private String number;
}
