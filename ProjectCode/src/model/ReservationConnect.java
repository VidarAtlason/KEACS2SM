package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

import model.classes.Cottage;
import model.classes.Customer;
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

		if(r.getCustomer().isCompany())
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
	 * 
	 * @param cottageId
	 * @param weekNo int representation of week no (fx. 201416 - week no 16 year 2014)
	 * @return the reservation for this cottageId that has the latest weekTo value before this weekNo 
	 * @throws SQLException
	 * @Deprecated
	 */
	public static Reservation getLastReservationBeforeWeek(int cottageId, int weekNo) throws SQLException
	{
		String sql = "SELECT * FROM reservation where cottage_fk = ? and durationTo <= ? order by durationTo desc limit 1";
		Connection conn = DBConnect.getConnection();
		
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, cottageId);
		p.setInt(2, weekNo);
		
		ResultSet rs = p.executeQuery();
		if(rs.next())
		{
			Reservation r = new Reservation(rs.getInt("durationFrom"), rs.getInt("durationTo"));
			if(conn != null)
			{
				conn.close();
			}
			return r;
		}
		else
			if(conn != null)
			{
				conn.close();
			}
			return null;		
	}
	
	/**
	 * 
	 * @param cottageId
	 * @param weekNo int representation of week no (fx. 201416 - week no 16 year 2014)
	 * @return the reservation for this cottageId that has the earliest WeekFrom after this WeekNo
	 * @throws SQLException
	 * @Deprecated
	 */
	public static Reservation getNextReservationAfterWeek(int cottageId, int weekNo) throws SQLException
	{
		String sql = "SELECT * FROM reservation where cottage_fk = ? and durationFrom >= ? order by durationFrom limit 1";
		Connection conn = DBConnect.getConnection();
		
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, cottageId);
		p.setInt(2, weekNo);
		
		ResultSet rs = p.executeQuery();
		if(rs.next())
		{
			Reservation r = new Reservation(rs.getInt("durationFrom"), rs.getInt("durationTo"));
			if(conn != null)
			{
				conn.close();
			}
			return r;
		}
		else
			if(conn != null)
			{
				conn.close();
			}
			return null;		
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
}
