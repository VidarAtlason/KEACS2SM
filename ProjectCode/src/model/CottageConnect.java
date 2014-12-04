package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.classes.Company;
import model.classes.Customer;

public class CottageConnect
{
	public static double getCottageStandardPrice(int cottageId) throws SQLException
	{
		double price = 0;
		String sql = "select price from cottage join cottagetype on cottage.cottagetype_fk = cottagetype.id where cottage.id = ?;";
		Connection conn = DBConnect.getConnection();			
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, cottageId);
		ResultSet rs = p.executeQuery();
	
		if(rs.next())
		{
			price = rs.getDouble("price");
			return price;
		}
		return price;
	}
}
