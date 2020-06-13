package com.coding.service;


import com.coding.model.Customer;

/**
 * CustomerService.java -  A interface that provides the definition of the service available for the customer.
 *
 * @author sanjeev singh
 * @version test
 */
public interface CustomerService {
    public Customer getCustomer(Long id);

    public Customer getCustomerById(Long id);

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public boolean verifyCustomer(Customer customer);
}
