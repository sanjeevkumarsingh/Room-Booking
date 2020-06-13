package com.coding.controller;

import com.coding.exception.CustomerIdNotFoundException;
import com.coding.exception.CustomerNotCreatedException;
import com.coding.model.Customer;
import com.coding.service.CustomerService;
import com.coding.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * CustomerController.java - A REST controller with post and get API to store and retrieve customer data.
 * Url of this controller is "/api"
 *
 * @author Sanjeev Kumar Singh
 * @version test
 */

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    Util util;

    @GetMapping(value = "/greeting")
    public String greeting() {
        return "welcome";
    }

    /**
     * Accept Customer object and Returns the Entity if data is stored successfully with status code 201 else return status code 400.
     * url of this API is "/customer"
     *
     * @param customer an object that need to be saved in database must not exist in database before.
     * @return ResponseEntity with status code
     */

    @PostMapping(value = "/customer")
    public ResponseEntity<?> create(@Valid @RequestBody Customer customer) {
        try {
            if (customer != null) {
                if (!StringUtils.isEmpty(customer.getEmail()) && !StringUtils.isEmpty(customer.getPassword())) {
                    Boolean isExistingCustomer = customerService.verifyCustomer(customer);
                    if (!isExistingCustomer) {
                        if (util.validatePassword(customer.getPassword())) {
                            customer = customerService.createCustomer(customer);

                            if (customer != null && !StringUtils.isEmpty(customer.getId()))
                                return ResponseEntity.status(HttpStatus.CREATED).body(customer);
                            else
                                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(customer);
                        } else
                            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer password length should be between 8-10 character!");

                    } else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Email's already exist in Database, Please Verify!");
                    }
                } else
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer EmailId/Password should not be null !");
            } else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Object can Not be Null !");
        }catch (CustomerNotCreatedException ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not created !");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }

    }


    /**
     * Accept Customer id and Returns the Entity if data exist with status code 201 else return status code 404.
     * url of this API is "/customer/{id}"
     *
     * @param id employee id to uniquely identify the customer in database, must exist in database.
     * @return ResponseEntity with status code
     */

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) throws CustomerIdNotFoundException {
        if(!StringUtils.isEmpty(id)) {
            try {
                Customer cust = customerService.getCustomer(id);
                if (cust != null)
                    return ResponseEntity.status(HttpStatus.OK).body(cust);
            }catch (CustomerIdNotFoundException ex) {
                ex.printStackTrace();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CustomerId Not found in database");
            }catch (Exception ex){
                ex.printStackTrace();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something is wrong");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id can not be blank");
        }
    }
}
