package com.alicrud_2.rest_demo.service.implement;

import com.alicrud_2.rest_demo.exception.cloudVendorNotFoundException;
import com.alicrud_2.rest_demo.model.cloudVendor;
import com.alicrud_2.rest_demo.repository.cloudVendorRepository;
import com.alicrud_2.rest_demo.service.cloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class cloudServiceImplements implements cloudVendorService {
    cloudVendorRepository cloudVendorRepository;//we have to initiate the repository here to do the all operation.
    public cloudServiceImplements(cloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;//create constructor for initialize it.
    }
    @Override
    public String createCloudVendor(cloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);// this is for add the user details into the database by using save method.we also take the variables from cloud vendor from model.
        return "table created succesfully";
    }

    @Override
    public String updateCloudVendor(cloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);// this is for update which more over to the create.
        return "table updated successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);// we can delete the data by using it's id. which is also get the cloud vendor model.
        return "data deleted successfully";
    }

    @Override
    public cloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())  // is this how we check that given id is empty or not
            throw  new cloudVendorNotFoundException("the given user id is not found"); //this is how we throw the exception with message
        return cloudVendorRepository.findById(cloudVendorId).get();//this is to get the single user data by using the id.
    }

    @Override
    public List<cloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();// this is list datatype so it shows the all data from the database.
    }
}
