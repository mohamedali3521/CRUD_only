package com.alicrud_2.rest_demo.exception;

public class cloudVendorNotFoundException extends RuntimeException{

    public cloudVendorNotFoundException(String message) { // here we create the constructor for the class. which is already inbuilt method.
        super(message);
    }


}
