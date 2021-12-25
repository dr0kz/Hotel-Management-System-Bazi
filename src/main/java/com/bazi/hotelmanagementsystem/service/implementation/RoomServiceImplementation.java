package com.bazi.hotelmanagementsystem.service.implementation;

import com.bazi.hotelmanagementsystem.model.Room;
import com.bazi.hotelmanagementsystem.model.exceptions.RoomNotFoundException;
import com.bazi.hotelmanagementsystem.repository.RoomRepository;
import com.bazi.hotelmanagementsystem.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImplementation implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImplementation(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findRoom(Long id) throws RoomNotFoundException {
        return this.roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @Override
    public List<String> findNotAvailableDates(Long id) {
        return this.roomRepository
                .findNotAvailableDates(id)
                .stream()
                .map(t -> t[0]+"/"+t[1])
                .collect(Collectors.toList());
    }
}
