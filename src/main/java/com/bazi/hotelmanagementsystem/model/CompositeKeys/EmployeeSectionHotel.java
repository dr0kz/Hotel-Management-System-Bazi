package com.bazi.hotelmanagementsystem.model.CompositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


public class EmployeeSectionHotel implements Serializable {
    private String ssn;
    private Long hotelId;
    private Long sectionId;

    public EmployeeSectionHotel(String ssn, Long hotelId, Long sectionId) {
        this.ssn = ssn;
        this.hotelId = hotelId;
        this.sectionId = sectionId;
    }
}
