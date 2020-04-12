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
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.getName().equals(bookName)) {
                return currentBook;
            }
        }
        return null;
    }

    /**
     * 系统时间与书本记录插入时间做对比，小于4天则是新书
     *
     * @param book
     * @return
     */
    @Override
    public boolean isNew(Book book) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//格式化
        try {
            //格式化日期
            String date = df.format(new Date());//当前系统时间
            String date2 = df.format(book.getCreateTime());
            //转型为日期型
            Date currentDate = df.parse(date);
            Date oldDate = df.parse(date2);
            //运算时间差(天)
            long day = (currentDate.getTime() - oldDate.getTime()) / (24 * 60 * 60 * 1000);
            if (day < 4) {
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
     *
     * @param book
     * @return
     */
    @Override
    public boolean isSpecial(Book book) {
        if (book.getSpecial().equals("1")) {
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

        List<Book> books = bookService.selAllBooks();
        System.out.println(books.get(0).getBname());

/*
        Book book = new Book();
        book.setAuthor("Higashino Keigo");
        book.setName("白夜行");
        book.setPrice(40);
        book.setPagenum(400);
        book.setSummary("《白夜行》是日本作家东野圭吾创作的长篇小说，也是其代表作。该小说于1997年1月至1999年1月间连载于期刊，单行本1999年8月在日本发行。故事围绕着一对有着不同寻常情愫的小学生展开。1973年，大阪的一栋废弃建筑内发现了一具男尸，此后19年，嫌疑人之女雪穗与被害者之子桐原亮司走上截然不同的人生道路，一个跻身上流社会，一个却在底层游走，而他们身边的人，却接二连三地离奇死去，警察经过19年的艰苦追踪，终于使真相大白。");
        book.setPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586538937014&di=a4d9e7dbef9225cc70088e6dcdfb4b5e&imgtype=0&src=http%3A%2F%2Fimage12.bookschina.com%2F2013%2F20130310%2F5752679.jpg");
        book.setSpecial("1");

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
}
 */
    }
}