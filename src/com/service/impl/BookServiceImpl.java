package com.service.impl;

import com.dao.BookDao;
import com.service.BookService;
import com.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dwaneZhou
 * @create --\
 */
public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDao();
    List<Book> books = new ArrayList<>();
    @Override
    public List<Book> selAllBooks() {
        books = bookDao.findAll();
        return books;
    }

    @Override
    public Book selectBook(String bookName) {
        books = bookDao.findAll();
        for (int i=0;i<books.size();i++){
            Book currentBook = books.get(i);
            if (currentBook.getName().equals(bookName)){
                return currentBook;
            }
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        bookDao.insert(book);
        return true;
    }

}
