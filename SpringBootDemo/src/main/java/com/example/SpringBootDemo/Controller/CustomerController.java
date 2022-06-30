package com.example.SpringBootDemo.Controller;

import java.util.List;

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
        logger.info("process!!");
        try {
            logger.info("List Customer!!");
            List<Customer> customers = customerService.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            e.printStackTrace();
            logger.error("Exception -" + AppUtils.getLogSupport(e));
            return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    /**
     *Get Customer by Id
     *
     *@PathVariable id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        logger.info("In!!");
        try {
            logger.info("Update customer!!");
            Customer customer = customerService.findById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@PostMapping("/inser")
	public String insertCustomer(@RequestBody Customer customer) {
		String response = customerService.insertCustomer(customer);
		return response;
	}

    /**
     *Update Customer
     *
     *@param customer the CustomerDTO
     */
    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDTO customer) {
        logger.info("In!!");
        try {
            logger.info("Update customer!!");
            String response = customerService.updateCustomer(customer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *Delete Customer by Id
     *
     *@param customer the CustomerDTO
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestBody CustomerDTO customer) {
        logger.info("In!!");
        try {
            logger.info("Update customer!!");
            String response = customerService.deleteCustomer(customer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Customers")
    public List<Customer> getALlBooks() {
        return customerService.getCustomers();
    }
}
