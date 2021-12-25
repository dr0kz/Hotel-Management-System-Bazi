package com.bazi.hotelmanagementsystem.model.CompositeKeys;

import java.io.Serializable;

public class HotelSection implements Serializable {
    private Long hotel;
    private Long section;

    public HotelSection(Long hotel, Long section) {
        this.hotel = hotel;
        this.section = section;
    }
}
