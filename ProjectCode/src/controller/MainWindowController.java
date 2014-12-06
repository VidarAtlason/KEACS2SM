package controller;

import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import view.MainWindow;
import model.CottageConnect;
import model.ReservationConnect;
import model.classes.Cottage;
import model.classes.Reservation;

public class MainWindowController {

	private MainWindow mainWindow;
	public MainWindowController(){
		mainWindow = new MainWindow();
		populateTable();
		try {
			List<Reservation> reservations = ReservationConnect.getAllReservations(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void populateTable(){
		JTable table = mainWindow.getTable();
		
		DefaultTableModel model = buildTableModel();
		table.setModel(model);
		
		TableColumn column = null;
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setMinWidth(100); //third column is bigger
		}
	}
	public DefaultTableModel buildTableModel() {

		List<Cottage> cottages = null;
		
		try {
			cottages = CottageConnect.getAllCottages(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = 52;
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add("Week "+column);
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        
        
        for(int i = 0 ;i<cottages.size();i++)
        {
        	Vector<Object> vector = new Vector<Object>();
        	for (int column = 0; column < columnCount; column++) {
        		vector.add(cottages.get(i));
    	    }
        	data.add(vector);
        	
        }
        return new DefaultTableModel(data,columnNames);
	}
	public void addMouseListener(MouseAdapter adapter){
		mainWindow.addMouseAdapterToTable(adapter);
	}
	public void showFrame(boolean b) {
		mainWindow.setVisible(true);
	}
}
