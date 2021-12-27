package com.bazi.hotelmanagementsystem.service.implementation;

import com.bazi.hotelmanagementsystem.model.Customer;
import com.bazi.hotelmanagementsystem.repository.CustomerRepository;
import com.bazi.hotelmanagementsystem.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(String ssn, String email, String firstName, String lastName) {
        if(this.customerRepository.findById(ssn).isEmpty())
        {
            this.customerRepository.save(new Customer(ssn, email, firstName, lastName));
        }
    }
}
