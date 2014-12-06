package model.classes;

public abstract class Customer
{
	protected int customerId;
	protected String email;
	protected String phone;
	protected String street;
	protected String houseNumber;
	protected Zip zip;
	protected int country;
	protected boolean isCompany;
	
	public Customer(int customerId)
	{
		this.customerId = customerId;
		this.email = null;
		this.phone = null;
		this.street = null;
		this.houseNumber = null;
		this.zip = null;
		this.country = 0;
		this.isCompany = false;
	}
	
	public Customer(int customerId, String email, String phone, String street, String houseNumber, Zip zip, int country)
	{
		this.customerId = customerId;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zip = zip;
		this.country = country;
		this.isCompany = false;
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
	
	public int getCountry()
	{
		return this.country;
	}
	
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	public void setHouseNumber(String houseNumber)
	{
		this.houseNumber = houseNumber;
	}
	 
	public void setZip(Zip zip)
	{
		this.zip = zip;
	}
	 
	public void setCountry(int country)
	{
		this.country = country;
	}
	
	public String getCustomerName()
	{
		if(this instanceof Company)
		{
			return ((Company) this).getCompanyName();
		}
		else if (this instanceof PrivateCustomer)
		{
			return ((PrivateCustomer) this).getFirstName() + " " + ((PrivateCustomer) this).getLastName();
		}
		else 
		{
			return null;
		}
	}
	
	public boolean isCompanyCustomer()
	{
		return (this instanceof Company);
	}
	
	public String toString()
	{
		return this.getCustomerName();
	}
	
	/**
	 * @author ai
	 * @param customer
	 * @return 10% discount if customer is company
	 */
	public double getDiscount()
	{
		if(this.isCompanyCustomer())
			return 10;
		else 
			return 0;
	}
}