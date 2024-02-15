package com.alicrud_2.rest_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  //this annotation is used to globally handle all the exception occur.
public class cloudVendorExceptionalHandler {
    @ExceptionHandler(value = {cloudVendorNotFoundException.class}) // this annotation is used to handle the specific exception which is client have to understand (simply we created the exception with our own words).
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (cloudVendorNotFoundException cloudVendorNotFoundException){
        cloudVendorException cloudVendorException=new cloudVendorException(cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }
}