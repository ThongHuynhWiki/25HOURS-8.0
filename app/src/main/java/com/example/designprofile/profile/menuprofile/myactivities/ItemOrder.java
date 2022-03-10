package com.example.designprofile.profile.menuprofile.myactivities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class ItemOrder {

    private String orderID;
    private String status;
    private List<ItemProduct> productList;

    public ItemOrder(String orderID, String status, List<ItemProduct> productList) {
        this.orderID = orderID;
        this.status = status;
        this.productList = productList;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<ItemProduct> productList) {
        this.productList = productList;
    }

}
