package model.classes;

import java.util.Calendar;

public class PrivateCustomer extends Customer
{

	private String firstName;
	private String lastName;
	private boolean gender;
	private Calendar birthdate;
	
	public PrivateCustomer(int customerId, String firstName, String lastName )
	{
		super(customerId);
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = true;
		this.birthdate = null;		
	}
	
	public PrivateCustomer(int customerId, String email, String phone,String street, String houseNumber, Zip zip,
			int country, String firstName, String lastName, boolean gender, Calendar birthdate)
	{
		super(customerId, email, phone, street, houseNumber, zip, country);
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public Calendar getBirthdate()
	{
		return birthdate;
	}
	
	public boolean getGender()
	{
		return this.gender;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setGender(boolean gender)
	{
		this.gender = gender;
	}
	
	public void setBirthdate(Calendar birthdate)
	{
		this.birthdate = birthdate;
	}

}