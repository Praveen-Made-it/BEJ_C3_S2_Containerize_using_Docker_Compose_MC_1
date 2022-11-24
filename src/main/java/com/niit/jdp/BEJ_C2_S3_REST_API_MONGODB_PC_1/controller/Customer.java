/*
 *Author Name:Praveen Kumar
 *Date: 24-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private String customerPhoneNo;
    private Product customerProduct;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerPhoneNo, Product customerProduct) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.customerProduct = customerProduct;
    }
}
