package com.example.SpringBootDemo.Service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.getAllCustomers().forEach(customers::add);
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
            customerRepository.insertCustomerUsingQueryAnnotation(cus);
            return new ResponseEntity<>(cus, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	public Customer findById(Long id) {
		Customer customerResponse = customerRepository.findByIdd(id);
		return customerResponse;
	}
	
	public String insertCustomer(Customer customer) {
		Long id = customer.getId();
		String customerName = customer.getCustomerName();
		String customerEmail = customer.getCustomerEmail();
		String phone = customer.getPhone();
		customerRepository.insertCustomerUsingQueryAnnotationn(id, customerName, customerEmail, phone);
		return "Record inserted successfully using @Modifiying and @query Named Parameter";
	}

	public String updateCustomer(CustomerDTO customer) {
		String mes = "sd";
		try {
			customerRepository.updateCustomerUsingQueryAnnotation(customer.getCustomerName(), customer.getId());
            return mes;
        } catch (Exception e) {
        	return mes;
        }
	}

	public String deleteCustomer(CustomerDTO customer) {
		try {
			customerRepository.deleteCustomerUsingQueryAnnotation(customer.getId());
            return null;
        } catch (Exception e) {
            return null;
        }
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
}
