package com.alicrud_2.rest_demo.controller;

import com.alicrud_2.rest_demo.model.cloudVendor;
import com.alicrud_2.rest_demo.service.cloudVendorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(cloudAPIService.class)  //This annotation is used to specify that the test focuses only on the cloudAPIService class.
    // This helps in isolating the testing scope and speeds up the test execution by loading only the necessary components.

class cloudAPIServiceTest {
    @Autowired  //This autowires an instance of MockMvc, which is provided by Spring Test for performing HTTP requests and asserting responses in Spring MVC tests.
    private MockMvc mockMvc;
    @MockBean  //This creates a mock bean for the cloudVendorService class, allowing you to define its behavior in the tests.
    private cloudVendorService cloudVendorService;
    cloudVendor cloudVendorOne;
    cloudVendor cloudVendorTwo;
    List<cloudVendor> cloudVendorList=new ArrayList<>();
    AutoCloseable autoCloseable;
    @BeforeEach  ////This annotation denotes a method that should be run before each test method.
    void setUp() {
        cloudVendorOne=new cloudVendor("1","zayan","chennai","123");
        cloudVendorTwo=new cloudVendor("2","ali","trichy","234");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() throws Exception {


    }

    @Test
    void testGetCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateCloudVendor() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("cloud vendor details are created successfully");
        this.mockMvc.perform(post("/cloudvendor").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateCloudVendor() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorTwo);

        when(cloudVendorService.updateCloudVendor(cloudVendorTwo)).thenReturn("data updated successfully");
        this.mockMvc.perform(put("/cloudvendor").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testDeleteCloudVendor() throws Exception{
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("data deleted successfully");
        this.mockMvc.perform(delete("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }
}