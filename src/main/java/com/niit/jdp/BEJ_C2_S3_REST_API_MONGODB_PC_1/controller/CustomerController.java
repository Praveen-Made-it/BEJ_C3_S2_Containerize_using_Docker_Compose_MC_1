/*
 *Author Name:Praveen Kumar
 *Date: 24-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customerdata/api/")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
}
