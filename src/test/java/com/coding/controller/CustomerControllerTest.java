package com.coding.controller;

import com.coding.exception.CustomerIdNotFoundException;
import com.coding.exception.CustomerNotCreatedException;
import com.coding.model.Customer;
import com.coding.repository.CustomerRepository;
import com.coding.service.CustomerService;
import com.coding.service.impl.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * CustomerControllerTest.java -  This class is contains test cases for the API. And test the basics of api.
 *
 * @author Sanjeev Kumar Singh
 * @version test
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository repository;

    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUP() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    /**
     * This method test the get API by id if data is found then give us the result as expected or not.
     */
    @Test
    public void getCustomerSuccessTest() throws Exception {
        Customer customer = getCustomerBean();
        String jsonRequest = mapper.writeValueAsString(customer);
        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(customer));

        MvcResult result = mockMvc.perform(get("/api/customer/{id}", 101).content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }


    /**
     * This method test the get API by id if data is not found then give us the result as expected or not.
     */
    @Test
    public void getCustomerFailedTest() throws Exception {
        Customer customer = getCustomerBean();
        String jsonRequest = mapper.writeValueAsString(customer);
        Mockito.when(repository.findById(anyLong())).thenThrow(new CustomerIdNotFoundException());

        MvcResult result = mockMvc.perform(get("/api/customer/{id}", 101).content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andReturn();
        assertEquals(404, result.getResponse().getStatus());
    }

    /**
     * This method test the API if it saved the data in database successfully and give us the result as expected.
     */

    @Test
    public void CustomerSaveSuccessTest() throws Exception {
        Customer customer = getCustomerBean();
        String jsonRequest = mapper.writeValueAsString(customer);
        Mockito.when(repository.save(any(Customer.class))).thenReturn(customer);

        MvcResult result = mockMvc.perform(post("/api/customer").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201))
                .andReturn();
        assertEquals(201, result.getResponse().getStatus());
    }

    /**
     * This method test the API if it didn't save the data in database and give us the result as expected.
     */
    @Test
    public void CustomerSaveFailedTest() throws Exception {
        Customer customer = getCustomerBean();
        String jsonRequest = mapper.writeValueAsString(customer);
        Mockito.when(repository.save(any(Customer.class))).thenThrow(new CustomerNotCreatedException());

        MvcResult result = mockMvc.perform(post("/api/customer").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andReturn();
        assertEquals(400, result.getResponse().getStatus());
    }

    /**
     * This method test the Service layer flow and their functionality as expected or not.
     */
    @Test
    public void getCustomer_ServiceTest() throws Exception {
        Customer customer = getCustomerBean();
        when(repository.findById(anyLong())).thenReturn(java.util.Optional.of(customer));
        Customer expect = customerService.getCustomer(101l);
        assertEquals("101", expect.getId().toString());
    }

    /**
     * This method test the Service layer flow and their functionality as expected or not.
     */
    @Test
    public void SaveCustomerServiceTest() throws Exception {
        Customer customer = getCustomerBean();
        when(repository.save(customer)).thenReturn(customer);
        assertEquals(customer, customerService.createCustomer(customer));
    }

    /*
     * This method returns the customer bean for testing.
     */
    private static Customer getCustomerBean() {
        Customer customer = new Customer();
        customer.setId(101l);
        customer.setPassword("sanjeev123");
        customer.setFirstName("sanjeev");
        customer.setLastName("singh");
        customer.setEmail("abc103@gmail.com");
        return customer;
    }
}