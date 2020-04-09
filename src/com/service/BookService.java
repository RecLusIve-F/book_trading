package com.service;

import com.entity.Book;

import java.util.List;

/**
 * @author dwaneZhou
 * @create 26-3-2020\
 */
public interface BookService {
    List<Book> selAllBooks();//查找所有图书
    List<Book> selBookByCategory(String category);//按类别检索
    Book selBookByName(String bookName);//按书名检索

    boolean isNew(Book book);//是否新书
    boolean isPopular(Book book );//是否畅销
    boolean isSpecial(Book book);//是否特价

    boolean addBook(Book book);

    //boolean deleteBook(String bookName);

}
