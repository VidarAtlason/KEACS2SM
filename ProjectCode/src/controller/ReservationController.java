package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import model.CustomerConnect;
import model.ReservationConnect;
import model.classes.Cottage;
import model.classes.Customer;
import model.classes.Reservation;
import view.CottageWindow;
import view.ReservationListWindow;

public class ReservationController
{
	private CottageWindow frame;
	private List<Customer> allCustomers = new ArrayList<Customer>(); 
	private Object[] customersArray;
	private Cottage cottage; 
	private Object[][] allReservations;
	
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
	
	public Object[][] getAllReservationsObject()
	{
		this.allReservations = Reservation.convertArrayListToObject(this.getAllReservations());
		return this.allReservations;
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
	
	public ArrayList<Reservation> getAllReservations()
	{
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try 
		{
			reservations = ReservationConnect.getAllReservation();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservations;
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
			// Add customer button
			if(e.getSource() == frame.btnNewCustomer)
			{
				new CustomerController();
			}
			
			else
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
				Reservation newReservation = new Reservation(durationFrom, durationTo);
				newReservation.setCottage(cottage);
				newReservation.setIsPaid(frame.isPaidReservation());
				try 
				{
					if(!cottage.isAvailable(durationFrom, durationTo))
					{
						JOptionPane.showMessageDialog(null, "This cottage has been reserved for this duration. Please choose a different duration.");
					}
					else
					{
						// calculate the price from all parameters and display price in frame
						double price = 0;
						price = newReservation.calculatePrice();
						frame.setPricelabel("" + price);

						// get the Customer from selected customer in combobox and get discount for customer and display discount amount in frame
						Customer selectedCustomer = allCustomers.get(frame.getSelectedCustomer());
						newReservation.setCustomer(selectedCustomer);
						double discount = selectedCustomer.getDiscount();
						frame.setDiscountLabel("" + discount);
						
						// calculate total price and display in frame
						newReservation.calculateTotalPrice();
						frame.setTotalPriceLabel("" + newReservation.getTotalPrice());		
						
						// Save button
						if(e.getSource() == frame.btnSave)
						{
							try 
							{
								ReservationConnect.insertNewReservation(newReservation);
								new ReservationListWindow();
							} catch (SQLException e1) 
							{
								e1.printStackTrace();
							}
						}									
					}
				} catch (Exception e2) 
				{
					e2.printStackTrace();
				}
			}		
		}
	};
	
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
