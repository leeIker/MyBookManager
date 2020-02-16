package org.huijingyuan.ults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author seven lee
 *date:2020.2.9
 */
public class JdbcService {
	private String url="jdbc:mysql://localhost:3306/bookmanager?serverTimezone=UTC&amp";
	private String name="root";
	private String password="901125";
	private String jdd="com.mysql.cj.jdbc.Driver";
	
	
	/**
	 * ��ȡ���ݿ������
	 * @return
	 * @throws Exception
	 */
	public 	Connection getCon() throws Exception {
		
		Class.forName(jdd);
		
		Connection con=  DriverManager.getConnection(url,name,password);
		return con;	
	}
	
	//�ر����ݿ�����
	public void closeCon(Connection con) throws SQLException {
		
		if(con!=null) {
			con.close();
		}
		
		
		
	}
	

}
