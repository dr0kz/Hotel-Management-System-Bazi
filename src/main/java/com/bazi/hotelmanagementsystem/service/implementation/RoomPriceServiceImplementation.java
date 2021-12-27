package com.bazi.hotelmanagementsystem.service.implementation;

import com.bazi.hotelmanagementsystem.model.RoomCategory;
import com.bazi.hotelmanagementsystem.model.RoomPrice;
import com.bazi.hotelmanagementsystem.repository.RoomPriceRepository;
import com.bazi.hotelmanagementsystem.repository.RoomRepository;
import com.bazi.hotelmanagementsystem.service.RoomPriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RoomPriceServiceImplementation implements RoomPriceService {
    private final RoomPriceRepository roomPriceRepository;
    private final RoomRepository roomRepository;
    public RoomPriceServiceImplementation(RoomPriceRepository roomPriceRepository, RoomRepository roomRepository) {
        this.roomPriceRepository = roomPriceRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Integer getTotalPrice(Long roomId, LocalDate from, LocalDate to) {
        RoomCategory rc = this.roomRepository.findById(roomId).get().getRoomCategory();
        List<RoomPrice> roomPriceList = this.roomPriceRepository
                .findAllByRoomCategory(rc)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        long numOfDaysBetween = ChronoUnit.DAYS.between(from, to);
        AtomicInteger totalPrice = new AtomicInteger();
        IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(from::plusDays)
                .forEach(d -> {
                    roomPriceList.forEach(rp -> {
                        if((d.isAfter(rp.getDateFrom()) || d.isEqual(rp.getDateFrom()))
                                && (d.isEqual(rp.getDateTo()) || d.isBefore(rp.getDateTo())))
                        {
                            totalPrice.addAndGet(rp.getPrice());
                        }
                    });
                });
        return totalPrice.get();
    }
}
