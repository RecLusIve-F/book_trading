package com.service.impl;

import com.dao.BookDao;
import com.service.BookService;
import com.entity.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 系统时间与书本记录插入时间做对比，小于4天则是新书
     * @param book
     * @return
     */
    @Override
    public boolean isNew(Book book) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//格式化
        try {
            //格式化日期
            String date= df.format(new Date());//当前系统时间
            String date2 = df.format(book.getCreateTime());
            //转型为日期型
            Date currentDate = df.parse(date);
            Date oldDate = df.parse(date2);
            //运算时间差(天)
            long day = (currentDate.getTime()-oldDate.getTime())/(24*60*60*1000);
            if (day<4){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPopular(Book book) {
        return false;
    }

    /**
     * 是否特价
     * 1为特价
     * @param book
     * @return
     */
    @Override
    public boolean isSpecial(Book book) {
        if (book.getSpecial().equals("1")){
            return true;
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        bookDao.insert(book);
        return true;
    }


    public static void main(String[] args) {

        BookService bookService = new BookServiceImpl();

        List<Book> books= bookService.selAllBooks();
        System.out.println(books.get(5).getSpecial());


/*
        Book book = new Book();
        book.setAuthor("t");
        book.setName("test");
        book.setPrice(12);
        book.setPagenum(1);
        System.out.println(bookService.addBook(book));
 */
/*
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            Date date2 = df.parse("2020-04-9");
            Date date1 = df.parse("2020-04-11");
            long day = (date1.getTime()-date2.getTime())/(24*60*60*1000);
            System.out.println(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }


 */

       // System.out.println(df.format(date));

        //List<Book> books = bookService.selAllBooks();
        //System.out.println(books.get(4).getCreateTime());

    }


}
