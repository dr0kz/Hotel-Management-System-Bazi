package com.bazi.hotelmanagementsystem.repository;

import com.bazi.hotelmanagementsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
