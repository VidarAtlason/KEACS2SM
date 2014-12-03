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
	
	public Reservation(int reservationId, Customer customer, Cottage cottage, Calendar reservationDate, int weekFrom, int yearFrom, int weekTo, int yearTo, boolean isPaid)
	{
		this.reservationId = reservationId;
		this.customer = customer;
		this.cottage = cottage;
		this.reservationDate = reservationDate;
		this.weekFrom = convertWeekYearToInt(weekFrom, yearFrom);
		this.weekTo = convertWeekYearToInt(weekTo, yearTo);
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
	
	/**
	 * @author ai
	 * @param weekNo
	 * @param yearNo
	 * @return and integer representation of week and year; for example week 12 year 2014 will be converted to 201412. See project document for further explanation
	 */
	public int convertWeekYearToInt(int weekNo, int yearNo)
	{
		return (yearNo * 100 + weekNo);
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