
package com.servlet;

import com.google.gson.Gson;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 * @author RecLusIve_F
 * @create --\
 */
public class RegisterServlet extends HttpServlet {

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
        String usernameInfo = userService.checkForUsername(username);
        String passwordInfo = userService.checkForPassword(password);
        // 实例化Gson
        Gson gson = new Gson();

        if(usernameInfo.equals("success") && passwordInfo.equals("success")){
            if (userService.addUser(username, password)) {
                String result = gson.toJson(new ResponseInfo(0, "注册成功"));
                resp.getWriter().write(result);
            } else {
                String result = gson.toJson(new ResponseInfo(-1, "数据库连接失败"));
                resp.getWriter().write(result);
            }
        } else if (!usernameInfo.equals("success")) {
            String result = gson.toJson(new ResponseInfo(1, usernameInfo));
            resp.getWriter().write(result);
        } else {
            String result = gson.toJson(new ResponseInfo(2, passwordInfo));
            resp.getWriter().write(result);
        }
    }

}

