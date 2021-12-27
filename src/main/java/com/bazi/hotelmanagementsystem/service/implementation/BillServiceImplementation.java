package com.bazi.hotelmanagementsystem.service.implementation;

import com.bazi.hotelmanagementsystem.model.Bill;
import com.bazi.hotelmanagementsystem.model.Reservation;
import com.bazi.hotelmanagementsystem.repository.BillRepository;
import com.bazi.hotelmanagementsystem.repository.ReservationRepository;
import com.bazi.hotelmanagementsystem.service.BillService;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImplementation implements BillService {
    private final BillRepository billRepository;
    private final ReservationRepository reservationRepository;
    public BillServiceImplementation(BillRepository billRepository, ReservationRepository reservationRepository) {
        this.billRepository = billRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void saveBill(Long idReservation, Integer amount, String firstName, String lastName) {
        Reservation reservation = this.reservationRepository.findById(idReservation).get();
        Bill bill = new Bill(amount, firstName, lastName);
        bill.setId_reservation(reservation);
        this.billRepository.save(bill);
    }
}
