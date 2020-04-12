package com.service.impl;

import com.dao.BookDao;
import com.dao.CartDao;
import com.entity.Book;
import com.entity.Cart;
import com.service.CartService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dwaneZhou
 * @create --\
 */
public class CartServiceImpl implements CartService {
    BookDao bookDao = new BookDao();
    CartDao cartDao = new CartDao();

    /**
     * 插入购物项
     * @param uid 用户id
     * @param bookName 书名
     * @return
     */
    @Override
    public boolean addCart(int uid, String bookName) {
        Book book = bookDao.findOne(bookName,1).get(0);
        Cart cart = new Cart();
        cart.setBid(book.getBid());
        cart.setBname(bookName);
        cart.setQuantity(1);
        cart.setPrice(book.getPrice());
        cart.setTotal(book.getPrice());
        cart.setPicture(book.getPicture());
        cart.setUid(uid);
        //插入
        cartDao.insert(cart);
        return true;
    }

    @Override
    public boolean delCart(int uid, int bid) {
        cartDao.delete(uid,bid);
        return true;
    }

    @Override
    public boolean updateCart(int uid, String bookName, int quantity) {
        Book book = bookDao.findOne(bookName,1).get(0);
        int bid = book.getBid();
        double price = book.getPrice();
        double total =price*quantity;
        cartDao.update(quantity,total,bid,uid);
        return true;
    }

    @Override
    public List<Cart> selCart(int uid) {
        List<Cart> carts =  cartDao.findAll(uid);
        return carts;
    }

}
