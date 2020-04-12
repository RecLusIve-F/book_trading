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
     * @param uid
     * @param bid
     * @return
     */
    @Override
    public boolean addCart(int uid, int bid) {
        Book book = bookDao.findBook(bid).get(0);
        Cart cart = new Cart();
        cart.setBid(book.getBid());
        cart.setBname(book.getBname());
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

    /**
     * 更新购物项
     * @param uid
     * @param bid
     * @param quantity
     * @return
     */

    @Override
    public boolean updateCart(int uid, int bid, int quantity) {
        List<Book> books = bookDao.findBook(bid);
        Book book = books.get(0);
        double price = book.getPrice();
        double total =price*quantity;//单项总价格
        cartDao.update(quantity,total,bid,uid);
        return true;
    }

    @Override
    public List<Cart> selCart(int uid) {
        List<Cart> carts =  cartDao.findAll(uid);
        return carts;
    }

}
