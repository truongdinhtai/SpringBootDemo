package com.example.SpringBootDemo.Repository;

import org.springframework.stereotype.Repository;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Modifying
    @Query(value = "insert into Customer (id,customer_Name,customer_Email, phone) "
            + "VALUES(:id,:customerName,:customerEmail,:phone)", nativeQuery = true)
    public void insertCustomerUsingQueryAnnotationn(@Param("id") Long id, @Param("customerName") String customerName,
            @Param("customerEmail") String customerEmail, @Param("phone") String phone);
}