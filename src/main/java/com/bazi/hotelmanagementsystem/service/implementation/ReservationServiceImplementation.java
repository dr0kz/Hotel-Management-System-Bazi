package com.bazi.hotelmanagementsystem.service.implementation;

import com.bazi.hotelmanagementsystem.model.Customer;
import com.bazi.hotelmanagementsystem.model.Hotel;
import com.bazi.hotelmanagementsystem.model.Reservation;
import com.bazi.hotelmanagementsystem.model.Room;
import com.bazi.hotelmanagementsystem.repository.CustomerRepository;
import com.bazi.hotelmanagementsystem.repository.HotelRepository;
import com.bazi.hotelmanagementsystem.repository.ReservationRepository;
import com.bazi.hotelmanagementsystem.repository.RoomRepository;
import com.bazi.hotelmanagementsystem.service.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationServiceImplementation implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    public ReservationServiceImplementation(ReservationRepository reservationRepository, CustomerRepository customerRepository, HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Reservation reserveRoom(Long hotelId, Long roomId, LocalDate from, LocalDate to, Integer numberOfGuests, String ssn) {
        Reservation reservation = new Reservation(numberOfGuests, from, to);
        Customer customer = this.customerRepository.findById(ssn).get();
        Hotel hotel = this.hotelRepository.findById(hotelId).get();
        Room room = this.roomRepository.findById(roomId).get();
        room.setHotel(hotel);
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        return this.reservationRepository.save(reservation);
    }
}
