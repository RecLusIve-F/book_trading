package com.service.impl;

import com.dao.OrdersDao;
import com.dao.UserDao;
import com.entity.Cart;
import com.entity.Orders;
import com.entity.User;
import com.service.CartService;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * 订单
 * @author dwaneZhou
 * @create --\
 */
public class OrderServiceImpl implements OrderService {
    OrderItemService orderItemService = new OrderItemServiceImpl();
    OrdersDao ordersDao = new OrdersDao();
    CartService cartService = new CartServiceImpl();
    UserDao userDao = new UserDao();

    /**
     * 插入订单
     * 暂未实现部分购物项生成订单
     * @param address 收件地址，默认用户信息填的地址
     * @param total 订单总价
     * @param bid 订单全部item id构成的数组
     * @return
     */
    @Override
    public boolean addOrder(int uid, String address,double total,int[] bid ) {
        int[] result;
        int oid;//订单id
        int status;//插入状态
        User user = userDao.findUser(uid).get(0);
        //默认为用户信息里保存的地址
        if (address == null||address.equals("")||address.equals("null")){
            address=user.getAddress();
        }
        //插入订单
        result = ordersDao.insert(total,address,uid);
        //返回oid
        status = result[0];
        if (status==0){
            return false;
        }
        oid = result[1];
        //全部购物项生成订单
        List<Cart> carts = cartService.selCart(uid);
        int[] allBid=new int[carts.size()];//全部购物项
        for (int i=0;i<carts.size();i++){
            allBid[i]=carts.get(i).getBid();
        }
        bid = allBid;


        orderItemService.addItem(bid,oid,uid);
        //清空购物车
        cartService.delCart(uid,bid);
        return true;
    }

    @Override
    public boolean delOrder(int uid, int oid) {
        ordersDao.deleteOrder(uid,oid);
        return true;
    }

    /**
     * 更新订单支付状态
     * @param oid
     * @return
     */
    @Override
    public boolean updateOrderStatus(int oid) {
        //根据uid,oid，返回order
        Orders order = ordersDao.findOrder(oid).get(0);
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

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        //插入订单
/*
        int[] bid = {7,12};
        orderService.addOrder(6,null,120,bid);


 */
        //删除订单
        //orderService.delOrder(4,20);
         //修改订单状态
        //orderService.updateOrderStatus(14);
        //查询订单

        List<Orders> orders = orderService.selOrderInfo(6);
        for (int i = 0;i<orders.size();i++){
            int oid = orders.get(i).getOid();
            Date date = orders.get(i).getOrderTime();
            double total = orders.get(i).getTotal();
            String address = orders.get(i).getAddress();
            int uid = orders.get(i).getUid();
            int status = orders.get(i).getStatus();
            System.out.println(oid);
            System.out.println(date);
            System.out.println(total);
            System.out.println(address);
            System.out.println(uid);
            System.out.println(status);

        }






        //删除订单
        //orderService.delOrder(4,14);





    }
}
