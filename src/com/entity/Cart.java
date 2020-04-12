package com.entity;

public class Cart {

    private int cartid;
    private String bname;
    private int quantity;
    private double price;
    private double total;
    private String picture;
    private int uid;
    private int bid;

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBid() {
        return bid;
    }

    public int getUid() {
        return uid;
    }

    public String getPicture() {
        return picture;
    }

    public double getTotal() {
        return total;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBname() {
        return bname;
    }

    public int getCartid() {
        return cartid;
    }

}
