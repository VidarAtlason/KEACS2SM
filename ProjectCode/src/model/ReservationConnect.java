package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
}
