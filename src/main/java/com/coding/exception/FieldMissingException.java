package com.coding.exception;

/**
 * This is custom exception if some field is missing
 *
 * @author Sanjeev Kumar Singh
 * @version test
 */
public class FieldMissingException extends RuntimeException {


    public FieldMissingException(String field) {
        super(field + " is missing");
    }

}
