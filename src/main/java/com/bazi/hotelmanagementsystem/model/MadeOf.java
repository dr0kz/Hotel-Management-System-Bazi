package com.bazi.hotelmanagementsystem.model;

import com.bazi.hotelmanagementsystem.model.CompositeKeys.EmployeeSectionHotel;
import com.bazi.hotelmanagementsystem.model.CompositeKeys.HotelSection;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="hotel_made_of_section")
@Data
@IdClass(HotelSection.class)
public class MadeOf {
    @Id
    @ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotel;
    @Id
    @ManyToOne
    @JoinColumn(name="id_section")
    private Section section;
}
