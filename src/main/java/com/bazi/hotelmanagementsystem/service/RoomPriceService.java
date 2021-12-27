package com.bazi.hotelmanagementsystem.service;

import java.time.LocalDate;
import java.util.Date;

public interface RoomPriceService {
    Integer getTotalPrice(Long roomId, LocalDate from, LocalDate to);
}
