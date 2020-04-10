package com.dao;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
    import com.mysql.cj.xdevapi.Statement;
    import com.entity.Order;
	 
public class OrderDao extends BaseDao{
		
		public List<Order> search(String sql,Object...params){
			List<Order> list =new ArrayList<Order>();
			Connection conn=this.getconn();
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				pst=this.prepareStatement(conn, sql, params);
				rs=pst.executeQuery();
				while(rs.next()){
					Order wor=new Order();
					wor.setOid(rs.getInt(1));
					wor.setOrderTime(rs.getString(2));
					wor.setTotal(rs.getInt(3));
					wor.setStatus(rs.getInt(4));
					wor.setAddress(rs.getString(5));
					wor.setUid(rs.getInt(6));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn, pst, rs);
			}
			return list;
		}
		
		//查询
		public List<Order> findAll(){
			String sql="SELECT * FROM `order`";
			return search(sql);
		}
		
		//插入
		public int insert(Order t){
			String str="INSERT INTO `order`(orderTime,total,status,address,uid) VALUES(?,?,?,?,?)";
			return executeUpdate(str, new Object[]{t.getOrderTime(),t.getTotal(),t.getStatus(),t.getAddress(),t.getUid()});
		}
		
		//更新
		public int update(Order r){
			String sql="UPDATE `order` SET `oderTime`=?,`total`=?,`status`=?,`address`=?, `uid`=?WHERE oid=?";
			return executeUpdate(sql, new Object[]{r.getOrderTime(),r.getTotal(),r.getStatus(),r.getAddress(),r.getOid()});
		}
		
		//删除
		public int delete(Order e){
			String sql="DELETE FROM `order` WHERE oid=?";
			return executeUpdate(sql, new Object[]{e.getOid()});
		}
	
		}