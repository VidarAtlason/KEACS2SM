package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.classes.Company;
import model.classes.Cottage;
import model.classes.CottageType;
import model.classes.Customer;
import model.classes.Zip;

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
	/**
	 * @author Orn
	 * @return List<Cottage>
	 * @throws SQLException
	 */
	private static List<Cottage> staticCottages =null;
	public static List<Cottage> getAllCottages(boolean refresh) throws SQLException{
		if (!refresh){
			if(staticCottages!= null)
				return staticCottages;
		}
		List<Cottage> cottages = new ArrayList<Cottage>();
		List<Zip> zips = ZipConnect.getAllZip(false);
		List<CottageType> types = getAllCottageTypes();
		String sql = "SELECT * FROM cottage order by id";
		Connection conn = DBConnect.getConnection();			
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		
		while (rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String street = rs.getString(3);
			String houseNumber = rs.getString(4);
			int zipCode = rs.getInt(5);
			int cottageType = rs.getInt(6);
			Zip zip = null;
			CottageType type = null;
			for(Zip z : zips)
			{
				if(z.getZipCode()==zipCode)
				{
					zip=z;
				}
			}
			for(CottageType t : types)
			{
				if(t.getCottageTypeId()==cottageType)
				{
					type=t;
				}
			}
			Cottage cottage = new Cottage(id, type, name, street, houseNumber,zip);
			cottages.add(cottage);
		}
		
		return cottages;
	}
	
	/**
	 * @author Orn
	 * @return List<CottageType>
	 * @throws SQLException
	 */
	public static List<CottageType> getAllCottageTypes() throws SQLException{
		List<CottageType> types = new ArrayList<CottageType>();
		
		String sql = "SELECT id,name,beds,price FROM cottagetype order by id";
		Connection conn = DBConnect.getConnection();			
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int beds = rs.getInt(3);
			double price = rs.getDouble("price");
			CottageType c = new CottageType(id, name, beds, price);
			types.add(c);
		}
		conn.close();
		return types;
	}
}
