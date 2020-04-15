package com.servlet;

import com.entity.Book;
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
 * 按书名检索，模糊匹配
 * @author dwaneZhou
 * @create --\
 */
public class SearchServlet extends HttpServlet {
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

        boolean isNew;
        boolean isPromo;
        boolean isSpecial;
        BookService bookService = new BookServiceImpl();
        BookInfo bookInfo;
        List<Book> books;
        List<BookInfo> bookInfos = new ArrayList<>();

        String bookName = req.getParameter("bname");//书名

        //模糊匹配查询
        books = bookService.selBookByName(bookName);
        for (int i = 0; i < books.size(); i++) {
            isNew = bookService.isNew(books.get(i).getBid());
            isPromo = bookService.isPromo(books.get(i).getBid());
            isSpecial = bookService.isSpecial(books.get(i).getBid());
            bookInfo = new BookInfo(books.get(i), isNew, isPromo, isSpecial);
            bookInfos.add(bookInfo);
        }
        result = gson.toJson(new ResponseInfo(1, bookInfos));
        resp.getWriter().write(result);

    }
}
