package com.bazi.hotelmanagementsystem.web.controller;

import com.bazi.hotelmanagementsystem.model.Reservation;
import com.bazi.hotelmanagementsystem.model.exceptions.RoomNotFoundException;
import com.bazi.hotelmanagementsystem.service.BillService;
import com.bazi.hotelmanagementsystem.service.CustomerService;
import com.bazi.hotelmanagementsystem.service.ReservationService;
import com.bazi.hotelmanagementsystem.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;


@Controller
@RequestMapping("/hotels/rooms")
public class RoomController {
    private final RoomService roomService;
    private final ReservationService reservationService;
    private final CustomerService customerService;
    private final BillService billService;
    public RoomController(RoomService roomService, ReservationService reservationService, CustomerService customerService, BillService billService) {
        this.roomService = roomService;
        this.reservationService = reservationService;
        this.customerService = customerService;
        this.billService = billService;
    }

    @GetMapping
    public String getPage(@RequestParam Long hotelId,@RequestParam Long roomId, Model model)
    {
        try{
            model.addAttribute("room", this.roomService.findRoom(roomId));
            return "room";
        }catch(RoomNotFoundException roomNotFoundException)
        {
            return "home";
        }
    }
    @GetMapping("/reserve")
    public String reserve(@RequestParam Long hotelId, @RequestParam Long roomId
    , @RequestParam String ssn, @RequestParam String email, @RequestParam String firstName, @RequestParam String lastName
    , @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom
            , @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo
    , @RequestParam Integer numberOfGuests, @RequestParam Integer totalAmount) throws IOException {

        this.customerService.saveCustomer(ssn, email, firstName, lastName);
        Reservation reservation = this.reservationService.reserveRoom(hotelId, roomId, dateFrom, dateTo, numberOfGuests, ssn);
        this.billService.saveBill(reservation.getId(),totalAmount, firstName, lastName);
        return "redirect:/";
    }
}
