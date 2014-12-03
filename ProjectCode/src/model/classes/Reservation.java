package model.classes;

import java.util.Calendar;

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
}