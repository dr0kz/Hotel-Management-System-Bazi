package com.bazi.hotelmanagementsystem.web.rest;

import com.bazi.hotelmanagementsystem.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/{roomId}")
public class RoomRestController {

    private final RoomService roomService;

    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<String> getNotAvailableDatesForRoom(@PathVariable Long roomId)
    {
        List<String> availableDates = this.roomService.findNotAvailableDates(roomId);
        return availableDates;
    }
}
