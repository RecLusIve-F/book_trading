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

/**
 * @author dwaneZhou
 * @create --\
 */
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        resp.setContentType("application/json; charset=utf-8");

        List<Book> books = bookService.selAllBooks();
        Gson gson = new Gson();
        BookInfo bookInfo = new BookInfo();
        List<BookInfo> bookInfos = new ArrayList<>();

        for (int i =0;i<books.size();i++){
            bookInfo.setBid(books.get(i).getBid());
            bookInfo.setBname(books.get(i).getBname());
            bookInfo.setAuthor(books.get(i).getAuthor());
            bookInfo.setPrice(books.get(i).getPrice());
            bookInfo.setPagenum(books.get(i).getPagenum());
            bookInfo.setCid(books.get(i).getCid());
            bookInfo.setSummary(books.get(i).getSummary());
            bookInfo.setPicture(books.get(i).getPicture());
            bookInfo.setCreateTime(books.get(i).getCreateTime());
            bookInfo.setUid(books.get(i).getUid());

            bookInfo.setPromo(bookService.isPromo(books.get(i).getBid()));
            bookInfo.setSpecial(bookService.isSpecial(books.get(i).getBid()));
            bookInfo.setNew(bookService.isNew(books.get(i).getBid()));
            bookInfos.add(bookInfo);
        }

        String result = gson.toJson(new ResponseInfo(100, bookInfos));
        resp.getWriter().write(result);

    }

}
