package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	/***
	 *
	 *
	 */
		private String driver ="com.mysql.jdbc.Driver";
		private String url="jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
		private String name="root";
		private String pwd="jx265810";
	      Connection conn=null;
	

		protected  Connection getconn(){
			conn=null;	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(url,name,pwd);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return conn;
		}
		
	
		protected void closeAll(Connection conn ,PreparedStatement ps,ResultSet rs){		
			if(rs!=null)
				try {
					if(rs!=null)
					rs.close();
					if(ps!=null)
					ps.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		}
		
		public int executeUpdate(String sql ,Object []ob){
			conn=getconn();
			PreparedStatement ps=null;
			try {
				ps=prepareStatement(conn,sql,ob);
				int i=ps.executeUpdate();
				return i;	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			    //	e.printStackTrace();
				return 0;
			}finally{			
				closeAll(conn, ps, null);
			}
		
		}	
	
		protected PreparedStatement prepareStatement(Connection conn,String sql,Object []ob){		
			PreparedStatement ps=null;
					try {
						int index=1;
						ps = conn.prepareStatement(sql);
							if(ps!=null&&ob!=null){
								for (int i = 0; i < ob.length; i++) {			
										ps.setObject(index, ob[i]);	
										index++; 
								}
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			 return ps;
		}
	
}

