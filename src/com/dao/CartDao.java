package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;

public class CartDao extends BaseDao {

    public List<Cart> search(String sql, Object... params) {
        List<Cart> list = new ArrayList<Cart>();
        Connection conn = this.getconn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = this.prepareStatement(conn, sql, params);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cart wor = new Cart();
                wor.setCartid(rs.getInt(1));
                wor.setBname(rs.getString(2));
                wor.setQuantity(rs.getInt(3));
                wor.setPrice(rs.getInt(4));
                wor.setTotal(rs.getDouble(5));
                wor.setPicture(rs.getString(6));
                wor.setUid(rs.getInt(7));
                wor.setBid(rs.getInt(8));
                list.add(wor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pst, rs);
        }
        return list;
    }

    //查询某个用户购物车
    public List<Cart> findAll(int uid) {
        String sql = "select * from cart where uid=?";
        return search(sql, uid);
    }

    //查询某个用户购物车中某个订单
    public List<Cart> findOne(int uid, int bid) {
        String sql = "select * from cart where uid=? and bid=?";
        return search(sql, uid, bid);
    }

    //插入
    public int insert(Cart t) {
        String str = "insert into cart (bname,price,total,picture,uid,bid) VALUES(?,?,?,?,?,?)";
        return executeUpdate(str, new Object[]{t.getBname(), t.getPrice(), t.getTotal(), t.getPicture(), t.getUid(), t.getBid()});
    }

    //更新
    public int update(int quantity, double total, int bid, int uid) {
        String sql = "update cart set `quantity`=?,`total`=? where bid = ? and uid = ?";
        return executeUpdate(sql, new Object[]{quantity, total, bid, uid});
    }

    //删除具体购物项
    public int delete(int bid, int uid) {
        String sql = "delete from cart where bid = ? and uid = ?";
        return executeUpdate(sql, new Object[]{bid, uid});
    }


    //根据bid uid返回cartid
    public List<Cart> findCartid(int uid, int bid) {
        String sql = "select  cartid  from cart where uid=? and bid=?";
        return search(sql, uid, bid);
    }
}



