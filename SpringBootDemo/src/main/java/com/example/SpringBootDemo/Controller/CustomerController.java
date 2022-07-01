package com.example.SpringBootDemo.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class.getName());

    @Autowired
    private CustomerService customerService;

    /**
     * Get All Customer
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        logger.info("process!!");
        try {
            logger.info("List Customer!!");
            List<Customer> customers = customerService.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *Insert data
     *
     *@param json the Body
     */
    @PostMapping("/inserCustomer")
    public ResponseEntity<Object> saveCusotmer(@RequestBody String json) {
        logger.info("In!!");
        try {
            logger.info("Insert customer!!");
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO = (CustomerDTO) JsonUtils.convertToObject(json, new TypeReference<CustomerDTO>() {});
            return new ResponseEntity<Object>(customerService.insertCustomer(customerDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *Get Customer by Id
     *
     *@PathVariable id
     */
    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }

    /**
     *Update Customer
     *
     *@param customer the CustomerDTO
     *@param id
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable long id,@RequestBody CustomerDTO customer) {
        logger.info("In!!");
        try {
            logger.info("Update customer!!");
            customerService.updateCustomer(id, customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *Delete Customer by Id
     *
     *@param id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
        logger.info("In!!");
        try {
            logger.info("Delete customer!!");
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Get Customer by email
     * 
     * @PathVariable customerEmail
     */
    @GetMapping("/find/{customerEmail}")
    public Optional<Customer> findCustomerByEmail(@PathVariable String customerEmail) {
        return customerService.findCustomerByEmail(customerEmail);
        
    }
}
