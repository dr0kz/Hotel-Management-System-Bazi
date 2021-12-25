package com.bazi.hotelmanagementsystem.model;

import com.bazi.hotelmanagementsystem.model.CompositeKeys.EmployeeSectionHotel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(EmployeeSectionHotel.class)
@Table(name="employee_responsible_for_hotel_and_section")
public class Responsible {
    @Id
    @ManyToOne
    @JoinColumn(name="ssn")
    private Employee ssn;
    @Id
    @ManyToOne
    @JoinColumn(name="id_section")
    private Section sectionId;
    @Id
    @ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotelId;

}
