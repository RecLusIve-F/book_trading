package com.service;

import com.entity.Book;

import java.util.List;

/**
 * @author dwaneZhou
 * @create 26-3-2020\
 */
public interface BookService {

    boolean addBook(Book book);//添加书本
    boolean delBook(int bid,int uid);//用户删除书本
    List<Book> selAllBooks();//查找所有图书
    List<Book> selBookByUser(int uid);//查找用户发布的图书信息
    List<Book> selBookByName(String bookName);//按书名检索,模糊匹配
    List<Book> selBookByCategory(String Category);//按目录检索

    boolean isNew(int bid);//是否新书
    boolean isPromo(int bid);//是否特价
    boolean isSpecial(int bid);//是否畅销


}
