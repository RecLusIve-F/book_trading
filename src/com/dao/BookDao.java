package com.dao;


    import java.sql.Connection;
    import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
    import com.entity.Book;
	 
public class BookDao extends BaseDao{
		
		public List<Book> search(String sql,Object...params){
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
					wor.setPrice(rs.getDouble(4));
					wor.setPagenum(rs.getInt(5));
					wor.setCid(rs.getInt(6));
					wor.setSummary(rs.getString(7));
					wor.setPicture(rs.getString(8));
					wor.setCreateTime(rs.getDate(9));
					wor.setUid(rs.getInt(10));
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
		public List<Book> findAll(){
			String sql="select * from book";
			return search(sql);
		}
		
		//插入书本
		public int insert(Book t){
			String str="insert into book (bname,author,price,pagenum,cid,summary,picture,uid) VALUES(?,?,?,?,?,?,?,?)";
			return executeUpdate(str, new Object[]{t.getName(),t.getAuthor(),t.getPrice(),t.getPagenum(),t.getCid(),t.getSummary(),t.getPicture(),t.getUid()});
		}
		
		//更新书本
		public int update(Book r){
			String sql="UPDATE book set `bname`=?,`author`=?,`price`=?,`pagenum`=?, `picture`=?,`summary`=?,`createtime`=?，`uid`=? WHERE bid=?";
			return executeUpdate(sql, new Object[]{r.getName(),r.getAuthor(),r.getPrice(),r.getPagenum(),r.getPicture(),r.getSummary(),r.getUid(),r.getId()});
		}
		
		//删除书本
		public int delete(int bid, int uid){
			String sql="delete from book where bid = ? and uid = ?";
			return executeUpdate(sql, new Object[]{bid,uid});
		}

		//搜索书籍
		public List<Book> findOne(String s){		
			String sql=" select * from book where bname like ? ";
			return search(sql,s+"%");
		}

		//根据书的编码返回书本
		public List<Book> findBook(int bid){
			String sql="select * from book where bid = ?";
			return search(sql,bid);
		}
		
		//根据cname和cid返回书本内容
		public List<Book> findBook(String cname) {
			String sql=" select * from book where cid = ( select cid from category where cname = ? )";
			return search(sql,cname);
		}

		//返回用户发布所有图书
		public List<Book> findBookbyUser(int uid) {
			String sql=" select * from book where uid = ? ";
			return search(sql,uid);
		}

}
		
		

		
	

	
