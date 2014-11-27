package controller.applicationclasses;

import java.util.Calendar;

public class PrivateCustomer extends Customer
{

	private String firstName;
	private String lastName;
	private boolean gender;
	private Calendar birthdate;
	
	public PrivateCustomer(int customerId, String email, String phone,String street, String houseNumber, Zip zip,
			String country, String firstName, String lastName, boolean gender, Calendar birthdate)
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

}