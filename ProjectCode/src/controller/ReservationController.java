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
import view.ReservationListWindow;

public class ReservationController
{
	private CottageWindow frame;
	private List<Customer> allCustomers = new ArrayList<Customer>(); 
	private Cottage cottage; 
	
	public ReservationController()
	{
		try {
			allCustomers = CustomerConnect.getAllCustomersAndCompanies(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new CottageWindow();
		frame.addFrameActionListener(listener);		
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
					frame.setPricelabel("" + price + " DKK");

					// get the Customer from selected customer in combobox and get discount for customer and display discount amount in frame
					Customer selectedCustomer = allCustomers.get(frame.getSelectedCustomer());
					newReservation.setCustomer(selectedCustomer);
					double discount = selectedCustomer.getDiscount();
					frame.setDiscountLabel("" + discount + " %");
					
					// calculate total price and display in frame
					newReservation.calculateTotalPrice();
					frame.setTotalPriceLabel("" + newReservation.getTotalPrice() + " DKK");		
					
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
	public void showFrame(Cottage cottage,int startingWeek) {
		frame.setTextCottageInfo(cottage);
		this.cottage = cottage;
		frame.setSelectedWeekFrom(startingWeek);
		frame.setSelectedWeekTo(startingWeek);
		frame.setVisible(true);
	}
	public void showFrame(boolean visible)
	{
		frame.setVisible(visible);
	}

	public void addListener(ActionListener showCustomerFrame) {
		frame.addToAddCustomerButton(showCustomerFrame);
		
	}
	public void populateCustomers(){
		try {
			frame.populateCustomers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
