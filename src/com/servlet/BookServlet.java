package com.servlet;

import com.entity.Book;
import com.entity.Category;
import com.google.gson.Gson;
import com.service.BookService;
import com.service.CategoryService;
import com.service.impl.BookServiceImpl;
import com.service.impl.CategoryServiceImpl;
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
 * 表示层，负责与前端进行交互，如数据的交互和请求的响应
 * 获取图书以及分类信息
 * 发布图书
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

        Book book = new Book();
        List<Book> books = bookService.selAllBooks();//全部图书
        List<Category> categories = categoryService.selCategory();//分类信息

        BookInfo bookInfo;
        List<BookInfo> bookInfos = new ArrayList<>();
        String code = req.getParameter("code");//判断码，是否插入1, 0全局
        String result;

        int bid = 0;
        String bname = req.getParameter("bname");
        String author = req.getParameter("author");
        double price = 0;
        int pageNum = 0;
        int cid = 0;
        String summary = req.getParameter("summary");
        String picture= req.getParameter("picture");
        int uid = 0;

        if (req.getParameter("bid")!=null&&!req.getParameter("bid").equals("")){
            bid = Integer.parseInt(req.getParameter("bid"));
        }

        if (req.getParameter("price")!=null&&!req.getParameter("price").equals("")){
            price = Double.parseDouble(req.getParameter("price"));
        }
        if (req.getParameter("pageNum")!=null&&!req.getParameter("pageNum").equals("")){
            pageNum = Integer.parseInt(req.getParameter("pageNum"));
        }
        if (req.getParameter("cid")!=null&&!req.getParameter("cid").equals("")){
            cid = Integer.parseInt(req.getParameter("cid"));
        }
        if (req.getParameter("uid")!=null&&!req.getParameter("uid").equals("")){
            uid = Integer.parseInt(req.getParameter("uid"));
        }

        book.setBid(bid);
        book.setBname(bname);
        book.setAuthor(author);
        book.setPrice(price);
        book.setPagenum(pageNum);
        book.setCid(cid);
        book.setSummary(summary);
        book.setPicture(picture);
        book.setUid(uid);

        if (code.equals("1")){
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setStatus(10);
            responseInfo.setBooks(books);
            books = bookService.selBookByName(bname);
            result = gson.toJson(responseInfo);
            resp.getWriter().write(result);

        }else {
            for (int i =0;i<books.size();i++){
                isNew = bookService.isNew(books.get(i).getBid());
                isPromo = bookService.isPromo(books.get(i).getBid());
                isSpecial = bookService.isSpecial(books.get(i).getBid());
                bookInfo = new BookInfo(books.get(i),isNew,isPromo,isSpecial);
                bookInfos.add(bookInfo);
            }
            result = gson.toJson(new ResponseInfo(10, bookInfos,categories));
            resp.getWriter().write(result);
        }





    }

}
