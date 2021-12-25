package com.bazi.hotelmanagementsystem.model;

import com.bazi.hotelmanagementsystem.model.CompositeKeys.EmployeeSectionHotel;
import lombok.Data;

import javax.persistence.*;

@Entity
@IdClass(com.bazi.hotelmanagementsystem.model.CompositeKeys.PersonPhoneNumber.class)
@Table(name="person_phone_number")
@Data
public class PersonPhoneNumber {
    @Id
    @ManyToOne
    @JoinColumn(name="ssn")
    private Person person;

    @Id
    @Column(name="phone_number")
    private String number;
}
