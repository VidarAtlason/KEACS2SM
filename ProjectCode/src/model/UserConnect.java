package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserConnect {

	public static boolean isUser(String username, String password) throws SQLException
	{
		String sql = "select * from users where username = ? AND password =MD5(?)";
		Connection conn = DBConnect.getConnection();			
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, username);
		p.setString(2, password);
		ResultSet rs = p.executeQuery();
		if (rs.next())
			return true;
		return false;
	}
	public static void addToLog(String username) throws SQLException
	{
		String sql = "INSERT INTO user_log (userId) VALUES((select id from users where username=?))";
		Connection conn = DBConnect.getConnection();			
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, username);
		p.execute();
	}
}
