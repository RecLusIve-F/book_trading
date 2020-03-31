package com.dao.impl;

import com.dao.BookDao;
import com.entity.Book;
import com.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dwaneZhou
 * @create --\
 */
public class BookDaoImpl implements BookDao {

    private Connection conn = null;
    private PreparedStatement ps=null;
    private ResultSet rs = null;

    @Override
    public List<Book> SelectAllBook() {

        ArrayList books = new ArrayList();
        String sql = "select * from book";
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                books.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DButils.close();
        }
        return books;
    }

    @Override
    public Book getBookByName(String bookName) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        int id = book.getId();
        String name = book.getName();
        String author = book.getAuthor();

        String sql = "insert into book values(1,'2','3')";
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DButils.close();
        }
    }

    @Override
    public void deleteBook(int book_id) {

    }

    @Override
    public int countBooks() {
        return 0;
    }





}
