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
					wor.setAddress(rs.getString(4));
					wor.setTelephone(rs.getString(5));
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
			String sql="select * from user";
			return search(sql);
		}

		//根据姓名查找用户
		public List<User> findUser(String username){
			String sql = "select * from user where username = ?";
			return search(sql,username);
		}
		
		//插入用户
		public int insert(User t){
			String str="insert into user (username,password,address,telephone) VALUES(?,?,?,?)";
			return executeUpdate(str, new Object[]{t.getUsername(),t.getPassword(),t.getAddress(),t.getTelephone()});
		}
		
		//更新用户
		public int update(String username,String address,String telephone,int uid){
			String sql="update user set `username`=?,`address`=?,`telephone`=? WHERE uid=?";
			return executeUpdate(sql, new Object[]{username,address,telephone,uid});
		}
		
		//删除用户
		public int delete(int uid){
			String sql="delete from user where uid=?";
			return executeUpdate(sql, new Object[]{uid});
		}
}
