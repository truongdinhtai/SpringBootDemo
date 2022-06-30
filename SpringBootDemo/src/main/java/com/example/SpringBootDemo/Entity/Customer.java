package com.example.SpringBootDemo.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name="customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

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

//    @OneToMany(mappedBy = "address",s fetch = FetchType.LAZY)
//    private Set<Address> addresses = new HashSet<>();
}
