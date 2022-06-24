package com.example.SpringBootDemo.DTO;


import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    /** The Id */
    private Long id;

    /** The Customer Name*/
    private String customerName;

    /** The Customer Email */
    private String customerEmail;

    /** The Phone*/
    String phone;

    private Set<String> addresses;
}
