package com.bazi.hotelmanagementsystem.service;

import com.bazi.hotelmanagementsystem.model.Reservation;

import java.time.LocalDate;

public interface ReservationService {
    public Reservation reserveRoom(Long hotelId, Long roomId, LocalDate from
            , LocalDate to, Integer numberOfGuests, String ssn);
}
