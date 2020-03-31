package com.servlet;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *表示层，负责与前端进行交互，如数据的交互和请求的响应
 * @author dwaneZhou
 * @create --\
 */
@WebServlet(urlPatterns = "/LoginServlet")//web注解，完成jsp和servlet的交互
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("pwd");
        UserService userService = new UserServiceImpl();
        User user = new User();
        if (userService.login(name, password)) {
            user.setUsername(name);
            user.setPassword(password);
            request.setAttribute("user", user);//存储变量信息
            //带变量跳转，下一界面仍可获取attribute变量信息
            request.getRequestDispatcher("login_success.jsp").forward(request, response);
        } else {
            request.setAttribute("info", "登陆失败");
            response.sendRedirect("login_failure.jsp");//重定向
        }


        /*
        测试
    public static void main(String[] args){

        UserService userService = new UserServiceImpl();
        if (userService.login("dwane","123456")){
            System.out.println(true);
        }

         */
    }
}
