package com.servlet;

import com.google.gson.Gson;
import com.service.CartService;
import com.service.impl.CartServiceImpl;
import com.servlet.Info.ResponseInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 购物车操作
 * 插入和修改(含删除)购物项
 * @author dwaneZhou
 * @create --\
 */
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        Gson gson = new Gson();

        CartService cartService = new CartServiceImpl();

        int quantity = 1;//默认插入图书数量为1本
        int uid = 0;//用户id
        int bid = 0;//图书id
        String isAdd = req.getParameter("isAdd");//是否插入

        String result;
        //整型转换
        if (req.getParameter("uid")!=null&&!req.getParameter("uid").equals("")){
            uid = Integer.parseInt(req.getParameter("uid"));
        }
        if (req.getParameter("bid")!=null&&!req.getParameter("bid").equals("")){
            bid = Integer.parseInt(req.getParameter("bid"));
        }
        if (req.getParameter("quantity")!=null&&!req.getParameter("quantity").equals("")){
            bid = Integer.parseInt(req.getParameter("quantity"));
        }
        //插入购物项
        if (isAdd.equals("true")){
            if (cartService.addCart(uid,bid)){
                result = gson.toJson(new ResponseInfo(20,"插入成功"));
                resp.getWriter().write(result);
                return;
            }else{
                result = gson.toJson(new ResponseInfo(21,"插入失败"));
                resp.getWriter().write(result);
                return;
            }
        }
        //更新购物项
        if (cartService.updateCart(uid,bid,quantity)){
            result = gson.toJson(new ResponseInfo(22,"更新成功"));
            resp.getWriter().write(result);
        }else {
            result = gson.toJson(new ResponseInfo(23,"更新失败"));
            resp.getWriter().write(result);
        }

    }
}
