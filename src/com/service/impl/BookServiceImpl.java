package com.service.impl;

import com.dao.BookDao;
import com.service.BookService;
import com.entity.Book;

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

    @Override
    public boolean addBook(Book book) {
        bookDao.insert(book);
        return true;
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
    public List<Book> selBookByUsername(String username) {
        books = bookDao.findBookbyUser(username);
        return books;
    }
    //按类别检索
    @Override
    public List<Book> selBookByCategory(String category) {
        books = bookDao.findBook(category);
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
     * 系统时间与书本记录插入时间做对比，小于4天则是新书
     *
     * @param book
     * @return
     */
    @Override
    public boolean isNew(int bid) {
        /*
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

         */
        boolean flag;
        Random random = new Random();
        //随机10本书
        while (i<10){
            flag = random.nextBoolean();
            i++;
            return flag;
        }
        return false;
    }

    /**
     * 是否特价
     * @param bid
     * @return
     */
    @Override
    public boolean isPromo(int bid) {
        //return false;
        boolean flag;
        Random random = new Random();
        //随机10本书
        while (k<10){
            flag = random.nextBoolean();
            k++;
            return flag;
        }
        return false;
    }

    /**
     * 是否畅销
     * 3个用户及以上购买为畅销
     * @param book
     * @return
     */
    @Override
    public boolean isSpecial(int bid) {
        /*
        OrderitemDao orderitemDao = new OrderitemDao();
        List<Orderitem> orderitems = orderitemDao.findAll(book.getBid());
        if (orderitems.size()>=3) {
            return true;
        }
        return false;
         */
        boolean flag;
        Random random = new Random();
        //随机10本书
        while (j<10){
            flag = random.nextBoolean();
            j++;
            return flag;
        }
        return false;
    }

    public static void main(String[] args) {
        //BookService bookService = new BookServiceImpl();
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
        /*
        books = bookService.selBookByCategory("社科");

        for (int i=0;i<books.size();i++){
            System.out.println(books.get(i).getBname());
        }

         */







        //bookService.deleteBook()
    }
}