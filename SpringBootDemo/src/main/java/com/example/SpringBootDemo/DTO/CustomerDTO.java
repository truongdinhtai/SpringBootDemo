package com.example.SpringBootDemo.DTO;

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
    private String email;

    /** The Phone*/
    String phone;
}