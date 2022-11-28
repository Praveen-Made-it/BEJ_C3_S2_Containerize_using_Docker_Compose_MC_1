/*
 *Author Name:Praveen Kumar
 *Date: 28-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller.CustomerController;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Product;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service.CustomerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerServiceImpl customerService;

    @InjectMocks
    private CustomerController customerController;
    private Customer customer;
    private Product product;
    List<Customer> customerList;

    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch (JsonProcessingException e) {
            result = "JSON processing error";
        }

        return result;
    }

    @BeforeEach
    void setUp() {
        product = new Product(1001, "Dairymilk", "chocolate");
        customer = new Customer(101, "praveen", "9092222610", product);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

    }

    @AfterEach
    void tearDown() {
        product = null;
        customer = null;

    }

    @Test
    public void saveCustomerTestSuccess() throws Exception {
        when(customerService.saveCustomer(any())).thenReturn(customer);
        mockMvc.perform(post("/customerdata/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(customerService, times(1)).saveCustomer(any());

    }

    @Test
    public void deleteCustomerSuccess() throws Exception {
        when(customerService.deleteCustomer(anyInt())).thenReturn(true);
        mockMvc.perform(delete("/customerdata/api/customer/41")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer)))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
        verify(customerService, times(1)).deleteCustomer(anyInt());

    }

}