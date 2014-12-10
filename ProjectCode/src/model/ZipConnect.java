package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.classes.Zip;

public class ZipConnect
{

    public static List<Zip> staticZips = null;

    public static List<Zip> getAllZip(boolean refresh) throws SQLException
    {
	if (!refresh)
	{
	    if (staticZips != null)
		return staticZips;
	}
	String sql = "";
	Connection conn = DBConnect.getConnection();

	List<Zip> zips = new ArrayList<Zip>();
	sql = "Select * from Zip order by zipCode;";

	PreparedStatement p = conn.prepareStatement(sql);
	ResultSet rs = p.executeQuery();

	while (rs.next())
	{
	    int zipCode = rs.getInt("zipCode");
	    String city = rs.getString("City");
	    Zip z = new Zip(zipCode, city);
	    zips.add(z);
	}
	if (conn != null)
	{
	    conn.close();
	}
	return zips;
    }
}
