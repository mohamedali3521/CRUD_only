package com.alicrud_2.rest_demo.model;

public class cloudVendor {
    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhnNo;
    public cloudVendor() {
    }
    public cloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhnNo) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhnNo = vendorPhnNo;
    }


    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhnNo() {
        return vendorPhnNo;
    }

    public void setVendorPhnNo(String vendorPhnNo) {
        this.vendorPhnNo = vendorPhnNo;
    }






}
