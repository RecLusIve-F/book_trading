package com.dao;


    import java.sql.Connection;
    import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
    import com.entity.Orderitem;
	 
public class OrderitemDao extends BaseDao{
		
		public List<Orderitem> search(String sql,Object...params){
			List<Orderitem> list =new ArrayList<Orderitem>();
			Connection conn=this.getconn();
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				pst=this.prepareStatement(conn, sql, params);
				rs=pst.executeQuery();
				while(rs.next()){
					Orderitem wor=new Orderitem();
					wor.setOrderitemid(rs.getInt(1));
					wor.setQuantity(rs.getInt(2));
					wor.setSubtotal(rs.getDouble(3));
					wor.setBid(rs.getInt(4));
					wor.setBname(rs.getString(5));
					wor.setPrice(rs.getDouble(6));
					wor.setOid(rs.getInt(7));
					list.add(wor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn, pst, rs);
			}
			return list;
		}
		
		//查询某个订单项
		public List<Orderitem> findOrderItem(int oid){
			String sql="select * from orderitem where oid = ?";
			return search(sql,oid);
		}

		//查询某本书的全部订单项
		public List<Orderitem> findAll(int bid){
			String sql="select * from orderitem where bid = ?";
			return search(sql,bid);
		}
	
		//插入
		public int insert(Orderitem t){
			String str="insert into orderitem (quantity,subtotal,bid,bname,price,oid) values(?,?,?,?,?,?)";
			return executeUpdate(str, new Object[]{t.getQuantity(),t.getSubtotal(),t.getBid(),t.getBname(),t.getPrice(),t.getOid()});
		}		
		
		
}