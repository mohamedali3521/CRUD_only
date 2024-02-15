package com.alicrud_2.rest_demo.service;

import com.alicrud_2.rest_demo.model.cloudVendor;

import java.util.List;

public interface cloudVendorService {      // we just declaare the what are the methods are going to expose. we have to defining these method where which class is implements it.
    public String createCloudVendor(cloudVendor cloudVendor);
    public String updateCloudVendor(cloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public cloudVendor getCloudVendor(String cloudVendorId);
    public List<cloudVendor> getAllCloudVendors();

}
