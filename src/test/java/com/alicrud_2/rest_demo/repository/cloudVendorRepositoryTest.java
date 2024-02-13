package com.alicrud_2.rest_demo.repository;

import com.alicrud_2.rest_demo.model.cloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest  //This is a test annotation provided by Spring Boot for JPA tests. It configures the test with an in-memory database and sets up Spring Data JPA repositories, making it suitable for testing JPA-related components.
public class cloudVendorRepositoryTest {
    @Autowired  //This annotation is used to automatically inject dependencies by Spring. In this case, it injects the cloudVendorRepository instance into the test class.
    private cloudVendorRepository cloudVendorRepository;
    cloudVendor cloudVendor;

    @BeforeEach // This annotation denotes a method that should be run before each test method.
    void setUp() {
        cloudVendor=new cloudVendor("2","faizal","tj","111");
        cloudVendorRepository.save(cloudVendor);

    }

    @AfterEach //This annotation denotes a method that should be run after each test method.
    void tearDown() {
        cloudVendor=null;
        cloudVendorRepository.deleteAll();
    }
    //test case SUCCESS
    @Test
    void testFindByVendorName_found()
    {
        List<cloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("faizal");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }
    @Test
    void testFindByVendorName_NotFound()
    {
        List<cloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("ali");
        assertThat(cloudVendorList.isEmpty()).isFalse();
    }
}
