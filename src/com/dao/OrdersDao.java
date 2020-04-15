package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Orders;

public class OrdersDao extends BaseDao {

    public List<Orders> search(String sql, Object... params) {
        List<Orders> list = new ArrayList<>();
        Connection conn = this.getconn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = this.prepareStatement(conn, sql, params);
            rs = pst.executeQuery();
            while (rs.next()) {
                Orders wor = new Orders();
                wor.setOid(rs.getInt(1));
                wor.setOrderTime(rs.getDate(2));
                wor.setTotal(rs.getDouble(3));
                wor.setStatus(rs.getInt(4));
                wor.setAddress(rs.getString(5));
                wor.setUid(rs.getInt(6));

                list.add(wor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pst, rs);
        }
        return list;
    }

    //查询某个用户的订单
    public List<Orders> findAll(int uid) {
        String sql = "select * from orders where uid = ?";
        return search(sql, uid);
    }

    //插入
    public int[] insert(double total, String address, int uid) {
        String strInsert = "insert into orders (total,address,uid) VALUES(?,?,?)";
        String strQuery = "select last_insert_id()";
        int[] result;
        result = executeUpdate(strInsert, new Object[]{total, address, uid}, strQuery);
        return result;
    }


    //更新订单
    public int update(int status, int oid) {
        String sql = "update  orders  set `status`=? WHERE oid=?";
        return executeUpdate(sql, new Object[]{status, oid});
    }

    //删除订单
    public int delete(int uid) {
        String sql = "delete from orders WHERE uid = ?";
        return executeUpdate(sql, new Object[]{uid});
    }

    //删除某条订单
    public int deleteOrder(int uid, int oid) {
        String sql = "delete from orders WHERE uid = ? and oid = ?";
        return executeUpdate(sql, new Object[]{uid, oid});
    }

    //根据输入订单id输出订单内容
    public List<Orders> findOrder(int oid) {
        String sql = " select * from orders where oid = ? ";
        return search(sql, oid);
    }
}