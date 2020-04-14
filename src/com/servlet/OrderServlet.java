package com.servlet;

import com.google.gson.Gson;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import com.servlet.Info.ResponseInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 订单操作
 * 添加订单
 * @author dwaneZhou
 * @create --\
 */
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        Gson gson = new Gson();

        OrderService orderService = new OrderServiceImpl();

        int uid = 0;
        String address =req.getParameter("address");//收件地址
        double total = 0;

        int[] bid = {1};//随意取值，暂未实现部分购物项生成订单

        //转换
        if (req.getParameter("uid")!=null&&!req.getParameter("uid").equals("")){
            uid = Integer.parseInt(req.getParameter("uid"));
        }
        if (req.getParameter("total")!=null&&!req.getParameter("total").equals("")){
            total = Double.parseDouble(req.getParameter("uid"));
        }
        if (orderService.addOrder(uid,address,total,bid)){
            String result = gson.toJson(new ResponseInfo(40,"成功生成订单"));
            resp.getWriter().write(result);
        }

    }
}
