package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @Column(name="ssn")
    private String ssn;
    private String email;
    private String first_name;
    private String last_name;

    public Person(String ssn, String email, String first_name, String last_name) {
        this.ssn = ssn;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Person() {}
}
