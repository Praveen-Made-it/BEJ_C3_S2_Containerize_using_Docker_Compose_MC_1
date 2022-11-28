/*
 *Author Name:Praveen Kumar
 *Date: 28-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.repository;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller.CustomerController;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Product;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    List<Customer> customerList;
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private CustomerServiceImpl customerService;
    @InjectMocks
    private CustomerController customerController;
    private Customer customer;
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1011, "dairy Milk", "chocolate");
        customer = new Customer(101, "Praveen", "9092222610", product);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

    }


}
