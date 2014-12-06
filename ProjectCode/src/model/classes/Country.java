package model.classes;

public class Country {

	private int id;
	private String shortName;
	private String longName;
	private String callingCode;
	private String iso3;
	
	public Country(int id, String shortName,String longName,String callingCode,String iso3)
	{
		this.id = id;
		this.shortName = shortName;
		this.longName = longName;
		this.callingCode = callingCode;
		this.iso3 = iso3;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getCallingCode() {
		return callingCode;
	}
	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}
	public String getIso3() {
		return iso3;
	}
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	@Override
	public String toString()
	{
		return this.getShortName();
	}
}
