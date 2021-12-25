package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends Person{

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;
    public Customer(String ssn, String email, String first_name, String last_name) {
        super(ssn,email,first_name,last_name);
    }
    public Customer() {}
}
