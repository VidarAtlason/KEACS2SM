package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import model.classes.Reservation;

/**
 * 
 * @author ale
 *
 */
public class ReservationConnect
{
	/**
	 * @author ai
	 * @param Reservation r
	 * @throws SQLException
	 */
	public static void insertNewReservation(Reservation r) throws SQLException
	{
		String sql = "INSERT INTO reservation(`reserveDate`, `durationFrom`, `durationTo`, `paid`, `price`, `privatecustomer_fk`, `company_fk`, `cottage_fk`) VALUES (?,?,?,?,?,?,?,?);";
		Connection conn = DBConnect.getConnection();
		
		PreparedStatement p = conn.prepareStatement(sql);
		p.setDate(1, new java.sql.Date(System.currentTimeMillis()));
		p.setInt(2, r.getWeekFrom());
		p.setInt(3, r.getWeekTo());
		p.setBoolean(4, r.isPaidReservation());
		p.setDouble(5, r.getTotalPrice());

		if(r.getCustomer().isCompanyCustomer())
		{
			p.setNull(6, java.sql.Types.NULL);
			p.setInt(7, r.getCustomer().getCustomerId());
		}
		else
		{
			p.setInt(6, r.getCustomer().getCustomerId());
			p.setNull(7, java.sql.Types.NULL);
		}
		
		p.setInt(8, r.getCottage().getCottageId());
		
		p.executeUpdate();
		
		if(conn != null)
		{
			conn.close();
		}
	}
	
	/**
	 * @author ai
	 * @param cottageId
	 * @param from must be before to
	 * @param to must be after from
	 * @return if there is any reservation in between period from and to
	 */
	public static boolean foundReservation(int cottageId, int from, int to) throws SQLException
	{
		String sql = "select * from reservation where cottage_fk = ? and durationTo >= ? and durationFrom <= ?; ";
		Connection conn = DBConnect.getConnection();
		
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, cottageId);
		p.setInt(2, from);
		p.setInt(3, to);
		
		ResultSet rs = p.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
	}
	
	public static ArrayList<Reservation> getAllReservation() throws SQLException
	{
		String sql = "CALL GetAllReservations;";
		Connection conn = DBConnect.getConnection();
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		while(rs.next())
		{
			int id = rs.getInt("id");
			Date reservationDate = rs.getDate("reserveDate");
			String cottageName = rs.getString("cottageName");
			double price = rs.getDouble("price");
			boolean isPaid = rs.getBoolean("paid");
			int weekFrom = rs.getInt("durationFrom");
			int weekTo = rs.getInt("durationTo");
			int shortYearFrom = weekFrom/100;
			int shortWeekFrom = weekFrom - (shortYearFrom * 100);
			int shortYearTo = weekTo/100;
			int shortWeekTo = weekTo - (shortYearTo * 100);
			String pcfName = rs.getString("fName");
			String pclName = rs.getString("lName");
			String cName = rs.getString("companyName");
			String customerName;
			if(pcfName != null && pclName != null)
			{
				customerName = pcfName + " " + pclName;
			}
			else
			{
				customerName = cName;
			}
			Reservation newReservation = new Reservation(id, DateToCalendar(reservationDate), cottageName, price, isPaid, shortWeekFrom, shortYearFrom, shortWeekTo, shortYearTo, customerName);
			reservations.add(newReservation);			
		}
		return reservations;
	}
	
	private static Calendar DateToCalendar(Date date)
	{ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}
}
