package com.coding.handler;

import com.coding.exception.FieldMissingException;
import com.coding.exception.CustomerIdNotFoundException;
import com.coding.exception.CustomerNotCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

/**
 * CustomerExceptionHandler.java - is global exception handler class for the services and controller
 *
 * @author sanjeev singh
 * @version test
 * */
@RestControllerAdvice
public class CustomeExceptionHandler {

    /**
     * Custom exception if some field is missing
     * */
    @ExceptionHandler(FieldMissingException.class)
    public ResponseEntity<Object> fieldMissing(FieldMissingException ex) {
        return new ResponseEntity(new ErrorResponse(LocalDate.now(), ex.getMessage(), "Some field is missing in input json"), HttpStatus.BAD_REQUEST);
    }
    /**
     * Custom exception if because of some reason customer not created.
     * */
    @ExceptionHandler(CustomerNotCreatedException.class)
    public ResponseEntity<Object> userNotCreated(CustomerNotCreatedException ex) {
        return new ResponseEntity(new ErrorResponse(LocalDate.now(), ex.getMessage(), "Customer data not saved in database"), HttpStatus.BAD_REQUEST);
    }
    /**
     * Custom exception if customer id is not availabe in dtabase.
     * */
    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<Object> userNotFound(CustomerIdNotFoundException ex) {
        return new ResponseEntity(new ErrorResponse(LocalDate.now(), ex.getMessage(), "CustomerId not found in database"), HttpStatus.NOT_FOUND);
    }

    /**
     * To handle all unhandled exception.
     * */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> somethingNorRight(Exception ex) {
        return new ResponseEntity(new ErrorResponse(LocalDate.now(), ex.getMessage(), "Something went wrong"), HttpStatus.NOT_IMPLEMENTED);
    }
}
