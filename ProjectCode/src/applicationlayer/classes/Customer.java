package applicationlayer.classes;

public abstract class Customer
{

	protected int customerId;
	protected String email;
	protected String phone;
	protected String street;
	protected String houseNumber;
	protected String postcode;
	protected String city;
	protected String country;
	
	protected Customer(int customerId, String email, String phone, String street, String houseNumber, String postCode, String city, String country)
	{
		this.customerId = customerId;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.houseNumber = houseNumber;
		this.postcode = postCode;
		this.city = city;
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
	
	public String getPostcode()
	{
		return this.postcode;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public String getCountry()
	{
		return this.country;
	}

}