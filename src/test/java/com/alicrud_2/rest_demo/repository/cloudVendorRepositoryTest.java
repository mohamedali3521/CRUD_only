package com.alicrud_2.rest_demo.repository;

import com.alicrud_2.rest_demo.model.cloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class cloudVendorRepositoryTest {
    @Autowired
    private cloudVendorRepository cloudVendorRepository;
    cloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor=new cloudVendor("2","faizal","tj","111");
        cloudVendorRepository.save(cloudVendor);

    }

    @AfterEach
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
