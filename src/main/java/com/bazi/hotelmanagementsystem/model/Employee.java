package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Employee extends Person {

    public Employee(String ssn, String email, String first_name, String last_name) {
        super(ssn, email, first_name, last_name);
    }
    public Employee(){}
}
