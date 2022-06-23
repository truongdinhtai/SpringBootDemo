package com.example.SpringBootDemo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    /** The Id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /** The Customer Name*/
    @Column(name = "customer_Name")
    private String customerName;

    /** The Customer Email */
    @Column(name = "customer_Email")
    private String customerEmail;

    /** The Phone*/
    @Column(name = "phone")
    String phone;
}
