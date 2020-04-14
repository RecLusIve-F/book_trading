package com.servlet;

import com.entity.Book;
import com.entity.Category;
import com.google.gson.Gson;
import com.service.BookService;
import com.service.CategoryService;
import com.service.impl.BookServiceImpl;
import com.service.impl.CategoryServiceImpl;
import com.servlet.Info.BookInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取图书以及分类信息
 * @author dwaneZhou
 * @create --\
 */
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        resp.setContentType("application/json; charset=utf-8");

        Gson gson = new Gson();

        CategoryService categoryService = new CategoryServiceImpl();

        boolean isNew;
        boolean isPromo;
        boolean isSpecial;

        List<Book> books = bookService.selAllBooks();//全部图书
        List<Category> categories = categoryService.selCategory();//分类信息

        BookInfo bookInfo;
        List<BookInfo> bookInfos = new ArrayList<>();

        for (int i =0;i<books.size();i++){
            isNew = bookService.isNew(books.get(i).getBid());
            isPromo = bookService.isPromo(books.get(i).getBid());
            isSpecial = bookService.isSpecial(books.get(i).getBid());
            bookInfo = new BookInfo(books.get(i),isNew,isPromo,isSpecial);

            bookInfos.add(bookInfo);
        }

        String result = gson.toJson(new ResponseInfo(10, bookInfos,categories));
        resp.getWriter().write(result);

    }

}
