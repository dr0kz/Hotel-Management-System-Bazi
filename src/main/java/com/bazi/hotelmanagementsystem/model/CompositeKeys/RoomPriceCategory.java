package com.bazi.hotelmanagementsystem.model.CompositeKeys;

import java.io.Serializable;

public class RoomPriceCategory implements Serializable {
    private Long roomCategory;
    private Long id;

    public RoomPriceCategory(Long roomCategory, Long id) {
        this.roomCategory = roomCategory;
        this.id = id;
    }

    public RoomPriceCategory() {
    }
}
