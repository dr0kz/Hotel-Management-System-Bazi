package com.bazi.hotelmanagementsystem.web.controller;

import com.bazi.hotelmanagementsystem.model.Hotel;
import com.bazi.hotelmanagementsystem.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final HotelService hotelService;

    public HomeController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String getPage(Model model)
    {
        List<Hotel> hotels = this.hotelService.findAll();
        model.addAttribute("hotels", this.hotelService.findAll());
        return "home";
    }
}
