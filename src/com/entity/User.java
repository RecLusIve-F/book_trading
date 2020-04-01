package com.entity;

/**
 * 用户类
 * @author Y
 * @create --\
 */
public class User {
    private int uid;
    private String username;
    private String password;


    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
