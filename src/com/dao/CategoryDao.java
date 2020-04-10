package com.dao;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
    import com.mysql.cj.xdevapi.Statement;
    import com.entity.Category;
	 
public class CategoryDao extends BaseDao{
		
		public List<Category> search(String sql,Object...params){
			List<Category> list =new ArrayList<Category>();
			Connection conn=this.getconn();
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				pst=this.prepareStatement(conn, sql, params);
				rs=pst.executeQuery();
				while(rs.next()){
					Category wor=new Category();
					wor.setCid(rs.getInt(1));
					wor.setCname(rs.getString(2));
					list.add(wor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn, pst, rs);
			}
			return list;
		}
		
		//查询书本
		public List<Category> findAll(){
			String sql="SELECT * FROM `Category`";
			return search(sql);
		}
		
		//插入书本
		public int insert(Category t){
			String str="INSERT INTO `Category`(cname) VALUES(?)";
			return executeUpdate(str, new Object[]{t.getCname()});
		}
		
		//更新书本
		public int update(Category r){
			String sql="UPDATE `Category` SET `cname`=?WHERE cid=?";
			return executeUpdate(sql, new Object[]{r.getCname()});
		}
		
		//删除书本
		public int delete(Category e){
			String sql="DELETE FROM `Category` WHERE cid=?";
			return executeUpdate(sql, new Object[]{e.getCid()});
		}
	
		}
