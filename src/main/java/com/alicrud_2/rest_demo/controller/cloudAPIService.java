package com.alicrud_2.rest_demo.controller;

import com.alicrud_2.rest_demo.model.cloudVendor;
import com.alicrud_2.rest_demo.response.responseHandler;
import com.alicrud_2.rest_demo.service.cloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")

public class cloudAPIService {
    cloudVendorService cloudVendorService;
    public cloudAPIService(cloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }
    //this is for read particular data.
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getcloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        return responseHandler.responseBuilder("the given id details are", HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }
    // this is for read all data.
    @GetMapping()
    public List<cloudVendor> getAllcloudVendorDetails()
    {
        return cloudVendorService.getAllCloudVendors();
    }
    @PostMapping
    public String createCloudVendor(@RequestBody cloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor details are created successfully";
    }
    @PutMapping
    public String updateCloudVendor(@RequestBody cloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor data updated successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "cloud vendor data deleted successfully";
    }

}
