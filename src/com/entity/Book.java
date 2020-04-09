package com.entity;

/**
 * 书本类
 * @author Y
 */
public class Book {

    private int bid;
    private String bname;
    private String author;
    private int price;
    private int pagenum;
    private int cid;
    private String picture;
    private String summary;

    public void setId(int bid) {
        this.bid = bid;
    }

    public void setName(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setPicture(String Picture) {
        this.picture = Picture;
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

    public int getPrice() {
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

