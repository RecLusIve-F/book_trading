package com.service;

import com.entity.Orderitem;

import java.util.List;

/**
 * 购物车
 * @author dwaneZhou
 * @create --\
 */
public interface OrderItemService {


    boolean addItem(int[] bid,int oid,int uid);//添加订单项
    List<Orderitem> selOrderItem(int oid);//返回订单详情


}
