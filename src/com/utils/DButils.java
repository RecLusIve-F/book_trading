package com.utils;

import java.sql.*;

/**
 *
 * 封装数据库工具类，简化代码
 * @author dwaneZhou
 * @create --\
 */
public class DButils {

    static Connection conn = null;
    static PreparedStatement pstm = null;
    static ResultSet rs = null;

    /**
     * 数据库连接
     */
    public static void getConnection() {
        try {
            //链接信息以及数据库账号密码
            String url = "jdbc:mysql://localhost:3306/book_trading?serverTimezone=GMT";//指定东八区
            String username = "root";
            String password = "jx265810";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(String sql) {
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 关闭连接,释放资源
     */

    public static void close() {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstm!=null){
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
