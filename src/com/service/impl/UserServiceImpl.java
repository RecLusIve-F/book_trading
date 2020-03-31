package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;


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
