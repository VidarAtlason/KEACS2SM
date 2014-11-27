package controller.applicationclasses;

public abstract class Customer
{
	protected int customerId;
	protected String email;
	protected String phone;
	protected String street;
	protected String houseNumber;
	protected Zip zip;
	protected String country;
	
	protected Customer(int customerId, String email, String phone, String street, String houseNumber, Zip zip, String country)
	{
		this.customerId = customerId;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zip = zip;
		this.country = country;
	}
	
	public int getCustomerId()
	{
		return this.customerId;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
	public String getStreet()
	{
		return this.street;
	}
	
	public String getHouseNumber()
	{
		return this.houseNumber;
	}
	
	public Zip getZip()
	{
		return zip;
	}
	
	public String getCountry()
	{
		return this.country;
	}

}