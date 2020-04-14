
package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.entity.Orders;
import com.entity.User;
import com.google.gson.*;
import com.service.BookService;
import com.service.CartService;
import com.service.OrderService;
import com.service.UserService;
import com.service.impl.BookServiceImpl;
import com.service.impl.CartServiceImpl;
import com.service.impl.OrderServiceImpl;
import com.service.impl.UserServiceImpl;
import com.servlet.Info.CartInfo;
import com.servlet.Info.ResponseInfo;
import com.servlet.Info.UserInfo;

/**
 * 表示层，负责与前端进行交互，如数据的交互和请求的响应
 * 登录
 * @author dwaneZhou
 * @create --\
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    public LoginServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = new UserServiceImpl();
        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        resp.setContentType("application/json; charset=utf-8");
        // 获取用户输入的用户名
        String username = req.getParameter("username");
        // 获取用户输入的密码
        String password = req.getParameter("password");
        // 实例化Gson
        Gson gson = new Gson();

        CartInfo cartInfo;
        List<CartInfo> cartInfos = new ArrayList<>();
        BookService bookService = new BookServiceImpl();

        CartService cartService = new CartServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        if (userService.login(username, password)) {
            //当前用户信息
            User user = userService.selUserByName(username);
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setUid(user.getUid());
            userInfo.setTelephone(user.getTelephone());
            userInfo.setAddress(user.getAddress());
            //用户购物车信息
            List<Cart> carts = cartService.selCart(user.getUid());
            for (int i = 0; i < carts.size(); i++) {

                boolean isPromo =bookService.isPromo(carts.get(i).getBid());
                cartInfo = new CartInfo(carts.get(i),isPromo);
                cartInfos.add(cartInfo);
            }
            //用户订单信息
            List<Orders> orders = orderService.selOrderInfo(user.getUid());

            String result = gson.toJson(new ResponseInfo(1, "登录成功", userInfo, cartInfos, orders));
            resp.getWriter().write(result);
        } else {
            String result = gson.toJson(new ResponseInfo(0, "用户名或密码错误"));
            resp.getWriter().write(result);
        }
    }

}

