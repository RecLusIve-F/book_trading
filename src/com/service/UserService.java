package com.service;

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
    String checkForPassword (String password,String rePassword);
    boolean addUser(String username,String password);//添加成功与否

}
