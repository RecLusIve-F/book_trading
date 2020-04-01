package com.dao;

/**
 * 持久层，负责数据库的访问控制，并进行CRUD
 * @author dwaneZhou
 * @create --\
 */
public interface UserDao {

    User selectUserByName(String username);//根据用户名查找指定用户
    void addUser(User user);
    void deleteUser(User user);

}
