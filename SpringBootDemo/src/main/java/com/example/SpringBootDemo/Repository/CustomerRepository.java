package com.example.SpringBootDemo.Repository;

import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;


import com.example.SpringBootDemo.Entity.Customer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public static final JPAQueryFactory jpaQueryFactory = null;
    @Modifying
    @Transactional
    @Query(value = "insert into Customer (id,customer_Name,customer_Email, phone) "
            + "VALUES(:id,:customerName,:customerEmail,:phone)", nativeQuery = true)
    public void insertCustomerUsingQueryAnnotationn(@Param("id") Long id, @Param("customerName") String customerName,
            @Param("customerEmail") String customerEmail, @Param("phone") String phone);

    @Modifying
    @Transactional
    @Query(value = "insert into Customer (id,customer_Name,customer_Email, phone) "
            + "VALUES(:customer.id,:customer.customerName,:customer.customerEmail,:customer.phone)", nativeQuery = true)
    public void insertCustomerUsingQueryAnnotation(@Param("customer") Customer cus);

    @Modifying
    @Transactional
    @Query("update Customer s SET s.customerName = :customerName WHERE s.id = :id")
    public void updateCustomerUsingQueryAnnotation(@Param("customerName") String customerName, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query("delete from Customer s where s.id = :id")
    public void deleteCustomerUsingQueryAnnotation(@Param("id") Long id);

    @Query("select s from Customer s where s.id = :id")
    public Customer findByIdd(@Param("id") Long id);

    @Query("select s from Customer s")
    public List<Customer> getAllCustomers();

    @Override
    public default List<Customer> getAuthors() {
        return jpaQueryFactory
                .select(author)
                .distinct();
    }
}