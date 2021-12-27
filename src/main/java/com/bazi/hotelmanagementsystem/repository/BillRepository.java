package com.bazi.hotelmanagementsystem.repository;

import com.bazi.hotelmanagementsystem.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
