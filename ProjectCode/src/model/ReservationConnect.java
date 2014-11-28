package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.classes.Cottage;
import model.classes.Customer;
import model.classes.Reservation;

public class ReservationConnect
{
	public static void insertNewReservation()//Calendar reservationDate, int weekFrom, int yearFrom, int weekTo, int YearTo, boolean isPaid, double price, Customer customer, Cottage cottage)
	{
		String sql = "insert into zip(zipCode,city) values (2400,'Norrebro'),(2450,'Copenhagen SV'),(3520,'Farum');";
		Connection conn = DBConnect.getConnection();
		try
		{
			PreparedStatement p = conn.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
