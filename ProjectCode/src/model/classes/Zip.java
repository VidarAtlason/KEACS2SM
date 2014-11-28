package model.classes;

public class Zip
{
	protected int zipCode; 
	protected String city;
	
	public Zip(int code, String city)
	{
		this.zipCode = code;
		this.city = city;
	}
	
	public int getZipCode()
	{
		return zipCode;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
}
