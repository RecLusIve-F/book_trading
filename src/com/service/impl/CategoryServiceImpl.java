package com.service.impl;

import com.dao.BookDao;
import com.dao.CategoryDao;
import com.entity.Book;
import com.entity.Category;
import com.service.CategoryService;

import java.util.List;


/**
 * @author dwaneZhou
 * @create --\
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDao();

    @Override
    public boolean addCategory(String cname) {
        categoryDao.insert(cname);
        return true;
    }

    @Override
    public boolean deleteCategory(int cid) {
        categoryDao.delete(cid);
        return true;
    }

    @Override
    public boolean updateCategory(String cname, int cid) {
        categoryDao.update(cname, cid);
        return true;
    }



    @Override
    public List<Category> selCategory() {
        return categoryDao.findAll();
    }
/*
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();
        //插入
        //categoryService.addCategory("历史");
        //删除
        //categoryService.deleteCategory(4);
        //修改
        //categoryService.updateCategory("社科",3);
        //查询
        List<Category> list  = categoryService.selCategory();
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i).getCname());
        }
        }


 */
    @Override
    public int selCid(String cname) {
        List<Category> categories = categoryDao.findAll();
        for (Category x:categories){
            if (x.getCname().equals(cname)){
                return x.getCid();
            }
        }
        return 0;
    }
}
