package com.bazi.hotelmanagementsystem.model.CompositeKeys;

import java.io.Serializable;

public class PersonPhoneNumber implements Serializable {
    private String person;
    private String number;

    public PersonPhoneNumber(String person, String number) {
        this.person = person;
        this.number = number;
    }
}
