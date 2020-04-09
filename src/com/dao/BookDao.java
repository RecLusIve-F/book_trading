package com.dao;

import com.entity.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
					wor.setPrice(rs.getInt(4));
					wor.setPagenum(rs.getInt(5));
					wor.setCid(rs.getInt(6));
					wor.setPictureB(rs.getString(8));
					wor.setPictureS(rs.getString(9));
					wor.setSummary(rs.getString(7));
					list.add(wor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn, pst, rs);
			}
			return list;
		}
		
		//��ѯ��
		public List<Book> findAll(){
			String sql="SELECT * FROM `Book`";
			return search(sql);
		}
		
		//��ӷ���
		public int insert(Book t){
			String str="INSERT INTO `Book`(bid,bname,author,Price,pageNum,cid,PictureB,PictureS,summary) VALUES(?,?,?,?,?,?,?,?,?,?)";
			return executeUpdate(str, new Object[]{t.getId(),t.getName(),t.getAuthor(),t.getPrice(),t.getPagenum(),t.getCid(),t.getPictureB(),t.getPictureS(),t.getSummary()});
		}
		
		//�޸ķ���
		public int update(Book r){
			String sql="UPDATE `Book` SET `bname`=?,`author`=?,`Price`=?,`pageNum`=?, `PictureB`=?,`PictureS`=?,`summary`=?,WHERE bid=?";
			return executeUpdate(sql, new Object[]{r.getName(),r.getAuthor(),r.getPrice(),r.getPagenum(),r.getPictureB(),r.getPictureS(),r.getSummary(),r.getId()});
		}
		
		//ɾ������
		public int delete(Book e){
			String sql="DELETE FROM `Book` WHERE id=?";
			return executeUpdate(sql, new Object[]{e.getId()});
		}
		public static void main(String[] args) throws SQLException, IOException {
			
			String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
			String username = "root";//��Ҫ�������ݿ���˻�
			String password = "root";//��Ҫ�������ݿ������
			
			
			// TODO Auto-generated method stub
	        //1.��������
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			
			//2.��ȡ����
			Connection conn=DriverManager.getConnection(url, username, password);
			
			//3.��ȡ�����ݿⷢsql����statement����
			java.sql.Statement st=conn.createStatement();
			
			//4.�����ݿⷢ��sql����ȡ���ݿⷵ�صĽ����

			
			String sql = "insert into book";
			PreparedStatement pstmt = conn.prepareStatement(sql) ;

			File file = new File("C:/Users/a8211/Desktop/��������.jpg") ;
			FileInputStream fis = new FileInputStream(file);

			pstmt.setString(1, "John");
			pstmt.setBinaryStream(2, fis, (int)file.length());

			pstmt.executeUpdate();

			pstmt.close();
			fis.close();

	
		}
		
		
}

		
	

	
