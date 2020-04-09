package com.service;

import com.entity.Book;

import java.util.List;

/**
 * @author dwaneZhou
 * @create 26-3-2020\
 */
public interface BookService {
    List<Book> selAllBooks();
    Book selectBook(String bookName);
    boolean addBook(Book book);
    //boolean deleteBook(String bookName);

}
