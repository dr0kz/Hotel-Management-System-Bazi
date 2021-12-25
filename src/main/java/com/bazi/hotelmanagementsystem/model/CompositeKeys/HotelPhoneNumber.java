package com.bazi.hotelmanagementsystem.model.CompositeKeys;

import java.io.Serializable;

public class HotelPhoneNumber implements Serializable {
    private Long hotel;
    private String number;

    public HotelPhoneNumber(Long hotel, String number) {
        this.hotel = hotel;
        this.number = number;
    }
}
