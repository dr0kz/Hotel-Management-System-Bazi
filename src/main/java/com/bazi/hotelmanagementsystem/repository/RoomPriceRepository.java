package com.bazi.hotelmanagementsystem.repository;

import com.bazi.hotelmanagementsystem.model.CompositeKeys.RoomPriceCategory;
import com.bazi.hotelmanagementsystem.model.RoomCategory;
import com.bazi.hotelmanagementsystem.model.RoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RoomPriceRepository extends JpaRepository<RoomPrice, RoomPriceCategory> {
    List<RoomPrice> findAllByRoomCategory(RoomCategory category);
}
