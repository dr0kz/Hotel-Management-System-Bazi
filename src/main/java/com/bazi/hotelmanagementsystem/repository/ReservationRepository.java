package com.bazi.hotelmanagementsystem.repository;

import com.bazi.hotelmanagementsystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
