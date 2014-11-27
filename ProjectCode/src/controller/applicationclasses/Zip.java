package controller.applicationclasses;

public class Zip
{
	protected String zipCode; 
	protected String city;
	
	public Zip(String zipCode, String city)
	{
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public String getZipCode()
	{
		return zipCode;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
}
