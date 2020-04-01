package com.dao;

/**
 * @author Y
 */

import com.entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends BaseDao{
		
		public List<Book> search(String sql, Object...params){
			List<Book> list =new ArrayList<Book>();
			Connection conn=this.getconn();
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				pst=this.prepareStatement(conn, sql, params);
				rs=pst.executeQuery();
				while(rs.next()){
					Book wor=new Book();
					wor.setId(rs.getInt(1));
					wor.setName(rs.getString(2));
					wor.setAuthor(rs.getString(3));
					wor.setPrice(rs.getInt(4));
					wor.setPagenum(rs.getInt(5));
					wor.setCid(rs.getInt(6));
					wor.setPicture(rs.getString(7));
					wor.setSummary(rs.getString(8));
					list.add(wor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn, pst, rs);
			}
			return list;
		}
		
		//查询表
		public List<Book> findAll(){
			String sql="SELECT * FROM `Book`";
			return search(sql);
		}
		
		//添加方法
		public int insert(Book t){
			String str="INSERT INTO `Book`(bid,bname,author,Price,pageNum,cid,Picture,summary) VALUES(?,?,?,?,?,?,?,?,?)";
			return executeUpdate(str, new Object[]{t.getId(),t.getName(),t.getAuthor(),t.getPrice(),t.getPagenum(),t.getCid(),t.getPicture(),t.getSummary()});
		}
		
		//修改方法
		public int update(Book r){
			String sql="UPDATE `Book` SET `bname`=?,`author`=?,`Price`=?,`pageNum`=?, `Picture`=?,`summary`=?,WHERE bid=?";
			return executeUpdate(sql, new Object[]{r.getName(),r.getAuthor(),r.getPrice(),r.getPagenum(),r.getPicture(),r.getSummary(),r.getId()});
		}
		
		//删除方法
		public int delete(Book e){
			String sql="DELETE FROM `Book` WHERE id=?";
			return executeUpdate(sql, new Object[]{e.getId()});
		}
		
}

		
	

	
