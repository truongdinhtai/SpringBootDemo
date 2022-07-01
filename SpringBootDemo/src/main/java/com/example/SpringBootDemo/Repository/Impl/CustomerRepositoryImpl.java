package com.example.SpringBootDemo.Repository.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.example.SpringBootDemo.Entity.Customer;
import com.example.SpringBootDemo.Repository.CustomerRepository;

public abstract class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository{

    public CustomerRepositoryImpl(EntityManager em) {
        super(Customer.class, em);
    }

    public boolean insertCustomer(Customer cus) {
        long insert = jpaQueryFactory
                       .insert(customer)
                       .values(cus)
                       .execute();
        if (insert < 0) {
            return false;
        }
        return true;
    }

    public boolean updateCustomer(long id, Customer cus) {
        long update = jpaQueryFactory
                        .update(customer)
                        .where(customer.idCustomer.eq(id))
                        .execute();
        if (update < 0) {
            return false;
        }
        return true;
    }

    public boolean deleteCustomer(long id) {
        long delete = jpaQueryFactory
                        .delete(customer)
                        .where(customer.idCustomer.eq(id))
                        .execute();
        if (delete < 0) {
            return false;
        }
        return true;
    }

    public Optional<Customer> findCustomerByEmail(String customerEmail) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(customer)
                        .from(customer)
                        .where(customer.email.equalsIgnoreCase(customerEmail))
                        .fetchFirst());
    }

    public List<Customer> getAllCustomer() {
        return jpaQueryFactory
                       .select(customer)
                       .from(customer)
                       .fetch();
    }

    public Optional<Customer> findById(long id) {
        return Optional.ofNullable(
                jpaQueryFactory
                       .select(customer)
                       .from(customer)
                       .where(customer.idCustomer.eq(id))
                       .fetchFirst());
    }
}