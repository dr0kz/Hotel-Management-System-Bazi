package com.bazi.hotelmanagementsystem.web.controller;

import com.bazi.hotelmanagementsystem.model.exceptions.RoomNotFoundException;
import com.bazi.hotelmanagementsystem.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/hotels/{hotelId}/rooms/{roomId}")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getPage(@PathVariable Long hotelId,@PathVariable Long roomId, Model model)
    {
        try{
            model.addAttribute("room", this.roomService.findRoom(roomId));
            return "room";
        }catch(RoomNotFoundException roomNotFoundException)
        {
            return "home";
        }
    }
    @PostMapping
    public void reserve(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //reserve
        response.sendRedirect("/");
    }
}
