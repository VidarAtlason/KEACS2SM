package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.classes.Country;

public class CountryConnect extends DBConnect
{

    public static List<Country> getAllCountries() throws SQLException
    {
	String sql = "";
	Connection conn = DBConnect.getConnection();

	List<Country> countries = new ArrayList<Country>();
	sql = "Select * from country order by id;";

	PreparedStatement p = conn.prepareStatement(sql);
	ResultSet rs = p.executeQuery();

	while (rs.next())
	{
	    int id = rs.getInt("id");
	    String shortName = rs.getString("short_name");
	    String longName = rs.getString("long_Name");
	    String callingCode = rs.getString("calling_code");
	    String iso3 = rs.getString("iso3");
	    Country c = new Country(id, shortName, longName, callingCode, iso3);
	    countries.add(c);
	}
	if (conn != null)
	{
	    conn.close();
	}
	return countries;
    }

}
