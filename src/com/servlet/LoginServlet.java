
package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.*;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 *表示层，负责与前端进行交互，如数据的交互和请求的响应
 * @author RecLusIve_F
 * @create --\
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
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
        // 判断是否登录成功
//        if (user.equals("admin") && password.equals("admin")) {
//            // 登录成功则输出提示信息
//            String result = gson.toJson(new ResponseInfo(1, "登录成功"));
//            resp.getWriter().write(result);
//        } else {
//            // 登录失败也输出提示信息
//            String result = gson.toJson(new ResponseInfo(0, "用户名或密码错误"));
//            resp.getWriter().write(result);
//        }
        if (userService.login(username, password)) {
            String result = gson.toJson(new ResponseInfo(1, "登录成功"));
            resp.getWriter().write(result);
        } else {
            String result = gson.toJson(new ResponseInfo(0, "用户名或密码错误"));
            resp.getWriter().write(result);
        }
    }
}

