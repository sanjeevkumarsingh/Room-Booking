package com.coding.repository;

import com.coding.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository.java - A java interface that inherits the jpaRepository to get it's funcionality
 * if more functionality needed it can have it's own function definition.
 *
 * @author sanjeev singh
 * @version test
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmailIgnoreCase(String email);
}
