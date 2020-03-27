package com.dwane.dao;

import com.dwane.entity.Book;

import java.util.List;


/**
 * @author dwaneZhou
 * @create --\
 */
public interface BookDao {

    List<Book> SelectAllBook();
    Book getBookByName(String bookName);
    void addBook(Book book);//添加图书
    void deleteBook(int book_id);//删除图书
    int countBooks();

}
