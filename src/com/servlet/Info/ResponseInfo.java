package com.servlet.Info;

import com.entity.Book;
import com.entity.Category;
import com.entity.Orderitem;
import com.entity.Orders;

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
    private UserInfo userInfo;
    private List<CartInfo> cartInfos;
    private List<Orders> orders;
    private List<Category> categoryInfos;
    private List<Orderitem> orderitems;


    //Login_succeed
    public ResponseInfo(int status, String responseMsg, UserInfo userInfo, List<CartInfo> cartInfos, List<Orders> orders,List<BookInfo> bookInfos) {
        this.status = status;
        this.responseMsg = responseMsg;
        this.userInfo = userInfo;
        this.cartInfos = cartInfos;
        this.orders = orders;
        this.bookInfos = bookInfos;
    }

    //Login_failure
    public ResponseInfo(int status, String responseMsg) {
        this.status = status;
        this.responseMsg = responseMsg;
    }
    //用户订单
    public ResponseInfo(int status, String responseMsg,List<Orders> orders) {
        this.status = status;
        this.responseMsg = responseMsg;
        this.orders = orders;
    }
    //获取分类图书信息
    public ResponseInfo(int status, List<BookInfo> bookInfos) {
        this.status = status;
        this.bookInfos = bookInfos;
    }

    //获取全部图书及分类信息
    public ResponseInfo(int status, List<BookInfo> bookInfos, List<Category> categoryInfos) {
        this.status = status;
        this.bookInfos = bookInfos;
        this.categoryInfos = categoryInfos;
    }

    /*
    //订单详情
    public ResponseInfo(int status, List<Object> orderitems) {
        this.status = status;
        this.orderitems = orderitems;
    }


     */
    public ResponseInfo() {

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
