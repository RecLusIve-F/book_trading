package com.service.impl;

import com.dao.BookDao;
import com.dao.CartDao;
import com.dao.OrderitemDao;
import com.entity.Book;
import com.entity.Cart;
import com.entity.Orderitem;
import com.service.BookService;
import com.service.OrderItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单项
 * @author dwaneZhou
 * @create --\
 */
public class OrderItemServiceImpl implements OrderItemService {
    OrderitemDao orderitemDao = new OrderitemDao();
    BookDao bookDao = new BookDao();
    CartDao cartDao = new CartDao();
    /**
     * 插入订单项
     * @param bid 指定item的bid数组
     * @param oid
     * @param uid
     * @return
     */
    @Override
    public boolean addItem(int[] bid,int oid,int uid) {

        List<Book> books;
        Book book;
        //根据指定uid，bid，返回cart
        List<Cart> carts;
        Cart cart;
        //插入订单item
        for (int i = 0;i<bid.length;i++){
            //根据指定id返回Book
            books = bookDao.findBook(bid[i]);
            book = books.get(0);
            carts= cartDao.findOne(uid,bid[i]);
            cart = carts.get(0);
            Orderitem orderitem = new Orderitem();
            orderitem.setSubtotal(cart.getTotal());
            orderitem.setQuantity(cart.getQuantity());
            orderitem.setBid(bid[i]);
            orderitem.setBname(book.getBname());
            orderitem.setPrice(book.getPrice());
            orderitem.setOid(oid);
            orderitemDao.insert(orderitem);
        }
        return true;
    }

    @Override
    public List<Orderitem> selOrderItem(int oid) {
        List<Orderitem> orderitems =orderitemDao.findAll(oid);
        return orderitems;
    }


}
