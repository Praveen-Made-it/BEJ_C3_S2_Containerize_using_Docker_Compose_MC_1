/*
 *Author Name:Praveen Kumar
 *Date: 24-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotFoundException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        boolean flag = false;
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new CustomerNotFoundException();
        } else {
            customerRepository.deleteById(customerId);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Customer> getAllCustomersByProductName(String productName) throws CustomerNotFoundException {
        if (customerRepository.findAllCustomersFromProductName(productName).isEmpty()) {
            throw new CustomerNotFoundException();
        }
        return customerRepository.findAllCustomersFromProductName(productName);
    }
}