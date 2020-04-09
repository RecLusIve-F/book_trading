package com.dao;

/**
 * @author Y
 */

import com.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
		//��ѯ����
		public List<User> findAll(){
			String sql="SELECT * FROM `User`";
			return search(sql);
		}

		
		//��ӷ���
		public int insert(User t){
			String str="INSERT INTO `user`(username,password) VALUES(?,?)";
			return executeUpdate(str, new Object[]{t.getUsername(),t.getPassword()});
		}
		
		//�޸ķ���
		public int update(User r){
			String sql="UPDATE `Book` SET `username`=?,`author`=?,`Price`=?,`pageNum`=?, WHERE uid=?";
			return executeUpdate(sql, new Object[]{r.getUsername(),r.getPassword(),r.getUid()});
		}
		
		//ɾ������
		public int delete(User e){
			String sql="DELETE FROM `Book` WHERE id=?";
			return executeUpdate(sql, new Object[]{e.getUid()});
		}
/*
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		List<User>  users = userDao.findAll();
		for (User user:users){
			System.out.println(user.getUsername()+user.getPassword());
		}

	}


 */

}
