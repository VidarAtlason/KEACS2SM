package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.classes.Company;
import model.classes.Customer;
import model.classes.PrivateCustomer;
import model.classes.Zip;

public class CustomerConnect
{
	public static List<Customer> getAllCompanies() throws SQLException
	{
		String sql = "";
		Connection conn = DBConnect.getConnection();	
		PreparedStatement prep = conn.prepareStatement(sql);	
		
		List<Customer> customers = new ArrayList<Customer>();
		try
		{
			sql = "Select * from company order by name;";
	
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
		
			while(rs.next())
			{
				int customerId = rs.getInt("id");
				String companyName = rs.getString("name");
				Customer customer = new Company(customerId, companyName);
				customers.add(customer);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (prep != null){
				prep.close();
			
			} else if (conn != null){
				conn.close();
			}
		}
		return customers;
	}
	
	public static List<Customer> getAllPrivateCustomers() throws SQLException
	{
		String sql = "";
		Connection conn = DBConnect.getConnection();	
		PreparedStatement prep = conn.prepareStatement(sql);
		
		List<Customer> privateCustomers = new ArrayList<Customer>();
		try
		{
			sql = "Select * from privatecustomer order by fName;";
		
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
		
			while(rs.next())
			{
				int customerId = rs.getInt("id");
				String firstName = rs.getString("fName");
				String lastName = rs.getString("lName");
				Customer customer = new PrivateCustomer(customerId, firstName, lastName);
				privateCustomers.add(customer);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (prep != null){
				prep.close();
			
			} else if (conn != null){
				conn.close();
			}
		}
		return privateCustomers;
		}
	
	
	/**
	 * Inserts information to the database.
	 * 
	 * @param Company
	 * @author Martin
	 */
	public void addNewCustomer(PrivateCustomer newPrivateCustomer) throws SQLException{
	
		String sql = "";
		Connection conn = DBConnect.getConnection();	
		PreparedStatement prep = conn.prepareStatement(sql);
		
		try{
			try{
				String fName = newPrivateCustomer.getFirstName();
				String lName = newPrivateCustomer.getLastName();
				String email = newPrivateCustomer.getEmail();			
				int phone = Integer.parseInt(newPrivateCustomer.getPhone());			
				String street = newPrivateCustomer.getStreet();
				String housenumber = newPrivateCustomer.getHouseNumber();
				Zip zip = newPrivateCustomer.getZip();
				int country = Integer.parseInt(newPrivateCustomer.getCountry());
				boolean gender = newPrivateCustomer.getGender();
				Calendar birthday = newPrivateCustomer.getBirthdate();
				
				int zipCode = zip.getZipCode();
				
				// I played around with this one for some time. And i figured with Alex, that the data conversion don't happens properly
				// in most .parse/.get/.to methods. With using the .getTimeInMillis(), the conversion apparently happens accurate enough
				// for the Date to handle it correctly.
				// Also note, that I have been using the java.sql.Date to accurately point on the SQL Data datatype and not the Java Date datatype.
				java.sql.Date bdate = new Date(birthday.getTimeInMillis());
				
				sql = " INSERT INTO customer (fName, lName, email, phoneNo, street, houseNumer, zip, country_fk, gender, birthdate)"
				        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				
				//Study note.
				/* Essentially, I could do the following prep.setSomething in a different way.
				 * If I set up the following prepared statements this way, it work just fine.
				 * 
				 * prep.setString (1, newPrivateCustomer.getFirstName());
				 * 
				 * 				
				 * But in some of the cases, I will encounter a datatype where i need to do some conversion
				 * 
				 * prep.setInt (4, Integer.parseInt(newPrivateCustomer.getPhone()));
				 * 
				 * Personally I find this quite messy, and like to seperate the actual dataconversion and the setting of data.
				 * I do this, to break the logic up, so I first convert, and after that set. The goal is to reduce confusion,
				 * but the tradeof is even more code.
				 * 
				 * In the future, I might very well not seperate the code, as I in the long run, found it abit tedious to make double as
				 * much code as i needed.
				 */
				

				
				prep.setString (1, fName);
				prep.setString (2, lName);
				prep.setString (3, email);
				prep.setInt (4, phone);
				prep.setString (5, street);
				prep.setString (6, housenumber);
				prep.setInt (7, zipCode);
				prep.setInt (8, country);
				prep.setBoolean(9, gender);
				prep.setDate(10, bdate);

				prep.execute();			

			} catch(Exception e){
				System.err.println("Informations was not submitted to the database.");
				System.err.println(e);
			}
		} catch (Exception e){
		} finally 
		{
			/*
			 * These finallys is introduced, to make sure that the different resources (connections/preparedStatements)
			 * is closed after use. This releases resources that the system uses.
			 * 
			 * It might be overkill for this system as it is not scaled into a size where resources might become a problem.
			 * I assume that Javas own garbage collection could do the job just fine.
			 * 
			 * But I still find it as a good practice. Becouse the if the project was scaled up, or the project was transfered
			 * to a mobile platform, the resource conservation politic could become paramount to the system.
			 */
			if (prep != null){
				prep.close();
			
			} else if (conn != null){
				conn.close();
			}
		}
	}
	
	
	/**
	 * Inserts information to the database.
	 * 
	 * @param Company
	 * @author Martin
	 */
	public void addNewCustomer(Company newCompany) throws SQLException{
		String sql = "";
		Connection conn = DBConnect.getConnection();	
		PreparedStatement prep = conn.prepareStatement(sql);

		try{
			try{

			// I do some conversion in this block of code. I know that it's an additional and unnecessar
			// step to do the the conversion apart from the prep.setWhatever methods further down the page.
			// But I feel the seperation of the conversion, and the actual setting, makes it a little bit
			// clear what's going on.
			int cvr = Integer.parseInt(newCompany.getCVR());
			String email = newCompany.getEmail();			
			String name = newCompany.getCompanyName();			
			String contactName = newCompany.getContactPersonName();
			int phoneNo = Integer.parseInt(newCompany.getPhone());
			int faxNo = Integer.parseInt(newCompany.getFax());
			String address = newCompany.getStreet();
			String addressNo = newCompany.getHouseNumber();
			Zip zip = newCompany.getZip();								//The zip object is extraordinary and contains additional information. In this case though, we only need the zip code.
			int country = Integer.parseInt(newCompany.getCountry());
			
			int zipCode = zip.getZipCode(); // Retrieving the zipcode from the zip object.

			sql = " INSERT INTO company (cvr, email, name, contactName, phoneNo, faxNo, steet, houseNumber, zip_fk, country_fk)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
			prep.setInt (1, cvr);
			prep.setString (2, email);
			prep.setString (3, name);
			prep.setString (4, contactName);
			prep.setInt (5, phoneNo);
			prep.setInt (6, faxNo);
			prep.setString (7, address);
			prep.setString (8, addressNo);
			prep.setInt(9, zipCode);
			prep.setInt(10, country);
			
			prep.executeUpdate();
			
			} catch(Exception e){
				System.err.println("Informations was not submitted to the database.");
				System.err.println(e.getMessage());
			}
		} catch (Exception e){
		} finally {
			if (prep != null){
				prep.close();
			
			} else if (conn != null){
				conn.close();
			}
		}
	}
	
}
