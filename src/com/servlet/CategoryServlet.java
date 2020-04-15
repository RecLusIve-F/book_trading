package com.servlet;

import com.entity.Book;
import com.entity.Category;
import com.google.gson.Gson;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.servlet.Info.BookInfo;
import com.servlet.Info.ResponseInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类查询
 */
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        resp.setContentType("application/json; charset=utf-8");

        // 实例化Gson
        Gson gson = new Gson();

        int cid = 0;//分类名

        if (req.getParameter("cid")!=null&&!req.getParameter("cid").equals("")){
            cid = Integer.parseInt(req.getParameter("cid"));
        }


        BookService bookService = new BookServiceImpl();

        List<Book> books = bookService.selBookByCategory(cid);//分类书本

        boolean isNew;
        boolean isPromo;
        boolean isSpecial;

        BookInfo bookInfo;
        List<BookInfo> categoryBookInfos = new ArrayList<>();

        for (int i =0;i<books.size();i++){
            isNew = bookService.isNew(books.get(i).getBid());
            isPromo = bookService.isPromo(books.get(i).getBid());
            isSpecial = bookService.isSpecial(books.get(i).getBid());
            bookInfo = new BookInfo(books.get(i),isNew,isPromo,isSpecial);
            categoryBookInfos.add(bookInfo);
        }

        String result = gson.toJson(new ResponseInfo(1,categoryBookInfos));
        resp.getWriter().write(result);

    }

    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        List<Book> books = bookService.selBookByCategory(9);
        for (int i=0;i<books.size();i++){
            System.out.println(books.get(i).getBname());
        }

    }
}
