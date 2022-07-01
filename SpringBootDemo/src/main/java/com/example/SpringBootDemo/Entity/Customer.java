package com.example.SpringBootDemo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    /** The Id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomer;

    /** The Customer Name*/
    private String customerName;

    /** The Customer Email */
    private String email;

    /** The Phone*/
    String phone;

    @OneToMany(targetEntity = Address.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer",referencedColumnName = "idCustomer")
    private List<Address> address;
}