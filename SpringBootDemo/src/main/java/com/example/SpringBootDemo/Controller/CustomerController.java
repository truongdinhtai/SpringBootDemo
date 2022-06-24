package com.example.SpringBootDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;
import com.example.SpringBootDemo.Service.CustomerService;
import com.example.SpringBootDemo.Utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Get All Customer
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     *Insert data
     *
     *@param json the Body
     */
    @PostMapping("/inserCustomer")
    public ResponseEntity<Object> saveCusotmer(@RequestBody String json) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO = (CustomerDTO) JsonUtils.convertToObject(json, new TypeReference<CustomerDTO>() {});
        return new ResponseEntity<>(customerService.insert(customerDTO), HttpStatus.CREATED);
    }
}
