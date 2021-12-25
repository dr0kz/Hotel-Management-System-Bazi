package com.bazi.hotelmanagementsystem.model.exceptions;

public class HotelNotFound extends Exception{
    public HotelNotFound(Long id) {
        super("Hotel with id "+id+" was not found!");
    }
}
