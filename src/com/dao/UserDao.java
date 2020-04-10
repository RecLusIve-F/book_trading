package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;


public class UserDao extends BaseDao{
		
		public List<User> search(String sql,Object...params){
			List<User> list =new ArrayList<User>();
			Connection conn=this.getconn();
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				pst=this.prepareStatement(conn, sql, params);
				rs=pst.executeQuery();
				while(rs.next()){
					User wor=new User();
					wor.setUid(rs.getInt(1));
					wor.setUsername(rs.getString(2));
					wor.setPassword(rs.getString(3));
					list.add(wor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn, pst, rs);
			}
			return list;
		}
		//查询用户
		public List<User> findAll(){
			String sql="SELECT * FROM `user`";
			return search(sql);
		}
		
		//插入用户
		public int insert(User t){
			String str="INSERT INTO `user`(username,password) VALUES(?,?)";
			return executeUpdate(str, new Object[]{t.getUsername(),t.getPassword()});
		}
		
		//更新用户
		public int update(User r){
			String sql="UPDATE `users` SET `username`=?,`password`=?, WHERE uid=?";
			return executeUpdate(sql, new Object[]{r.getUsername(),r.getPassword(),r.getUid()});
		}
		
		//删除用户
		public int delete(User e){
			String sql="DELETE FROM `users` WHERE id=?";
			return executeUpdate(sql, new Object[]{e.getUid()});
		}
}
