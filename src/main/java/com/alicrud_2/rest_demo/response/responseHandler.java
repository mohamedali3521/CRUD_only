package com.alicrud_2.rest_demo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class responseHandler { // this code is for custom response.
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpstatus,Object responseObject)
    {
        Map<String, Object> response=new HashMap<>();
        response.put("message",message);
        response.put("httpStatus",httpstatus);
        response.put("data",responseObject);
        return new ResponseEntity<>(response,httpstatus); // here it makes the given data with it according to hashmap.
    }
}
