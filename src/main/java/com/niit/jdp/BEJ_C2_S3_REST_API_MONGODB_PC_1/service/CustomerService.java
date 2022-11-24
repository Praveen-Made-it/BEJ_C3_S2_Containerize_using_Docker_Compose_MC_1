package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomerData() throws Exception;

    boolean deleteCustomer(int customerId) throws ClassNotFoundException;

    List<Customer> getAllCustomerByProductName(String productName) throws CustomerNotFoundException;
}
