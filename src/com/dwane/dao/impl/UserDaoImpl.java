package com.dwane.dao.impl;

import com.dwane.dao.UserDao;
import com.dwane.entity.User;
import com.dwane.utils.DButils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dwaneZhou
 * @create --\
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User selectUserByName(String username) {
        DButils.getConnection();
        ResultSet rs;
        User user = new User();
        try {
            String sql = "select * from user ";
            rs = DButils.executeQuery(sql);
            while (rs.next()) {
                if (username.equals(rs.getString(1))){
                    String name = rs.getString(1);
                    String password = rs.getString(2);
                    user.setUsername(name);
                    user.setPassword(password);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询出错" + e);
        } finally {
            DButils.close();
        }
        return user;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
