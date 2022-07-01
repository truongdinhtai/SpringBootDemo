package com.example.SpringBootDemo.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.getAllCustomer().forEach(customers::add);
        return customers;
    }

    /** 
     * Insert Customer
     * 
     * @param customerDTO the CustomerDTO
     * */
    @Override
    public boolean insertCustomer(CustomerDTO customerDTO) {
            Customer cus = new Customer();
            cus = (Customer) MergingObjects.mergeObject(customerDTO, Customer.class);
            return customerRepository.insertCustomer(cus);
    }

    /**
     *Get Customer by Id
     *
     *@PathVariable id
     */
    @Override
    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String customerEmail) {
        return customerRepository.findCustomerByEmail(customerEmail);
    }

    /**
     *Update Customer
     *
     *@param customer the CustomerDTO
     *@param id
     */
    @Override
    public boolean updateCustomer(long id, CustomerDTO customerDTO) {
        Customer cus = new Customer();
        cus = (Customer) MergingObjects.mergeObject(customerDTO, Customer.class);
        return customerRepository.updateCustomer(id, cus);
    }

    /**
     *Delete Customer by Id
     *
     *@param id 
     */
    @Override
    public boolean deleteCustomer(long id) {
        return customerRepository.deleteCustomer(id);
    }
}
