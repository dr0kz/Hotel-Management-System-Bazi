package com.bazi.hotelmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_room")
    private Long id;
    @Column(name="room_number")
    private Integer number;
    private Integer floor;

    @ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name="id_room_category")
    private RoomCategory roomCategory;

    public Room(Integer number, Integer floor) {
        this.number = number;
        this.floor = floor;
    }
    public Room(){}
}
