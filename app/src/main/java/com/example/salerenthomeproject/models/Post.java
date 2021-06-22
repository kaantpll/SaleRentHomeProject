package com.example.salerenthomeproject.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts")
public class Post {

    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "attribute")
    private String attribute;
    @ColumnInfo(name = "sq")
    private String sq;
    @ColumnInfo(name = "bedCount")
    private String bedCount;
    @ColumnInfo(name = "rentOrSale")
    private String rentOrSale;
    @ColumnInfo(name = "bathCount")
    private String bathCount;
    @ColumnInfo(name = "mImageUrl")
    private String imageUrl;
    @ColumnInfo(name = "price")
    private String price;
    @PrimaryKey
    private int id ;



    public Post(){

    }

    public Post(String phone, String description, String attribute, String sq, String bedCount, String rentOrSale, String bathCount,String imageUrl,String price) {
        this.phone = phone;
        this.description = description;
        this.attribute = attribute;
        this.sq = sq;
        this.bedCount = bedCount;
        this.rentOrSale = rentOrSale;
        this.bathCount = bathCount;
        this.imageUrl = imageUrl;
        this.price = price;

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
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
