package com.service.impl;

import com.dao.OrdersDao;
import com.entity.Orders;
import com.entity.User;
import com.service.OrderItemService;
import com.service.OrderService;

import java.util.List;

/**
 * 订单
 * @author dwaneZhou
 * @create --\
 */
public class OrderServiceImpl implements OrderService {
    OrderItemService orderItemService = new OrderItemServiceImpl();
    OrdersDao ordersDao = new OrdersDao();

    /**
     * 插入订单
     * @param uid
     * @param address 收件地址，默认用户信息填的地址
     * @param total 订单总价
     * @param bid 订单全部item id构成的数组
     * @return
     */
    @Override
    public boolean addOrder(int uid, String address,double total,int[] bid ) {
        User user = new User();
        if (address == null){
            address=user.getAddress();
        }
        //插入订单
        ordersDao.insert(total,address,uid);
        //返回oid
        //插入订单项
        //orderItemService.addItem(bid,oid,uid);
        return true;
    }

    @Override
    public boolean delOrder(int uid, int oid) {
        ordersDao.deleteOrder(uid,oid);
        return true;
    }

    /**
     * 更新订单支付状态
     * @param uid
     * @param oid
     * @return
     */
    @Override
    public boolean updateOrderStatus(int uid,int oid) {
        //根据uid,oid，返回order
        Orders order = ordersDao.findOrder(uid,oid).get(0);
        //判断是否成功支付
        ordersDao.update(1,oid);
        return true;
    }

    /**
     * 返回某个用户全部订单信息
     * @param uid
     * @return
     */
    @Override
    public List<Orders> selOrderInfo(int uid) {
        List<Orders> orders = ordersDao.findAll(uid);
        return orders;
    }
}
