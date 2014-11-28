package model.classes;

public class Company extends Customer
{

	private String companyName;
	private String CVR;
	private String fax;
	private String contactPersonName;
	
	public Company(int customerId, String email, String phone,String street, String houseNumber, Zip zip,
			String country, String companyName, String CVR, String fax, String contactPersonName)
	{
		super(customerId, email, phone, street, houseNumber, zip, country);
		this.companyName = companyName;
		this.CVR = CVR;
		this.fax = fax;
		this.contactPersonName = contactPersonName;
	}

	public String getCompanyName()
	{
		return companyName;
	}
	
	public String getCVR()
	{
		return CVR;
	}
	
	public String getFax()
	{
		return fax;
	}
	
	public String getContactPersonName()
	{
		return contactPersonName;
	}
	
	public double getDiscountRate()
	{
		// TODO - implement Company.getDiscountRate
		throw new UnsupportedOperationException();
	}

}