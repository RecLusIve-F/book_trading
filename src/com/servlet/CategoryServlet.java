package com.servlet;

import com.entity.Book;
import com.google.gson.Gson;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BookService bookService = new BookServiceImpl();
        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        resp.setContentType("application/json; charset=utf-8");

        String category = req.getParameter("book");
        // 实例化Gson
        Gson gson = new Gson();

        List<Book> bookList = bookService.selAllBooks();
        List<BookInfo> bookList_1 = new ArrayList<>();
        for (Book i: bookList) {
            bookList_1.add(new BookInfo(i.getName(), i.getPictureB(), i.getSummary(), bookService.isNew(i), bookService.isPopular(i), bookService.isSpecial(i)));
        }
        String result = gson.toJson(new ResponseInfo(200, bookList_1));
        resp.getWriter().write(result);
    }
}
