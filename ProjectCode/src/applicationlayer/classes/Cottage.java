package applicationlayer.classes;

import java.util.ArrayList;

public class Cottage
{

	private int cottageId;
	private CottageType cottageType;
	private String cottageName;
	private String street;
	private String houseNumber;
	private int postCode;

	public Cottage(int cottageId, CottageType cottageType, String name, String street, String houseNo, int postCode)
	{
		this.cottageId = cottageId;
		this.cottageType = cottageType;
		this.cottageName = name;
		this.street = street;
		this.houseNumber = houseNo;
		this.postCode = postCode;
	}
	
	public int getCottageId()
	{
		return cottageId;
	}
	
	public CottageType getCottageType()
	{
		return cottageType;
	}
	
	public String getCottageName()
	{
		return cottageName;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public String getHouseNumber()
	{
		return houseNumber;
	}
	
	public int getPostCode()
	{
		return postCode;
	}
	
	public boolean isAvailable(int weekFrom, int yearFrom)
	{
		// TODO - implement Cottage.isAvailable
		throw new UnsupportedOperationException();
	}

}