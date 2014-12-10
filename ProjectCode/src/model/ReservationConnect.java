package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.classes.Reservation;

/**
 * 
 * @author ale
 *
 */
public class ReservationConnect
{
    private static List<Reservation> staticReservations = null;

    public static List<Reservation> getAllReservations(boolean refresh) throws SQLException
    {
	if (!refresh)
	    if (staticReservations != null)
		return staticReservations;
	String sql = "";
	Connection conn = DBConnect.getConnection();

	List<Reservation> reservations = new ArrayList<Reservation>();
	sql = "Select id, reserveDate, durationFrom, durationTo, paid, price, COALESCE(privatecustomer_fk, company_fk) as customerId, cottage_fk from reservation order by id;";

	PreparedStatement p = conn.prepareStatement(sql);
	ResultSet rs = p.executeQuery();

	while (rs.next())
	{
	    int reservationId = rs.getInt("id");

	    Calendar reservationDate = Calendar.getInstance();
	    reservationDate.setTime(rs.getDate("reserveDate"));

	    int durFrom = rs.getInt("durationFrom");
	    int shortYearFrom = durFrom / 100;
	    int shortWeekFrom = durFrom - (shortYearFrom * 100);

	    int durTo = rs.getInt("durationTo");
	    int shortYearTo = durTo / 100;
	    int shortWeekTo = durTo - (shortYearTo * 100);

	    boolean isPaid = rs.getBoolean("paid");
	    double totalPrice = rs.getDouble("price");

	    String customerName = Integer.toString(rs.getInt("customerId"));

	    String cottageName = CottageConnect.getCottageName(rs.getInt("cottage_fk"));

	    Reservation reservation = new Reservation(reservationId, reservationDate, cottageName, totalPrice, isPaid, shortWeekFrom, shortYearFrom, shortWeekTo, shortYearTo, customerName);
	    reservations.add(reservation);
	}
	if (conn != null)
	{
	    conn.close();
	}
	return reservations;
    }

    /**
     * @author ai
     * @param Reservation
     *            r
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

	if (r.getCustomer().isCompanyCustomer())
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

	if (conn != null)
	{
	    conn.close();
	}
    }

    /**
     * @author ai
     * @param cottageId
     * @param from
     *            must be before to
     * @param to
     *            must be after from
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
	if (rs.next())
	    return true;
	else
	    return false;
    }
}
