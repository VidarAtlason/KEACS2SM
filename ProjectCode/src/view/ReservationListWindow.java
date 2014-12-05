package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controller.ReservationController;

/**
 * 
 * @author ai
 * This is a test window - supposedly to check that a new reservation is added.
 * This may later be expanded to a real tab in the application to show all reservations
 *
 */
public class ReservationListWindow extends JFrame
{
	private JTable table;
	private JScrollPane scrollPane;
	public ReservationListWindow() 
	{
		this.setTitle("All Reservations");
		this.setSize(new Dimension(1800,600));
		
		String[] columnNames = {"Id", "Reservation date", "Cottage", "Price", "Paid", "From Week", "Year", "To Week", "Year", "Customer"};
		Object[][] details = new ReservationController().getAllReservationsObject();
		
		table = new JTable(details,columnNames);
		scrollPane = new JScrollPane(table);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
