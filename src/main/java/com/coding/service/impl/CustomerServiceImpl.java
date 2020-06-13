package com.coding.service.impl;

import com.coding.exception.CustomerIdNotFoundException;
import com.coding.exception.CustomerNotCreatedException;
import com.coding.model.Customer;
import com.coding.repository.CustomerRepository;
import com.coding.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * CustomerServiceImpl.java -  it implements the CustomerService interface and provide the implementation/functionality to them
 *
 * @author sanjeev kumar singh
 * @version test
 * @see com.coding.service.CustomerService
 */

@Component
public class CustomerServiceImpl implements CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Retrieve the customer from database by id
     *
     * @return A Customer DataType or throw exception.
     */

    @Override
    public Customer getCustomer(Long id) throws CustomerIdNotFoundException {

        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            return customer;

        } else
            throw new CustomerIdNotFoundException();
    }

    /**
     * Retrieve the customer from database by id
     *
     * @return A Customer DataType or null if id not found.
     */
    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElse(null);
    }

    /**
     * Store the customer in database
     *
     * @return A Customer DataType or throw exception.
     */
    @Override
    public Customer createCustomer(Customer customer) throws CustomerNotCreatedException {
        if (customer != null && !StringUtils.isEmpty(customer)) {
            try{
                customer = customerRepository.save(customer);
                return customer;
            }catch (Exception ex){
                logger.warn(ex.getLocalizedMessage());
                throw new CustomerNotCreatedException(ex.getLocalizedMessage());
            }
        }
        else {
            throw new CustomerNotCreatedException();
        }
    }
    /**
     * verify if  the customer in exist in database or not
     *
     * @param customer - it will accept customer object and will check the existing customer with email id.
     * @return A Boolean DataType.
     */
    @Override
    public boolean verifyCustomer(Customer customer) {
        if (customer != null && !StringUtils.isEmpty(customer.getEmail()) && !StringUtils.isEmpty(customer.getPassword())) {
            Customer existingCustomer = customerRepository.findByEmailIgnoreCase(customer.getEmail().trim());
            if(existingCustomer!=null && !StringUtils.isEmpty(existingCustomer.getId())) {
                    return true;
            } else {
                return false;
            }
        }
         return false;
    }
    @Override
    public Customer updateCustomer(Customer customer){
        //TODO
        return null;
    }
}
