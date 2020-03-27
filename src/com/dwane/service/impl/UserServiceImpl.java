package com.dwane.service.impl;

import com.dwane.dao.UserDao;
import com.dwane.dao.impl.UserDaoImpl;
import com.dwane.entity.User;
import com.dwane.service.UserService;


/**
 *
 * @author dwaneZhou
 * @create --\
 *
 */
public class UserServiceImpl implements UserService {

    private User user;
    UserDao userDao = new UserDaoImpl();//多态

    @Override
    public boolean login (String name,String password) {
        user = userDao.selectUserByName(name);
        if (user.getUsername().equals(name)&&user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

}
