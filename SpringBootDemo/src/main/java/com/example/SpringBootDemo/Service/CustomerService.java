package com.example.SpringBootDemo.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;

@Component
public interface CustomerService {

    /** Get All Customer */
    List<Customer> getCustomers();
}
