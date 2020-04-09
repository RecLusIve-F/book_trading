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
    public List<Book> selBookByCategory(String category) {
        //return bookDao.groupByCategory();
        return null;
    }

    @Override
    public Book selBookByName(String bookName) {
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
    public boolean isNew(Book book) {
        return false;
    }

    @Override
    public boolean isPopular(Book book) {
        return false;
    }

    @Override
    public boolean isSpecial(Book book) {
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        bookDao.insert(book);
        return true;
    }


    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        BookService bookService = new BookServiceImpl();
        books = bookService.selAllBooks();
        System.out.println(books.get(0).getPictureB());
        /*
        Book book = new Book();
        book.setId(3);
        book.setName("test");
        System.out.println(bookService.addBook(book));
         */

    }


}
