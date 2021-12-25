package com.bazi.hotelmanagementsystem.service.implementation;

import com.bazi.hotelmanagementsystem.model.Hotel;
import com.bazi.hotelmanagementsystem.model.exceptions.HotelNotFound;
import com.bazi.hotelmanagementsystem.repository.HotelRepository;
import com.bazi.hotelmanagementsystem.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImplementation implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImplementation(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long id) throws HotelNotFound {
        return this.hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFound(id));
    }
}
