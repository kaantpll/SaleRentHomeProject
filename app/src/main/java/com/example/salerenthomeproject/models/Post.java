package com.example.salerenthomeproject.models;


public class Post {

    private String phone;
    private String description;
    private String attribute;
    private String sq;
    private String bedCount;
    private String rentOrSale;
    private String bathCount;

    public Post(){

    }

    public Post(String phone, String description, String attribute, String sq, String bedCount, String rentOrSale, String bathCount) {
        this.phone = phone;
        this.description = description;
        this.attribute = attribute;
        this.sq = sq;
        this.bedCount = bedCount;
        this.rentOrSale = rentOrSale;
        this.bathCount = bathCount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getBedCount() {
        return bedCount;
    }

    public void setBedCount(String bedCount) {
        this.bedCount = bedCount;
    }

    public String getRentOrSale() {
        return rentOrSale;
    }

    public void setRentOrSale(String rentOrSale) {
        this.rentOrSale = rentOrSale;
    }

    public String getBathCount() {
        return bathCount;
    }

    public void setBathCount(String bathCount) {
        this.bathCount = bathCount;
    }
}
