package model.classes;

import java.util.Calendar;

public class Reservation
{

	private int reservationId;
	private Customer customer;
	private Cottage cottage;
	private Calendar reservationDate;
	private int weekFrom;
	private int yearFrom;
	private int weekTo;
	private int yearTo;
	private boolean isPaid;
	private double totalPrice;
	
	public Reservation(int reservationId, int fromWeek, int toWeek)
	{
		
	}
	
	public Reservation(int reservationId, Customer customer, Cottage cottage, Calendar reservationDate, int weekFrom, int yearFrom, int weekTo, int yearTo, boolean isPaid)
	{
		this.reservationId = reservationId;
		this.customer = customer;
		this.cottage = cottage;
		this.reservationDate = reservationDate;
		this.weekFrom = weekFrom;
		this.yearFrom = yearFrom;
		this.weekTo = weekTo;
		this.yearTo = yearTo;
		this.isPaid = isPaid;
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
	
	public int getYearFrom()
	{
		return yearFrom;
	}
	
	public int getWeekTo()
	{
		return weekTo;
	}
	
	public int getYearTo()
	{
		return yearTo;
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	 
	public double getStandardPrice()
	{
		// TODO - implement Reservation.getStandardPrice
		throw new UnsupportedOperationException();
	}

	public double calculatePrice()
	{
		// TODO - implement Reservation.calculatePrice
		throw new UnsupportedOperationException();
	}

	public void sendConfirmationEmail()
	{
		// TODO - implement Reservation.sendConfirmationEmail
		throw new UnsupportedOperationException();
	}

	public void sendReminderEmail()
	{
		// TODO - implement Reservation.sendReminderEmail
		throw new UnsupportedOperationException();
	}

	public boolean isTooOld()
	{
		// TODO - implement Reservation.isTooOld
		throw new UnsupportedOperationException();
	}

}