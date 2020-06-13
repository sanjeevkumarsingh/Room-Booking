package com.coding.exception;
/**
 * This is custom exception for custoner not created
 *
 * @author Sanjeev kumar Singh
 * @version test
 * */
public class CustomerNotCreatedException extends RuntimeException {

    public CustomerNotCreatedException() {
        super("User not saved in Database");
    }
    public CustomerNotCreatedException(String message) {

        super(message + " : User not saved in Database");
    }
}
