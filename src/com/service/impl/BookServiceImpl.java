package com.service.impl;

import com.dao.BookDao;
import com.dao.OrderitemDao;
import com.dao.UserDao;
import com.entity.Orderitem;
import com.entity.User;
import com.service.BookService;
import com.entity.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dwaneZhou
 * @create --\
 */
public class BookServiceImpl implements BookService {
    int i = 0;
    int j = 0;
    int k = 0;
    BookDao bookDao = new BookDao();
    List<Book> books = new ArrayList<>();
    UserDao userDao = new UserDao();

    /**
     * 插入图书
     * 返回数组[0]，插入状态,[1]插入记录的bid
     * @param book
     * @return
     */
    @Override
    public int[] addBook(Book book) {
        int[] message = new int[2];//返回数组
        int[] result =bookDao.insert(book);
        int status = result[0];//插入状态
        int bid;//当前插入记录的bid
        if (status!=0){
            bid = result[1];
            message[0] = status;
            message[1] = bid;
            return message;
        }
        message[0]=0;
        return message;

    }

    @Override
    public Book selBookById(int bid) {
        Book book = bookDao.findBook(bid).get(0);
        return book;
    }

    @Override
    public boolean delBook(int bid, int uid) {
        if (bookDao.delete(bid,uid)!=0){
            return true;
        }
        return false;
    }
    //查询所有图书
    @Override
    public List<Book> selAllBooks() {
        books = bookDao.findAll();
        return books;
    }

    //查询某个用户的所有图书

    @Override
    public List<Book> selBookByUser(String username) {
        User user = userDao.findUser(username).get(0);
        books = bookDao.findBookbyUser(user.getUid());
        return books;
    }

    //按类别检索
    @Override
    public List<Book> selBookByCategory(int cid) {
        books = bookDao.findBookById(cid);
        return books;
    }

    /**
     * 按书名检索,模糊匹配，返回书本集合
     * @param bookName
     * @return
     */
    @Override
    public List<Book> selBookByName(String bookName) {
        books = bookDao.findAll();
        List<Book> books = bookDao.findOne(bookName);
        return books;
    }



    /**
     * 系统时间与书本记录插入时间做对比，小于3天则是新书
     * @return
     */
    @Override
    public boolean isNew(int bid) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//格式化
        try {
            Book book = bookDao.findBook(bid).get(0);
            //格式化日期
            String date = df.format(new Date());//当前系统时间
            String date2 = df.format(book.getCreateTime());
            //转型为日期型
            Date currentDate = df.parse(date);
            Date oldDate = df.parse(date2);
            //运算时间差(天)
            long day = (currentDate.getTime() - oldDate.getTime()) / (24 * 60 * 60 * 1000);
            if (day < 3) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;

        /*
        boolean flag;
        Random random = new Random();
        //随机5本书
        while (i<5){
            flag = random.nextBoolean();
            i++;
            return flag;
        }

         */

    }

    /**
     * 是否特价
     * @param bid
     * @return
     */
    @Override
    public boolean isPromo(int bid) {
        /*
        //return false;
        boolean flag;
        Random random = new Random();
        //随机5本书
        while (k<5){
            flag = random.nextBoolean();
            k++;
            return flag;
        }

         */
        if (bid==120||bid==121||bid==122){
            return true;
        }
        return false;
    }

    /**
     * 是否畅销
     * 销量大于等于2
     * @return
     */
    @Override
    public boolean isSpecial(int bid) {

        OrderitemDao orderitemDao = new OrderitemDao();
        List<Orderitem> orderitems = orderitemDao.findAll(bid);
        if (orderitems.size()>=2) {
            return true;
        }
        return false;
    }


    //public static void main(String[] args) {
       // BookService bookService = new BookServiceImpl();
        /*
        插入
        Book book = new Book();
        book.setBname("白夜行");
        book.setAuthor("Higashino Keigo");
        book.setPrice(30);
        book.setPagenum(200);
        book.setCid(2);
        book.setPicture("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1510910805,307808459&fm=26&gp=0.jpg");
        book.setUid(4);
        bookService.addBook(book);

         */
        //删除
        //System.out.println(bookService.delBook(10,5));
        //查找所有书
        //List<Book> books = bookService.selAllBooks();
        //模糊匹配检索
        //books = bookService.selBookByName("白");
        //分类检索

        //books = bookService.selBookByCategory("科幻");
/*
        for (int i=0;i<books.size();i++){
            System.out.println(books.get(i).getBid());
        }


 */

        //bookService.deleteBook()
    }