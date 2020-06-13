package com.coding.exception;
/***
 *This class is custom exception for id not found
 *
 * @author Sanjeev Kumar Singh
 * @version test
 */

public class CustomerIdNotFoundException extends RuntimeException {

    public CustomerIdNotFoundException() {

        super("CustomerId Not found in database");
    }
    public CustomerIdNotFoundException(String message) {

        super(message);
    }
}
