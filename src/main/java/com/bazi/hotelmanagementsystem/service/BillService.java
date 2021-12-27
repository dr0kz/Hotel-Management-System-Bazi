package com.bazi.hotelmanagementsystem.service;

public interface BillService {
    void saveBill(Long idReservation, Integer amount, String firstName, String lastName);
}
