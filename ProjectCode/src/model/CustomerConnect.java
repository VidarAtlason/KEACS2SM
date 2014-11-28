package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.classes.Company;
import model.classes.Customer;
import model.classes.PrivateCustomer;

public class CustomerConnect
{
	public static List<Customer> getAllCompanies()
	{
		List<Customer> customers = null;
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
		List<Customer> privateCustomers = null;
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

}
