package com.alicrud_2.rest_demo.repository;

import com.alicrud_2.rest_demo.model.cloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cloudVendorRepository extends JpaRepository<cloudVendor,String> {
    // this jparepository is the class which have the so much of inbuilt method have in.
}
