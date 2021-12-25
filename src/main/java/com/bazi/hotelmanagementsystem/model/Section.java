package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Section {
    @Id
    @Column(name="id_section")
    private Long id;
    private String name;
    private String description;

    public Section(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Section(){}
}
