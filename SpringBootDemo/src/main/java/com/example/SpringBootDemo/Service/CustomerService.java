package com.example.SpringBootDemo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;

@Component
public interface CustomerService {

    /** Get All Customer */
    List<Customer> getAllCustomers();

    /** Insert Customer */
    ResponseEntity<Object> insert(CustomerDTO customerDTO);

    /** Find by id Customer */
    public Customer findById(Long id);
    public String insertCustomer(Customer customer);

    /** Update Customer */
    public String updateCustomer(CustomerDTO customer);

    /** Delete Customer */
    public String deleteCustomer(CustomerDTO customer);

    public List<Customer> getCustomers();
}
