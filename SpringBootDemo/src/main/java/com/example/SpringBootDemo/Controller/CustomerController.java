package com.example.SpringBootDemo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;
import com.example.SpringBootDemo.Service.CustomerService;
import com.example.SpringBootDemo.Utils.AppUtils;
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
        logger.info("in!!");
        try {
            logger.info("List Customer!!");
            List<Customer> customers = customerService.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            e.printStackTrace();
            logger.error("Exception -" + AppUtils.getLogSupport(e));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("out!!");
    }

    /**
     *Insert data
     *
     *@param json the Body
     */
    @PostMapping("/inserCustomer")
    public ResponseEntity<Object> saveCusotmer(@RequestBody String json) {

        logger.info("in!!");
        try {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO = (CustomerDTO) JsonUtils.convertToObject(json, new TypeReference<CustomerDTO>() {});
            return new ResponseEntity<>(customerService.insert(customerDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("out!!");
    }

    
}
