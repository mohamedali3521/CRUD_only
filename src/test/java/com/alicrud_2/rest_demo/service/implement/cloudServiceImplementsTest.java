package com.alicrud_2.rest_demo.service.implement;

import com.alicrud_2.rest_demo.model.cloudVendor;
import com.alicrud_2.rest_demo.repository.cloudVendorRepository;
import com.alicrud_2.rest_demo.service.cloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// unit test case are done individually for each piece
class cloudServiceImplementsTest {
    @Mock //This annotation is from Mockito and is used to mock objects.
    private cloudVendorRepository cloudVendorRepository;
    private cloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;  // it is for close all the unwanted resources when the entire text cases execution get finished.
    cloudVendor cloudVendor;


    @BeforeEach //This annotation denotes a method that should be run before each test method.
    void setUp() { //This method is annotated with @BeforeEach, meaning it will run before each test method.
        autoCloseable= MockitoAnnotations.openMocks(this);
        cloudVendorService=new cloudServiceImplements(cloudVendorRepository);
        cloudVendor= new cloudVendor("1","pulsar","trihy","100");
    }

    @AfterEach  //This annotation denotes a method that should be run after each test method.
    void tearDown() throws Exception { //This method is annotated with @AfterEach, meaning it will run after each test method.
        //It closes the autoCloseable resource.
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() { //we have change the method name for the test by adding some words to it.
        mock(cloudVendorRepository.class); //This statement creates a mock object of the cloudVendorRepository class/interface.
        mock(cloudVendor.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("details added succesfully");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(cloudVendorRepository.class);
        mock(cloudVendor.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("details updated successfully");
    }

    @Test
    void testDeleteCloudVendor() {
        mock(cloudVendor.class);
        mock(cloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);
        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("data deleted successfully");
    }

    @Test
    void testGetCloudVendor() {
        mock(cloudVendorRepository.class);
        mock(cloudVendor.class);
        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));

        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void testGetAllCloudVendors() {
        mock(cloudVendor.class);
        mock(cloudVendorRepository.class);
        when(cloudVendorRepository.findAll()).
                thenReturn(new ArrayList<cloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhnNo())
                .isEqualTo(cloudVendor.getVendorPhnNo());
    }
}