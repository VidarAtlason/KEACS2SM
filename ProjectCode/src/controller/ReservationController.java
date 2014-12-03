package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import model.CottageConnect;
import model.CustomerConnect;
import model.RateConnect;
import model.ReservationConnect;
import model.classes.Company;
import model.classes.Cottage;
import model.classes.CottageType;
import model.classes.Customer;
import model.classes.Reservation;
import model.classes.Zip;
import view.CottageWindow;
import view.CustomerWindow;

public class ReservationController
{
	private CottageWindow frame;
	private List<Customer> allCustomers = new ArrayList<Customer>(); 
	private Object[] customersArray;
	private Cottage cottage; 
	
	public ReservationController()
	{
		allCustomers = this.getListCustomers();
		
	}
	public ReservationController(Cottage cottage) 
	{
		this();
		frame = new CottageWindow();
		this.cottage = cottage;
		frame.setTextCottageInfo(cottage);
		frame.addCbActionListener(listener);
	}
	
	/**
	 * @author ai
	 * @return the combined list of customer including company and private customer to the controller
	 */
	public List<Customer> getListCustomers()
	{
		try
		{
			allCustomers.addAll(CustomerConnect.getAllCompanies());
			allCustomers.addAll(CustomerConnect.getAllPrivateCustomers());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}		
		return allCustomers;
	}
	
	/**
	 * @author ai
	 * @return convert the customers list of the Controller to an Object array 
	 */
	public Object[] getCustomersArray()
	{
		customersArray = allCustomers.toArray();
		return customersArray;
	}
	
	/**
	 * @author ai
	 */
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
			
			// check availability during selected duration
			int durationFrom = convertWeekYearToInt(frame.getSelectedWeekFrom(), frame.getSelectedYearFrom());
			int durationTo = convertWeekYearToInt(frame.getSelectedWeekTo(), frame.getSelectedYearTo());
			if(!isAvailable(cottage.getCottageId(), durationFrom) || !isAvailable(cottage.getCottageId(), durationTo))
			{
				JOptionPane.showMessageDialog(null, "This cottage has been reserved for this duration. Please choose a different duration.");
			}
			
			// calculate the price from all parameters and display price in frame
			double price = calculatePrice(cottage , weekFrom, yearFrom, weekTo, yearTo);
			frame.setPricelabel("" + price);
			
			// get the Customer from selected customer in combobox and get discount for customer and display discount amount in frame
			Customer selectedCustomer = allCustomers.get(frame.getSelectedCustomer());
			double discount = getDiscount(selectedCustomer);
			frame.setDiscountLabel("" + discount);
			
			// calculate total price and display in frame
			frame.setTotalPriceLabel("" + calculateTotalPrice(price, discount));		
			
		}
	};
	
	/**
	 * @author ai
	 * @param cottage
	 * @param weekFrom
	 * @param yearFrom
	 * @param weekTo
	 * @param yearTo
	 * @return price based on standard price for selected cottage's type and the rate on each reserved week. Price don't include customer discount
	 */
	private double calculatePrice(Cottage cottage, int weekFrom, int yearFrom, int weekTo, int yearTo)
	{
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
	
	/**
	 * @author ai
	 * @param price
	 * @param discount
	 * @return final total price based on price and discount. Discount is the value presented in percentage, fx. 10 represents 10% discount
	 */
	private double calculateTotalPrice(double price, double discount)
	{
		return price*(1-discount/100);
	}
	
	/**
	 * @author ai
	 * @param customer
	 * @return 10% discount if customer is company
	 */
	private int getDiscount(Customer customer)
	{
		if(customer instanceof Company)
			return 10;
		else
			return 0;
	}
	
	private boolean isAvailable(int cottageId, int weekValue)
	{
		try {
			Reservation rBefore = ReservationConnect.getLastReservationBeforeWeek(cottageId, weekValue);
			Reservation rAfter = ReservationConnect.getNextReservationAfterWeek(cottageId, weekValue);
			if((rBefore == null && rAfter == null) || (rBefore == null && weekValue < rAfter.getWeekFrom()) || (rBefore.getWeekTo() < weekValue && rAfter == null) || (rBefore.getWeekTo() < weekValue && weekValue < rAfter.getWeekFrom()))
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @author ai
	 * @param weekNo
	 * @param yearNo
	 * @return an integer representation of week and year; for example week 12 year 2014 will be converted to 201412. See project document for further explanation
	 */
	private int convertWeekYearToInt(int weekNo, int yearNo)
	{
		return (yearNo * 100 + weekNo);
	}
}
