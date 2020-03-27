package com.dwane.service;

import com.dwane.entity.Book;

import java.util.ArrayList;

/**
 * @author dwaneZhou
 * @create 26-3-2020\
 */
public interface BookService {
    ArrayList<Book> selAllBooks();
    Book selectBook(String book_name);
    void addBook(Book book);
    int deleteBook(String book_name);

}
