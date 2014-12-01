package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.CottageConnect;
import model.CustomerConnect;
import model.RateConnect;
import model.classes.Company;
import model.classes.Cottage;
import model.classes.CottageType;
import model.classes.Customer;
import model.classes.Zip;
import view.CottageWindow;
import view.CustomerWindow;

public class CottageController
{
	private CottageWindow frame;
	private List<Customer> allCustomers = new ArrayList<Customer>(); 
	private Object[] customersArray;
	private Cottage cottage; 
	
	public CottageController()
	{
		allCustomers = this.getListCustomers();
	}
	public CottageController(Cottage cottage) 
	{
		this();
		frame = new CottageWindow();
		this.cottage = cottage;
		frame.setTextCottageInfo(cottage);
	}
	//  methods
	public List<Customer> getListCustomers()
	{
		allCustomers.addAll(CustomerConnect.getAllCompanies());
		allCustomers.addAll(CustomerConnect.getAllPrivateCustomers());
		return allCustomers;
	}
	public Object[] getCustomersArray()
	{
		customersArray = allCustomers.toArray();
		return customersArray;
	}
	
	public void cbOnSelectedItem(ActionEvent e)
	{
		//Customer selectedCustomer = (Customer) customers[frame.getSelectedCustomer()];
		int weekFrom = frame.getSelectedWeekFrom(); 
		int weekTo = frame.getSelectedWeekTo();
		int yearFrom = frame.getSelectedYearFrom();
		int yearTo = frame.getSelectedYearTo();
		if(yearFrom > yearTo)
		{
			frame.setSelectedYearTo(yearFrom);
		}
		if(yearFrom == yearTo)
		{
			if(weekFrom > weekTo)
			{
				frame.setSelectedWeekTo(weekFrom);
			}
		}
		
		
		//calculatePrice(this.cottage , customer, weekFrom, yearFrom, weekTo, yearTo);
		
	}

	private double calculatePrice(Cottage cottage, Customer customer, int weekFrom, int yearFrom, int weekTo, int yearTo)
	{
		//int totalWeeks = (yearTo - yearFrom) * 52 + weekTo - weekFrom;
		double cottageStandardPrice = CottageConnect.getCottageStandardPrice(cottage.getCottageId()); 
		double totalPrice = 0;
		while(yearFrom < yearTo)
		{
			for (int i = weekFrom; i < 52; i++)
			{
				totalPrice += cottageStandardPrice * (RateConnect.getRate(i) / 100);
			}
			yearFrom++;
			weekFrom = 1;
		}
		for (int i = weekFrom; i < weekTo; i++)
		{
			totalPrice += cottageStandardPrice * (RateConnect.getRate(i) / 100);
		}
		return totalPrice;
	}
}
