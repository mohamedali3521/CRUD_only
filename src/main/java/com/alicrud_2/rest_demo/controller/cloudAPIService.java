package com.alicrud_2.rest_demo.controller;

import com.alicrud_2.rest_demo.model.cloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")

public class cloudAPIService {
    cloudVendor cloudVendor;
    @GetMapping("{vendorId}")
    public cloudVendor getcloudVendorDetails(String vendorId)
    {
        return cloudVendor;
    }
    @PostMapping
    public String createCloudVendor(@RequestBody cloudVendor cloudVendor){
        this.cloudVendor=cloudVendor;
        return "cloud vendor details are created successfully";
    }
    @PutMapping
    public String updateCloudVendor(@RequestBody cloudVendor cloudVendor){
        this.cloudVendor=cloudVendor;
        return "cloud vendor data updated successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(String vendorId){
        this.cloudVendor=null;
        return "cloud vendor data deleted successfully";
    }

}
