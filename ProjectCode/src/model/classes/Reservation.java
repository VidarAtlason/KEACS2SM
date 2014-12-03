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
	
	public Reservation(int reservationId, int weekFrom, int weekTo)
	{
		this.reservationId = reservationId;
		this.weekFrom = weekFrom;
		this.weekTo = weekTo;
	}
	public Reservation(int reservationId, Customer customer, Cottage cottage, Calendar reservationDate, int weekFrom, int weekTo, boolean isPaid)
	{
		this(reservationId,weekFrom,weekTo);
		this.customer = customer;
		this.cottage = cottage;
		this.reservationDate = reservationDate;
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