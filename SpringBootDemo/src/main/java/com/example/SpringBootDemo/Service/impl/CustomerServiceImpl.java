package com.example.SpringBootDemo.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;
import com.example.SpringBootDemo.Repository.CustomerRepository;
import com.example.SpringBootDemo.Service.CustomerService;
import com.example.SpringBootDemo.Utils.MergingObjects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Get All Customer
     */
    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    /**
     * Insert Customer
     * 
     * @param customerDTO the CustomerDTO
     * */
    @Override
    public ResponseEntity<Object> insert(CustomerDTO customerDTO) {
        try {
            Customer cus = new Customer();
            cus = (Customer) MergingObjects.mergeObject(customerDTO, Customer.class);
            customerRepository.save(cus);
            return new ResponseEntity<>(cus, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
