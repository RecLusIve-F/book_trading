package com.service;

/**
 * 业务逻辑层，通过持久层提供的接口获取数据，对数据进行逻辑处理
 * @author dwaneZhou
 * @create --\
 */
public interface UserService {
    boolean login(String username,String password);
}
