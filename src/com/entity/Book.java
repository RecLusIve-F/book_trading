package com.entity;

/**
 * @author dwaneZhou
 * @create 26-3-2020\
 */
public class Book {

    private int id;//编号
    private double price;
    private String name;
    private String author;
    private String image;//图片
    private String description;//描述
    private String category;//类别





    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

}
