package com.bazi.hotelmanagementsystem.service;

import com.bazi.hotelmanagementsystem.model.Room;
import com.bazi.hotelmanagementsystem.model.exceptions.RoomNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RoomService {
    Room findRoom(Long id) throws RoomNotFoundException;
    List<String> findNotAvailableDates(Long id);

}
