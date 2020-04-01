package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

import java.sql.SQLException;
import java.util.List;


/**
 * @author dwaneZhou
 * @create --\
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    /**
     * 用户名合法性检测
     * 长度为4~8
     * 只能包含数字、字母、下划线
     * @param username
     * @return
     */
    @Override
    public String checkForUsername(String username) {
        final int USERNAME_MIN_SIZE = 4;//用户名最小长度
        final int USERNAME_MAX_SIZE = 8;//用户名最大长度
        final String USERNAME = ".*[^0-9a-zA-Z_].*";//正则表达式，用户名只能包含字母数字及下划线
        if (username.length() < USERNAME_MIN_SIZE) {
            return "用户名长度不小于4";
        }
        if (username.length() > USERNAME_MAX_SIZE) {
            return "用户名长度不大于8";
        }
        if (username.matches(USERNAME)) {
            return "用户名包含非法字符";
        }
        //判断用户是否已存在
        List<User> users = userDao.findAll();
        for (User  user:users){
            if (username.equals(user.getUsername())) {
                return "用户已存在";
            }
        }
        /*
        if (username.equals(userDao.selectUserByName(username).getUsername())) {
            return "用户已存在";
        }

         */

        return null;
    }

    /**
     * 密码合法性检测
     * 长度：6~16
     * 只能包含字母、数字、下划线、！
     * 至少包含两种类型符号
     * @param password
     * @return
     */
    @Override
    public String checkForPassword(String password) {
        final int PASSWORD_MIN_SIZE = 6;//密码最小长度
        final int PASSWORD_MAX_SIZE = 16;//密码最大长度
        final String PASSWORD = ".*[^0-9a-zA-Z_].*";
        final String NUMBER_LETTER ="(.*([0-9][a-zA-z]).*)|(.*([a-zA-Z][0-9]).*)";//数字小写字母
        if (password.length() < PASSWORD_MIN_SIZE) {
            return "密码长度不小于6";
        }
        if (password.length() > PASSWORD_MAX_SIZE) {
            return "密码长度不大于16";
        }
        if (password.matches(PASSWORD)){
            return "密码包含特殊字符";
        }
        if (!password.matches(NUMBER_LETTER)){
            return "密码过于简单";
        }
        return null;
    }

    /**
     * 添加用户
     * @param username
     * @param password
     */
    @Override
    public boolean addUser(String username, String password) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userDao.insert(user);
            return true;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        //user = userDao.selectUserByName(username);
        List<User> users = userDao.findAll();
        //获取指定姓名的用户
        for (User  user:users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

/*
    //测试

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        String username = "John";
        String password = "12345jx";
        String rePassword = "12345jx";
        String usernameTest = userService.checkForUsername(username);
        String passwordTest = userService.checkForPassword(password);
        System.out.println(usernameTest);
        System.out.println(passwordTest);
        userService.addUser(username,password);
    }

 */

}
