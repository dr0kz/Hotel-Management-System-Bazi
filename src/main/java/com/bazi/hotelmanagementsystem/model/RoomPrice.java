package com.bazi.hotelmanagementsystem.model;

import com.bazi.hotelmanagementsystem.model.CompositeKeys.EmployeeSectionHotel;
import com.bazi.hotelmanagementsystem.model.CompositeKeys.RoomPriceCategory;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@IdClass(RoomPriceCategory.class)
@Table(name="room_price")
public class RoomPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_room_price")
    private Long id;
    @Id
    @ManyToOne
    @JoinColumn(name="id_room_category")
    private RoomCategory roomCategory;
    @Column(name="date_from")
    private LocalDate dateFrom;
    @Column(name="date_to")
    private LocalDate dateTo;
    private Integer price;
}
