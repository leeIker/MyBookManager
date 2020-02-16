package org.huijingyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.huijingyuan.entity.User;

public class UserDao {
	
	/**
	 * µÇÂ¼ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 */
	public User login(Connection con,User user ) {
		User userResult=null;
		String sql="select * from user where name=? and password=?";
		try {
			PreparedStatement ps=	con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ResultSet re=  ps.executeQuery();
			
			if(re.next()) {
				userResult =new User(re.getString("name"),re.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return userResult;
	}
}
