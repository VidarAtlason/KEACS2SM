package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
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
		frame.addCbWeekFromActionListener(listener);
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
	
	public ActionListener listener = new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// update of selected week/year to make sure that user cannot choose a negative time window
			int weekFrom = frame.getSelectedWeekFrom(); 
			int weekTo = frame.getSelectedWeekTo();
			int yearFrom = frame.getSelectedYearFrom();
			int yearTo = frame.getSelectedYearTo();
			if(yearFrom > yearTo)
			{
				frame.setSelectedYearTo(yearFrom - Calendar.getInstance().get(Calendar.YEAR) - 1); 
			}
			if(yearFrom == yearTo)
			{
				if(weekFrom > weekTo)
				{
					frame.setSelectedWeekTo(weekFrom - 1);
				}
			}
			
			//Customer selectedCustomer = (Customer) customers[frame.getSelectedCustomer()];
		
		
		
		//calculatePrice(this.cottage , customer, weekFrom, yearFrom, weekTo, yearTo);
		
		}
	};

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
	
	private boolean isAvailable(int cottageId, int fromValue, int toValue)
	{
		return true; //any smart way to compare week+year w/o converting?
	}
}
