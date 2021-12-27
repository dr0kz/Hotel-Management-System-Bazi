package com.bazi.hotelmanagementsystem.web.rest;

import com.bazi.hotelmanagementsystem.service.RoomPriceService;
import com.bazi.hotelmanagementsystem.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/{roomId}")
public class RoomRestController {

    private final RoomPriceService roomPriceService;
    private final RoomService roomService;
    public RoomRestController(RoomPriceService roomPriceService, RoomService roomService) {
        this.roomPriceService = roomPriceService;
        this.roomService = roomService;
    }

    @GetMapping
    public List<String> getNotAvailableDatesForRoom(@PathVariable Long roomId)
    {
        List<String> availableDates = this.roomService.findNotAvailableDates(roomId);
        return availableDates;
    }
    @GetMapping("/price")
    public Integer getTotalPrice(@PathVariable Long roomId,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to)
    {
        return this.roomPriceService.getTotalPrice(roomId, from, to);
    }
}
