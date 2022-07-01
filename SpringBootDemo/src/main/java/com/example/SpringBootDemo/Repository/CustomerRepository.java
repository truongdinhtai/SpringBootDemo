package com.example.SpringBootDemo.Repository;

import org.springframework.stereotype.Repository;

import com.example.SpringBootDemo.Entity.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends BaseRepository<Customer,Long>{

    public List<Customer> getAllCustomer();

    public boolean insertCustomer(Customer cus);

    public boolean updateCustomer(long id, Customer cus);

    public boolean deleteCustomer(long id);

    public Optional<Customer> findById(long id);

    public Optional<Customer> findCustomerByEmail(String customerEmail);

}