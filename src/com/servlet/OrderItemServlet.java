package com.servlet;

import com.entity.Orderitem;
import com.google.gson.Gson;
import com.service.OrderItemService;
import com.service.impl.OrderItemServiceImpl;
import com.servlet.Info.ResponseInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 订单项查看(暂未实现)
 * @author dwaneZhou
 * @create --\
 */
public class OrderItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        Gson gson = new Gson();

        OrderItemService orderItemService = new OrderItemServiceImpl();

        int oid = 0;
        String address =req.getParameter("oid");//订单id
        List<Orderitem> orderitems;

        //转换
        if (req.getParameter("oid")!=null&&!req.getParameter("oid").equals("")){
            oid = Integer.parseInt(req.getParameter("oid"));
        }
        orderitems = orderItemService.selOrderItem(oid);

        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setOrderitems(orderitems);
        responseInfo.setStatus(50);

        String result = gson.toJson(responseInfo);
        resp.getWriter().write(result);


    }
}
