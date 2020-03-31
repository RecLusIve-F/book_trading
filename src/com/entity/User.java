package com.entity;

/**
 * @author dwaneZhou
 * @create --\
 */
public class User {
    private String username;//用户名
    private String password;//密码
    private String sex;
    private String address;

    public User(){

    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString(){
        return "用户名："+username+",密码："+password;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
