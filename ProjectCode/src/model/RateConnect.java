package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.classes.Company;
import model.classes.Customer;

public class RateConnect
{
	public static int getRate(int weekNo)
	{
		int rate = 0;
		try
		{
			String sql = "Select rate from rate where id = ?;";
			Connection conn = DBConnect.getConnection();			
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, weekNo);
			ResultSet rs = p.executeQuery();
		
			if(rs.next())
			{
				rate = rs.getInt("rate");
				return rate;
			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rate;
	}
}
