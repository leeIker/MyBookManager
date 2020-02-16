package org.huijingyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.huijingyuan.entity.Book;
import org.huijingyuan.ults.JdbcService;

public class BookDao {

	public int addBook(Book book) {
		
		/**
		 * 图书添加
		 */
		JdbcService  jdbcs=new JdbcService();
     int i=0;
		try {
			Connection con=  jdbcs.getCon();
			String sql="insert into book (bookname,booktype,bookauther) values (?,?,?)";
			PreparedStatement sta= con.prepareStatement(sql);
			sta.setString(1,book.getName());
			sta.setString(2,book.getType());
			sta.setString(3,book.getAuther());
			i=sta.executeUpdate();
			jdbcs.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * 查询所有图书
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public ResultSet 	queryAllBook(Connection con) throws SQLException {
		String sql="select * from book";
		Statement sta=	con.createStatement();
		ResultSet re=	sta.executeQuery(sql);
		return re;
	}
	
	/**
	 * 根据图书名查图书
	 * @param con
	 * @param bookname
	 * @return
	 * @throws SQLException
	 */
	public ResultSet queryBookByName(Connection con,String bookname) throws SQLException {
		String sql="select * from book where bookname =?";
		PreparedStatement sta=	con.prepareStatement(sql);
		sta.setString(1,bookname);
		ResultSet re= sta.executeQuery();
		return re;
	}
	
	/**
	 * 制作图书删除功能
	 * 根据图书名字来善
	 * @throws SQLException 
	 */
	public int deleteBookByName(Connection con,String bookname) throws SQLException {
		String sql="delete from book where bookname =?";
		PreparedStatement sta=con.prepareStatement(sql);
		sta.setString(1, bookname);
		int i=sta.executeUpdate();
		
		return i;
	}
	
	
	public int updateBook(Connection con,Book book) throws SQLException {
		String sql="update book set bookname=?,booktype=?,bookauther=? where bookname=?";
		PreparedStatement sta=con.prepareStatement(sql);
		sta.setString(1, book.getName());
		sta.setString(2, book.getType());
		sta.setString(3, book.getAuther());
		sta.setString(4, book.getName());
		int i=	sta.executeUpdate();
		return i;
	}
	
	
	
}
