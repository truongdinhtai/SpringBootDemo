package com.example.SpringBootDemo.Repository.Impl;

import javax.persistence.EntityManager;

import com.example.SpringBootDemo.Entity.QCustomer;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.example.SpringBootDemo.Repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

public abstract class BaseRepositoryImpl <T,ID> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID>{

	EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    protected  final QCustomer customer = QCustomer.customer;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em=em;
        this.jpaQueryFactory=new JPAQueryFactory(em);
    }
}
