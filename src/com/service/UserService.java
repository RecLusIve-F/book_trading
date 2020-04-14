package com.service;

import com.entity.User;

/**
 * 业务逻辑层，通过持久层提供的接口获取数据，对数据进行逻辑处理
 * @author dwaneZhou
 * @create --\
 */
public interface UserService {
    //登录
    boolean login(String username,String password);
    //注册校验，返回相应提示信息
    String checkForUsername (String username);
    String checkForPassword (String password);
    boolean addUser(String username,String password);//添加成功与否
    User selUserByName(String username);
    boolean delUser(int uid);//删除用户
    String updateUserInfo(String username,String address,String telephone,int uid);//更新用户信息

}
