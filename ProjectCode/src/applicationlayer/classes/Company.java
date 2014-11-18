package applicationlayer.classes;

public class Company extends Customer
{

	private String companyName;
	private String CVR;
	private String fax;
	private String contactPersonName;
	private String contactPersonPhoneNo;

	public Company(int customerId, String email, String phone,String street, String houseNumber, String postCode, String city,
			String country, String companyName, String CVR, String fax, String contactPersonName, String contactPersonPhone)
	{
		super(customerId, email, phone, street, houseNumber, postCode, city, country);
		this.companyName = companyName;
		this.CVR = CVR;
		this.fax = fax;
		this.contactPersonName = contactPersonName;
		this.contactPersonPhoneNo = contactPersonPhone;
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
	
	public String getContactPersonPhoneNo()
	{
		return contactPersonPhoneNo;
	}
	
	public double getDiscountRate()
	{
		// TODO - implement Company.getDiscountRate
		throw new UnsupportedOperationException();
	}

}