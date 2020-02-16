package org.huijingyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.huijingyuan.entity.BookType;
import org.huijingyuan.ults.JdbcService;

public class BooktypeDao {
	/**
	 * 增加修改 删除 改 
	 */
	JdbcService jc=new JdbcService();
	public int addType(BookType booktype) {
		
		int i=0;
		try {
			Connection con=	jc.getCon();
			String sql="insert into booktype (booktype,bookdes)values(?,?)";
			PreparedStatement sta=	con.prepareStatement(sql);
			sta.setString(1, booktype.getBooktype());
			sta.setString(2, booktype.getBookDes());
			 i=	 sta.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
		
	}
	
	public ResultSet queryBookType(String booktype ) throws Exception {
		Connection con=jc.getCon();	
		String sql="select * from booktype where booktype =?";
		
		PreparedStatement sta=  con.prepareStatement(sql);
		sta.setString(1, booktype);
		ResultSet result=   sta.executeQuery();
		
		return result;
	}
	
	public int updataBooktype(BookType  booktype) throws Exception{
			Connection con=jc.getCon();
			String sql="update booktype set booktype=?,bookdes=? where booktype=?";
			PreparedStatement sta=con.prepareStatement(sql);
			sta.setString(1, booktype.getBooktype());
			sta.setString(2, booktype.getBookDes());
			sta.setString(3, booktype.getBooktype());
			int i=	sta.executeUpdate();	
		
		return i;
	}
	
	public int deleteBooktype(String booktype) throws Exception{
			Connection con=jc.getCon();
			String sql="delete from booktype where booktype =?";
			PreparedStatement sta=con.prepareStatement(sql);
			sta.setString(1, booktype);
			int i	= sta.executeUpdate();
			
			
		
		return i;
	}
	
	
	public ResultSet queryAllBookType() throws Exception {
			Connection con=jc.getCon();	
			String sql="select * from booktype";
		
			PreparedStatement sta=  con.prepareStatement(sql);
			ResultSet result=   sta.executeQuery();
			
		return result;
	}
	
	
	/**
	 * 查询book表中的所有booktype；
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public ResultSet queryBooktype(Connection con) throws SQLException {
		String sql="select  booktype from booktype";
		Statement sta=con.createStatement();	
		ResultSet re=  sta.executeQuery(sql);
		return re;
	}
	
	
	
	
	
}
