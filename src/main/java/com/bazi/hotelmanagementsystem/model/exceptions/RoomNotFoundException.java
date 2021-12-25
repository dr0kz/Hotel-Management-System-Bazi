package com.bazi.hotelmanagementsystem.model.exceptions;

public class RoomNotFoundException extends Exception {
    public RoomNotFoundException(Long id) {
        super("Room with id "+id+" not found");
    }
}
