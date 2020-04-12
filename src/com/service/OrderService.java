package com.service;

import com.entity.Orders;

import java.util.List;

/**
 * 订单
 * @author dwaneZhou
 * @create --\
 */
public interface OrderService {
    //插入订单，address若为null，则默认用户信息填的地址
    //total为订单总价，bid 为订单书本id集合
    boolean addOrder(int uid,String address,double total,int[] bid);
    boolean delOrder(int uid,int oid);//删除订单
    boolean updateOrderStatus(int uid,int oid);//更新订单支付状态，默认为待支付
    List<Orders> selOrderInfo(int uid);//根据用户id返回订单信息


}
