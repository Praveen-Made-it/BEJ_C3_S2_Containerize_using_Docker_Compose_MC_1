/*
 *Author Name:Praveen Kumar
 *Date: 24-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotFoundException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customerdata/api/")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> insertCustomer(@RequestBody Customer customer) {
        Customer customerPost = customerService.saveCustomer(customer);
        return new ResponseEntity<>(customerPost, HttpStatus.CREATED);
    }

    @GetMapping("customer")
    public ResponseEntity<?> fetchAllCustomer() {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("customer/{customerId}")
    public ResponseEntity<?> deleteSingleCustomer(@PathVariable("customerId") int customerId) throws CustomerNotFoundException {
        ResponseEntity responseEntity = null;
        try {
            customerService.deleteCustomer(customerId);
            responseEntity = new ResponseEntity("Successfully deleted the 1 record", HttpStatus.OK);
        } catch (ClassNotFoundException cnfe) {
            throw new CustomerNotFoundException();
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("customers/{productName}")
    public ResponseEntity<?> fetchByCustomerProductName(@PathVariable String productName) {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomersByProductName(productName), HttpStatus.FOUND);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
