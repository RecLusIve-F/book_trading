package com.servlet;

import com.google.gson.Gson;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.servlet.Info.ResponseInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改用户信息
 * @author dwaneZhou
 * @create --\
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        Gson gson = new Gson();
        String result;

        UserService userService = new UserServiceImpl();

        String username = req.getParameter("username");
        String telephone = req.getParameter("telephone");
        String address = req.getParameter("address");
        int uid = 0;

        //转换
        if (req.getParameter("uid")!=null&&!req.getParameter("uid").equals("")){
            uid = Integer.parseInt(req.getParameter("uid"));
        }
        String flag = userService.updateUserInfo(username,telephone,address,uid);
        if(flag.equals("success")){
            result = gson.toJson(new ResponseInfo(1,"修改成功"));
        }else {
            result = gson.toJson(new ResponseInfo(0,flag));
        }

        resp.getWriter().write(result);

    }
}
