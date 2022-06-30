package com.example.SpringBootDemo.Controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.SpringBootDemo.DTO.CustomerDTO;
import com.example.SpringBootDemo.Entity.Customer;
import com.example.SpringBootDemo.Service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testInserCustomer() throws Exception {
        Customer customer = Customer.builder()
                .customerName("qưe")
                .customerEmail("zsd")
                .phone("qưeeee")
                .build();
        given(customerService.insert((CustomerDTO) any(Customer.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/v1/customer/inserCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName",
                        is(customer.getCustomerName())))
                .andExpect(jsonPath("$.CustomerEmail",
                        is(customer.getCustomerEmail())))
                .andExpect(jsonPath("$.phone",
                        is(customer.getPhone())));
    }

    @Test
    public void testAllCustomer() throws Exception {
        List<Customer> listCustomer = new ArrayList<>();
        listCustomer.add(Customer.builder().customerName("CaptainMarvel").customerEmail("cap@gmail.com").phone("0909192").build());
        listCustomer.add(Customer.builder().customerName("TonyStark").customerEmail("tony@gmail.com").phone("0909192").build());
        given(customerService.getAllCustomers()).willReturn(listCustomer);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/v1/customer"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listCustomer.size())));
    }

    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject() throws Exception{
        // given - precondition or setup
        long employeeId = 1L;
        Customer customer = Customer.builder()
                .customerName("Ramesh")
                .customerEmail("Fadatare")
                .phone("ramesh@gmail.com")
                .build();
        given(customerService.findById(employeeId)).willReturn(customer);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/v1/customer/{id}", employeeId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(customer.getCustomerName())))
                .andExpect(jsonPath("$.lastName", is(customer.getCustomerEmail())))
                .andExpect(jsonPath("$.email", is(customer.getPhone())));
    }
}
