package com.service;

import com.entity.Cart;

import java.util.List;

/**
 * 购物车
 * @author dwaneZhou
 * @create --\
 */
public interface CartService {

    boolean addCart(int uid,int bid);//添加购物项
    boolean delCart(int uid,int bid);//删除购物项
    boolean updateCart(int uid,int bid,int quantity);//修改购物项
    List<Cart> selCart(int uid);//查看购物车信息

}
