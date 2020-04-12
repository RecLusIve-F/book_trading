package com.service;

import com.entity.Book;

import java.util.List;

/**
 * @author dwaneZhou
 * @create 26-3-2020\
 */
public interface BookService {

    boolean addBook(Book book);
    //boolean deleteBook(String bookName);
    List<Book> selAllBooks();//查找所有图书
    Book selBookByName(String bookName);//按书名检索
    List<Book> selBookByCategory(String Category);//按目录检索

    boolean isNew(Book book);//是否新书
    boolean isPopular(Book book );//是否畅销
    boolean isSpecial(Book book);//是否特价



}
