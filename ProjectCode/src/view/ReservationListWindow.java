package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ReservationConnect;
import model.classes.Reservation;
import controller.ReservationController;

/**
 * 
 * @author ai
 * This is a test window - supposedly to check that a new reservation is added. Refactoring might be required
 * This may later be expanded to a real tab in the application to show all reservations
 *
 */
public class ReservationListWindow extends JFrame
{
	private JTable table;
	private JScrollPane scrollPane;
	public ReservationListWindow() throws SQLException 
	{
		this.setTitle("All Reservations");
		this.setSize(new Dimension(1800,600));

		String[] columnNames = {"Id", "Reservation date", "Cottage", "Price", "Paid", "From Week", "Year", "To Week", "Year", "Customer"};
		Object[][] details = getAllReservations();
		
		table = new JTable(details,columnNames);
		scrollPane = new JScrollPane(table);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private Object[][] getAllReservations() throws SQLException
	{
	    ArrayList<Reservation> reservations = (ArrayList<Reservation>) ReservationConnect.getAllReservations(false);
	    Object[][] res = Reservation.convertArrayListToObject(reservations);
	    return res;
	}
}
