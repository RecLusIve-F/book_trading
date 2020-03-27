package com.dwane.entity;

/**
 * @author dwaneZhou
 * @create 26-3-2020\
 */
public class Book {

    private int id;
    private String name;
    private String author;

    public Book(){

    }

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
