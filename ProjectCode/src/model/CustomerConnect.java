package model;

import java.sql.Connection;
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
	public static List<Customer> getAllCompanies()
	{
		List<Customer> customers = new ArrayList<Customer>();
		try
		{
			String sql = "Select * from company order by name;";
			Connection conn = DBConnect.getConnection();			
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
		}
		return customers;
	}
	
	public static List<Customer> getAllPrivateCustomers()
	{
		List<Customer> privateCustomers = new ArrayList<Customer>();
		try
		{
			String sql = "Select * from privatecustomer order by fName;";
			Connection conn = DBConnect.getConnection();			
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
		}
		return privateCustomers;
	}

	public void addNewCustomer(PrivateCustomer newPrivateCustomer) throws SQLException{
	/**
	 * This method build and executes the a query that adds a new customer to the database.
	 * 
	 * @param PrivateCustomer or Company
	 * @author Martin
	 */
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
				String bDate = birthday.toString();
				// Can't figure out how to handle this one.
	
				String sql = " INSERT INTO customer (fName, lName, email, phoneNo, address, addressNo, zip, country, gender, birthdate)"
				        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
				Connection conn = DBConnect.getConnection();			
				PreparedStatement prep = conn.prepareStatement(sql);

				prep.setString (1, fName);
				prep.setString (2, lName);
				prep.setString (3, email);
				prep.setInt (4, phone);
				prep.setString (5, street);
				prep.setString (6, housenumber);
				prep.setInt (7, zipCode);
				prep.setInt (8, country);
				prep.setBoolean(9, gender);
				prep.setString(10, bDate);

				prep.executeUpdate();			

			} catch(Exception e){
				System.err.println("Informations was not submitted to the database.");
				System.err.println(e.getMessage());
			}
		} catch (Exception e){
		} finally {
			
			//Closes the connection
			DBConnect.close();
		}
	}
	
	public void addNewCustomer(Company newCompany) throws SQLException{
		//Create database connect object.
		/**
		 * This method build and executes the a query that adds a new customer to the database.
		 * 
		 * @param PrivateCustomer or Company
		 * @author Martin
		 */
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

			String sql = " INSERT INTO company (cvr, email, name, contactName, phoneNo, faxNo, address, addressNo, zip, country)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Connection conn = DBConnect.getConnection();			
			PreparedStatement prep = conn.prepareStatement(sql);
	
			//Study note.
			/* Essentially, I could do the following prep.setSomething in a different way.
			 * 
			 * 
			 */
			
			
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
			
			//Closes the connection
			DBConnect.close();
		}
	}
	
}
