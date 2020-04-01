package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;


/**
 * @author dwaneZhou
 * @create --\
 */
public class UserServiceImpl implements UserService {

    private User user;
    UserDao userDao = new UserDaoImpl();//多态

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
        if (username.equals(userDao.selectUserByName(username).getUsername())) {
            return "用户已存在";
        }
        return null;
    }

    /**
     * 密码合法性检测
     * 长度：6~16
     * 只能包含字母、数字、下划线、！
     * 至少包含两种类型符号
     * @param password   密码
     * @param rePassword 再次输入密码
     * @return
     */
    @Override
    public String checkForPassword(String password, String rePassword) {
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
        if (!password.equals(rePassword)) {
            return "密码不一致";
        }
        return null;
    }

    /**
     * 添加用户
     * @param username
     * @param password
     */
    @Override
    public void addUser(String username, String password) {
        try{
            user.setUsername(username);
            user.setPassword(password);
            userDao.addUser(user);
        }catch (RuntimeException e){
            throw new RuntimeException("异常，添加用户失败"+e);
        }

    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        user = userDao.selectUserByName(username);
        if (user.getUsername().equals(username) && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }



    /*

    测试

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        String username = "1234a_";
        String password="123asdZ";
        String rePassword="123asdZ";
        String pwdTest = userService.checkForPassword(password,rePassword);
        String nameTest = userService.checkForUsername(username);
        System.out.println(nameTest);
        System.out.println(pwdTest);
    }

     */

}
