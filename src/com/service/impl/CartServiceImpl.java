package com.service.impl;

import com.dao.BookDao;
import com.dao.CartDao;
import com.entity.Book;
import com.entity.Cart;
import com.service.CartService;

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
     *
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
        cartDao.delete(bid, uid);
        return true;
    }

    /**
     * 更新购物项
     * @param uid
     * @param bid
     * @param quantity 数量，为0即删除
     * @return
     */
    @Override
    public boolean updateCart(int uid, int bid, int quantity) {
        if (quantity >= 0) {
            //数量为0即删除当前购物项
            if (quantity == 0) {
                this.delCart(uid,bid);
                return true;
            }
            List<Book> books = bookDao.findBook(bid);
            Book book = books.get(0);
            double price = book.getPrice();
            double total = price * quantity;//单项总价格
            cartDao.update(quantity, total, bid, uid);
            return true;
        }
        return false;
    }

    @Override
    public List<Cart> selCart(int uid) {
        List<Cart> carts = cartDao.findAll(uid);
        return carts;
    }

    public static void main(String[] args) {
        CartService cartService = new CartServiceImpl();
        //插入
        //cartService.addCart(4,11);
        //cartService.updateCart(4,11,2);
        /*
        List<Cart> carts = cartService.selCart(4);
        for (int i=0;i<carts.size();i++){
            System.out.println(carts.get(i).getBname());
        }

         */
        //cartService.delCart(4,11);

    }

}
