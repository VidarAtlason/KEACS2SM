package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.classes.Company;
import model.classes.Customer;
import model.classes.RateByWeek;

public class RateConnect
{
	public static RateByWeek[] getRatesFromDB() throws SQLException
	{
		RateByWeek[] rates = new RateByWeek[52];
		String sql = "Select * from rate order by id";
		Connection conn = DBConnect.getConnection();			
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		
		int index = 0;
		while(rs.next() && index < 52)
		{
			int weekNo = rs.getInt("id");
			int rate = rs.getInt("rate");
			rates[index] = new RateByWeek(weekNo, rate);
			index++;
		}
		
		if(conn != null)
		{
			conn.close();
		}
		
		return rates;
	}
}
