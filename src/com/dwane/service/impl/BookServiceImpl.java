package com.dwane.service.impl;

import com.dwane.service.BookService;
import com.dwane.dao.BookDao;
import com.dwane.dao.impl.BookDaoImpl;
import com.dwane.entity.Book;

import java.util.ArrayList;

/**
 * @author dwaneZhou
 * @create --\
 */
public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();


    @Override
    public ArrayList<Book> selAllBooks() {
        return null;
    }

    @Override
    public Book selectBook(String book_name) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public int deleteBook(String book_name) {
        return 0;
    }
}
