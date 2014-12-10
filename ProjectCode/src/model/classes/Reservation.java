package model.classes;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import model.CottageConnect;
import controller.RateController;

public class Reservation
{

    private int reservationId;
    private Customer customer;
    private String customerName;
    private Cottage cottage;
    private String cottageName;
    private Calendar reservationDate;
    private int weekFrom;
    private int weekTo;
    private int shortWeekFrom;
    private int shortYearFrom;
    private int shortWeekTo;
    private int shortYearTo;
    private boolean isPaid;
    private double totalPrice;

    public Reservation(int weekFrom, int weekTo)
    {
	this.weekFrom = weekFrom;
	this.weekTo = weekTo;
	this.shortYearFrom = weekFrom / 100;
	this.shortWeekFrom = weekFrom - (shortYearFrom * 100);
	this.shortYearTo = weekTo / 100;
	this.shortWeekTo = weekTo - (shortYearTo * 100);
    }

    public Reservation(Customer customer, Cottage cottage, int weekFrom, int weekTo, boolean isPaid, double totalPrice)
    {
	this(weekFrom, weekTo);
	this.customer = customer;
	this.cottage = cottage;
	this.isPaid = isPaid;
	this.totalPrice = totalPrice;
    }

    public Reservation(int reservationId, Calendar reservationDate, String cottageName, double price, boolean isPaid, int shortWeekFrom, int shortYearFrom, int shortWeekTo, int shortYearTo, String customerName)
    {
	this.reservationId = reservationId;
	this.reservationDate = reservationDate;
	this.cottageName = cottageName;
	this.totalPrice = price;
	this.isPaid = isPaid;
	this.shortWeekFrom = shortWeekFrom;
	this.shortYearFrom = shortYearFrom;
	this.shortWeekTo = shortWeekTo;
	this.shortYearTo = shortYearTo;
	this.customerName = customerName;
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

    public int getShortWeekFrom()
    {
	return shortWeekFrom;
    }

    public int getShortYearFrom()
    {
	return shortYearFrom;
    }

    public int getShortWeekTo()
    {
	return shortWeekTo;
    }

    public int getShortYearTo()
    {
	return shortYearTo;
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
     * @return price based on standard price for selected cottage's type and the
     *         rate on each reserved week. Price don't include customer discount
     * @throws SQLException
     */
    public double calculatePrice() throws SQLException
    {
	// convert weekFrom and weekTo to weekNoFrom, yearNoFrom and weekNoTo,
	// YearNoTo
	// this.convertWeekToshortWeekYear();
	double cottageStandardPrice = CottageConnect.getCottageStandardPrice(cottage.getCottageId());
	;
	double price = 0;
	while (shortYearFrom < shortYearTo)
	{
	    for (int i = shortWeekFrom; i <= 52; i++)
	    {
		double rate = RateController.getRateByWeekNo(i) / 100;
		price += cottageStandardPrice * rate;
	    }
	    shortYearFrom++;
	    shortWeekFrom = 1;
	}
	for (int i = shortWeekFrom; i <= shortWeekTo; i++)
	{
	    double rate = RateController.getRateByWeekNo(i) / 100;
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
	this.totalPrice = price - price * (discount / 100);
    }

    /**
     * @author ai
     * @return an object array
     */
    private Object[] toObjectArray()
    {
	return new Object[] { this.reservationId, this.printDateToString(), this.cottageName, this.totalPrice, this.isPaid, this.shortWeekFrom, this.shortYearFrom, this.shortWeekTo, this.shortYearTo, this.customerName };
    }

    // Convert array list to type Object[][] memberDetails in order to use it as
    // parameter to the constructor of GUIMemberHome
    public static Object[][] convertArrayListToObject(ArrayList<Reservation> reservations)
    {
	Object[][] reservationList = new Object[reservations.size()][];
	for (int i = 0; i < reservations.size(); i++)
	{
	    reservationList[i] = reservations.get(i).toObjectArray();
	}
	return reservationList;
    }

    public String printDateToString()
    {
	String strdate = null;

	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

	if (this.reservationDate != null)
	{
	    strdate = sdf.format(reservationDate.getTime());
	}

	return strdate;
    }
}