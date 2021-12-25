package com.bazi.hotelmanagementsystem.web.controller;

import com.bazi.hotelmanagementsystem.model.Hotel;
import com.bazi.hotelmanagementsystem.model.exceptions.HotelNotFound;
import com.bazi.hotelmanagementsystem.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping("/{id}")
    public String getPage(@PathVariable Long id, Model model) throws HotelNotFound {
        try{
            model.addAttribute("hotel",this.hotelService.findById(id));
            return "hotel";
        }catch(HotelNotFound hotelNotFound){
            return "redirect:/";
        }
    }
}
