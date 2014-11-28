package model.classes;

public class CottageType
{

	private int cottageTypeId;
	private String typeName;
	private int noOfBeds;
	private double standardPrice;
	
	public CottageType(int typeId, String name, int noOfBeds, double standardPrice)
	{
		this.cottageTypeId = typeId;
		this.typeName = name;
		this.noOfBeds = noOfBeds;
		this.standardPrice = standardPrice;
	}
	
	public int getCottageTypeId()
	{
		return cottageTypeId;
	}
	
	public String getTypeName()
	{
		return typeName;
	}
	
	public int getNoOfBeds()
	{
		return noOfBeds;
	}
	
	public double getStandardPrice()
	{
		return standardPrice;
	}

}