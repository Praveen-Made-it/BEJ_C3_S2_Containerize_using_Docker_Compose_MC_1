package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.repository;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Product product;
    private Customer customer;
    @BeforeEach
    void setUp() {
        product = new Product(1, "Apple", "Laptop");
        customer = new Customer(1, "praveen", "9092222610", product);
    }

    @AfterEach
    void tearDown() {
        product = null;
        customer = null;

    }

    @Test
        //Test case for saving a customer object.
    void giveCustomerToSaveReturnSavedCustomer() {
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustomerId(), customer1.getCustomerId());
    }

    @Test
    //Test case for deleting a customer object by customer Id.
    public void toDeleteCustomerById() {
        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(customer1);
        assertEquals(Optional.empty(), customerRepository.findById(customer.getCustomerId()));
    }

    @Test
    //Test Case for retrieving all the customers by product Name.
    public void toGetCustomerByProductName() {
        customerRepository.insert(customer);
        product = new Product(2, "Vivo", "Mobile");
        customer = new Customer(2, "kumar", "9093333610", product);
        customerRepository.insert(customer);
        List<Customer> customers = customerRepository.findAllCustomersFromProductName(customer.getCustomerProduct().getProductName());
        assertEquals(1, customers.size());
        assertEquals(customer.getCustomerProduct().getProductName(), customers.get(0).getCustomerProduct().getProductName());
    }

    @Test
    //Test Case for retrieving all the customers by product Name for failure.
    public void toGetCustomerByProductNameFail() {
        customerRepository.insert(customer);
        product = new Product(100, "Apple", "Mobile");
        customer = new Customer(100, "kumar", "9093333610", product);
        customerRepository.insert(customer);
        List<Customer> customers = customerRepository.findAllCustomersFromProductName(customer.getCustomerProduct().getProductName());
        assertNotEquals(12, customers.size());
        assertEquals(customer.getCustomerProduct().getProductName(), customers.get(0).getCustomerProduct().getProductName());
    }

}