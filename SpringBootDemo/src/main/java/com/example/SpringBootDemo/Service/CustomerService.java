package com.example.SpringBootDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;

@Component
public interface CustomerService {

    /** Get All Customer */
    List<Customer> getAllCustomers();

    /** Insert Customer */
    public boolean insertCustomer(CustomerDTO customerDTO);

    /** Find by id Customer */
    public Optional<Customer> findById(long id);

    /** Update Customer */
    public boolean updateCustomer(long id, CustomerDTO customerDTO);

    /** Delete Customer */
    public boolean deleteCustomer(long id);

    public Optional<Customer> findCustomerByEmail(String customerEmail);

}