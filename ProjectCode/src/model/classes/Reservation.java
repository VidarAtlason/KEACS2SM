package model.classes;

import java.sql.SQLException;
import java.util.Calendar;

import model.CottageConnect;
import controller.RateController;

public class Reservation
{

	private int reservationId;
	private Customer customer;
	private Cottage cottage;
	private Calendar reservationDate;
	private int weekFrom;
	private int weekTo;
	private boolean isPaid;
	private double totalPrice;
	
	public Reservation(int weekFrom, int weekTo)
	{
		this.weekFrom = weekFrom;
		this.weekTo = weekTo;
	}
	public Reservation(Customer customer, Cottage cottage, int weekFrom, int weekTo, boolean isPaid, double totalPrice)
	{
		this(weekFrom,weekTo);
		this.customer = customer;
		this.cottage = cottage;
		this.isPaid = isPaid;
		this.totalPrice = totalPrice;
	}
	
	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	}
	
	public void setCottage(Cottage cottage) 
	{
		this.cottage = cottage;
	}
	
	public void setIsPaid(boolean isPaid)
	{
		this.isPaid = isPaid;
	}
	
	public void setTotalPrice(double totalPrice) 
	{
		this.totalPrice = totalPrice;
	}
	
	public int getReservationId()
	{
		return reservationId;
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public Cottage getCottage()
	{
		return cottage;
	}
	
	public Calendar getReservationDate()
	{
		return reservationDate;
	}
	
	public int getWeekFrom()
	{
		return weekFrom;
	}
	
	public int getWeekTo()
	{
		return weekTo;
	}
	
	public boolean isPaidReservation()
	{
		return isPaid;
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	
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
	public double calculatePrice() throws SQLException
	{
		// convert weekFrom and weekTo to weekNoFrom, yearNoFrom and weekNoTo, YearNoTo
		// this should be extracted to a different method
		int yearNoFrom = weekFrom/100;
		int weekNoFrom = weekFrom - (yearNoFrom * 100);
		int yearNoTo = weekTo/100;
		int weekNoTo = weekTo - (yearNoTo * 100);
		
		double cottageStandardPrice = CottageConnect.getCottageStandardPrice(cottage.getCottageId());;
		double price = 0;
		while(yearNoFrom < yearNoTo)
		{
			for (int i = weekNoFrom; i <= 52; i++)
			{
				double rate = RateController.getRateByWeekNo(i)/100;
				price += cottageStandardPrice * rate;
			}
			yearNoFrom++;
			weekNoFrom = 1;
		}
		for (int i = weekNoFrom; i <= weekNoTo; i++)
		{
			double rate = RateController.getRateByWeekNo(i)/100;
			price += cottageStandardPrice * rate;
		}
		return price;
	}
	
	/**
	 * @author ai
	 * @throws SQLException 
	 */
	public void calculateTotalPrice() throws SQLException
	{
		double price = this.calculatePrice();
		double discount = this.customer.getDiscount();
		this.totalPrice = price - price * (discount/100);
	}
}