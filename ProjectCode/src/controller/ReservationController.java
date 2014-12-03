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
		frame.addFrameActionListener(listener);
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
		public void actionPerformed(ActionEvent e)
		{
			// update of selected week/year to make sure that user cannot choose a negative time window
			int weekFrom = frame.getSelectedWeekFrom(); 
			int weekTo = frame.getSelectedWeekTo();
			int yearFrom = frame.getSelectedYearFrom();
			int yearTo = frame.getSelectedYearTo();
			if(yearFrom > yearTo)
			{
				frame.setSelectedYearTo(yearFrom - Calendar.getInstance().get(Calendar.YEAR)); 
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
			if(!isAvailable(cottage.getCottageId(), durationFrom, durationTo))
			{
				JOptionPane.showMessageDialog(null, "This cottage has been reserved for this duration. Please choose a different duration.");
			}
			else
			{
				// calculate the price from all parameters and display price in frame
				double price = 0;
				try {
					price = calculatePrice(cottage, frame.getSelectedWeekFrom(), frame.getSelectedYearFrom(), frame.getSelectedWeekTo(), frame.getSelectedYearTo());
					frame.setPricelabel("" + price);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				// get the Customer from selected customer in combobox and get discount for customer and display discount amount in frame
				Customer selectedCustomer = allCustomers.get(frame.getSelectedCustomer());
				double discount = getDiscount(selectedCustomer);
				frame.setDiscountLabel("" + discount);
				
				// calculate total price and display in frame
				double totalPrice = calculateTotalPrice(price, discount);
				frame.setTotalPriceLabel("" + totalPrice);		
				
				// Save function
				if(e.getSource() == frame.btnSave)
				{
					Reservation r = new Reservation(selectedCustomer, cottage, durationFrom, durationTo, frame.isPaidReservation(), totalPrice);
					try 
					{
						ReservationConnect.insertNewReservation(r);
						JOptionPane.showMessageDialog(null, 
								"The " + cottage.getCottageName() + " cottage has been reserved by " + selectedCustomer.getCustomerName() + " from week " + frame.getSelectedWeekFrom() + "/" + frame.getSelectedYearFrom() + " to week " + frame.getSelectedWeekTo() + "/" + frame.getSelectedYearTo());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}			
			}
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
	 * @throws SQLException 
	 */
	private double calculatePrice(Cottage cottage, int weekFrom, int yearFrom, int weekTo, int yearTo) throws SQLException
	{
		double cottageStandardPrice = CottageConnect.getCottageStandardPrice(cottage.getCottageId()); 
		double totalPrice = 0;
		while(yearFrom < yearTo)
		{
			for (int i = weekFrom; i <= 52; i++)
			{
				double rate = RateController.getRateByWeekNo(i)/100; //RateConnect.getRate(i) / 100;
				totalPrice += cottageStandardPrice * rate;
			}
			yearFrom++;
			weekFrom = 1;
		}
		for (int i = weekFrom; i <= weekTo; i++)
		{
			double rate = RateController.getRateByWeekNo(i)/100;
			totalPrice += cottageStandardPrice * rate;
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
	
	private boolean isAvailable(int cottageId, int fromWeek, int toWeek)
	{
		try 
		{
			if(ReservationConnect.foundReservation(cottageId, fromWeek, toWeek))
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
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
