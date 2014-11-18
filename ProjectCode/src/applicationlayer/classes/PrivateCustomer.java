package applicationlayer.classes;

import java.util.Calendar;

public class PrivateCustomer extends Customer
{

	private String firstName;
	private String lastName;
	private int gender;
	private Calendar birthdate;
	
	public PrivateCustomer(int customerId, String email, String phone,String street, String houseNumber, String postCode, String city,
			String country, String firstName, String lastName, int gender, Calendar birthdate)
	{
		super(customerId, email, phone, street, houseNumber, postCode, city, country);
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
	}

	public String getFullName()
	{
		return this.firstName + " " + this.lastName;
	}

}