package controller.applicationclasses;

import java.util.ArrayList;

public class Cottage
{

	private int cottageId;
	private CottageType cottageType;
	private String cottageName;
	private String street;
	private String houseNumber;
	private Zip zip;

	public Cottage(int cottageId, CottageType cottageType, String name, String street, String houseNo, Zip zip)
	{
		this.cottageId = cottageId;
		this.cottageType = cottageType;
		this.cottageName = name;
		this.street = street;
		this.houseNumber = houseNo;
		this.zip = zip;
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
	
	public Zip getZip()
	{
		return zip;
	}
	
	public boolean isAvailable(int weekFrom, int yearFrom)
	{
		// TODO - implement Cottage.isAvailable
		throw new UnsupportedOperationException();
	}

}