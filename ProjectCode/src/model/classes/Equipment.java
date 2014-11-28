package model.classes;

public class Equipment
{

	private int equipmentId;
	private String name;
	
	public Equipment(int equipmentId, String name)
	{
		this.equipmentId = equipmentId;
		this.name = name;
	}
	
	public int getEquipmentId()
	{
		return this.equipmentId;
	}
	public String getEquipmentName()
	{
		return this.name;
	}

}