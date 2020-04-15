package com.dao;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
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

		//插入
		public int insert(String cname){
			String str="INSERT INTO category(cname) VALUES(?)";
			return executeUpdate(str, new Object[]{cname});
		}
		
		//更新
		public int update(String cname,int cid){
			String sql="UPDATE category SET `cname`=? WHERE cid=?";
			return executeUpdate(sql, new Object[]{cname,cid});
		}

		//删除
		public int delete(int cid){
			String sql="DELETE FROM category WHERE cid=?";
			return executeUpdate(sql, new Object[]{cid});
		}
		//查询
		public List<Category> findAll(){
		String sql = "select * from category";
		return search(sql);
		}

}
