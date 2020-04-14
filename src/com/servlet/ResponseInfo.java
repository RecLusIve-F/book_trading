package com.servlet;

import com.entity.Book;
import com.entity.Category;
import com.entity.Orders;
import com.servlet.Info.BookInfo;
import com.servlet.Info.CartInfo;
import com.servlet.Info.UserInfo;

import java.util.List;

/**
 * @author RecLusIve_F
 * @create --\
 */
public class ResponseInfo {
    private int status;
    private String responseMsg;
    private List<Book> books;
    private List<BookInfo> bookInfos;
    private UserInfo userInfos;
    private List<CartInfo> cartInfos;
    private List<Orders> orders;
    private List<Category> categoryInfos;


    //Login_succeed
    public ResponseInfo(int status, String responseMsg,UserInfo userInfos,List<CartInfo> cartInfos,List<Orders> orders) {
        this.status = status;
        this.responseMsg = responseMsg;
        this.userInfos = userInfos;
        this.cartInfos = cartInfos;
        this.orders = orders;
    }

    //Login_failure
    public ResponseInfo(int status, String responseMsg) {
        this.status = status;
        this.responseMsg = responseMsg;
    }

    //获取分类图书信息
    public ResponseInfo(int status, List<BookInfo> bookInfos) {
       this.bookInfos = bookInfos;
    }

    //获取全部图书及分类信息
    public ResponseInfo(int status, List<BookInfo> bookInfos, List<Category> categoryInfos) {
        this.status = status;
        this.bookInfos = bookInfos;
        this.categoryInfos = categoryInfos;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public List<BookInfo> getBookInfos() {
        return bookInfos;
    }

    public void setBookInfos(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }
}
