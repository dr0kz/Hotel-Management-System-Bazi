package com.bazi.hotelmanagementsystem.repository;

import com.bazi.hotelmanagementsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "Select res.date_from,res.date_to from hotel_management_system.reservation res " +
            "join hotel_management_system.room r on r.id_room = res.id_room" +
            " where ?1=res.id_room ",nativeQuery = true)
    List<Object[]> findNotAvailableDates(Long roomId); //Object[0] is date_from, Object[1] is date_to
}
