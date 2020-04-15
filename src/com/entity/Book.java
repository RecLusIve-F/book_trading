package com.entity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pagenum=" + pagenum +
                ", cid=" + cid +
                ", picture='" + picture + '\'' +
                ", summary='" + summary + '\'' +
                ", createTime=" + createTime +
                ", uid=" + uid +
                '}';
    }

    public static void main(String[] args) {
        /*
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setBid(1);
        book1.setBname("ss");
        book1.setSummary("sum");
        book2.setBid(2);
        book2.setBname("tt");
        book2.setSummary("ssssss");
        Gson gson = new Gson();
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

         */

    }
}



