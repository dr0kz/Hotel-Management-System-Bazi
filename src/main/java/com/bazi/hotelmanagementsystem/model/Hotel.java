package com.bazi.hotelmanagementsystem.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
//@Immutable za views
public class Hotel {
    @Id
    @Column(name="id_hotel")
    private Long id;
    private String name;
    private String street;
    private String city;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;



    public Hotel(Long id, String hotelName, String streetName, String cityName) {
        this.id = id;
        this.name = hotelName;
        this.street = streetName;
        this.city = cityName;
    }
    public Hotel() {}
}
