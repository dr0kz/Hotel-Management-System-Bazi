package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class RoomCategory {
    @Id
    @Column(name="id_room_category")
    private Long id;
    private String name;
    private String description;
    private Integer capacity;
    @OneToMany(mappedBy = "roomCategory")
    private List<Room> rooms;

    @OneToMany(mappedBy = "roomCategory")
    private List<RoomPrice> roomPrices;

    public RoomCategory(Long id, String name, String description, Integer capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
    }

    public RoomCategory(){}
}
