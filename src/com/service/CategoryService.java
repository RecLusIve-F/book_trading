package com.service;

import com.entity.Category;

import java.util.List;

/**
 * @author dwaneZhou
 * @create --\
 */
public interface CategoryService {

    boolean addCategory(String cname);//添加分类
    boolean deleteCategory(int cid);//删除分类
    boolean updateCategory(String cname,int cid);//修改分类名
    List<Category> selCategory();//查询分类


}
