package com.bazi.hotelmanagementsystem.service;

import com.bazi.hotelmanagementsystem.model.Hotel;
import com.bazi.hotelmanagementsystem.model.exceptions.HotelNotFound;

import java.util.List;

public interface HotelService {
    List<Hotel> findAll();
    Hotel findById(Long id) throws HotelNotFound;
}
