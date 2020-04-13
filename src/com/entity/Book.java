package com.entity;

import java.sql.Date;

public class Book {

    private int bid;
    private String bname;
    private String author;
    private double price;
    private int pagenum;
    private int cid;
    private String picture;
    private String summary;
    private Date createTime;
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getBid() {
        return bid;
    }

    public String getBname() {
        return bname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(int bid) {
        this.bid = bid;
    }

    public void setName(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getId() {
        return bid;
    }

    public String getName() {
        return bname;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPagenum() {
        return pagenum;
    }

    public int getCid() {
        return cid;
    }

    public String getPicture() {
        return picture;
    }

    public String getSummary() {
        return summary;
    }


}



