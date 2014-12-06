package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.LoginWindow;
import model.UserConnect;
import model.classes.Cottage;
import model.classes.CottageType;
import model.classes.Zip;

public class GuiController {
	ReservationController resController;
	CustomerController custController;
	RateController rateController;
	LoginController loginController;
	MainWindowController mainController;
	public GuiController(){
		loginController = new LoginController();
		resController = new ReservationController();
		custController = new CustomerController();
		loginController.showFrame(true);
		mainController = new MainWindowController();
		setListeners();
	}
	public void showReservation(Cottage cottage,int startingWeek){
		resController.showFrame(cottage,startingWeek);
		
	}
	
	public void setListeners(){
		custController.addListener(showReservation);
		resController.addListener(showCustomerFrame);
		mainController.addMouseListener(doubleClickListener);
		loginController.addActionListener(loginListener);
	}
	public ActionListener loginListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (loginController.loginCorrect())
			{
				showMainWindow();
				loginController.showFrame(false);//Hide LoginWindow
				
				//Add login to log in database
				try {UserConnect.addToLog(loginController.getUsername());} 
				catch (SQLException e1) {e1.printStackTrace();}
			}
			else{
				JOptionPane.showMessageDialog(null, "Login Incorrect", "Login Incorrect", JOptionPane.WARNING_MESSAGE);
				loginController.resetInformation();//Clear PasswordBox and set Focus
			}
		}

		private void showMainWindow() {
			mainController.showFrame(true);
		}
	};
	public ActionListener showReservation = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			custController.showFrame(false);
			resController.populateCustomers();
			resController.showFrame(true);
		}
	};
	public ActionListener showCustomerFrame = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			custController.showFrame(true);
			resController.showFrame(false);
		}
	};
	private MouseAdapter doubleClickListener = new MouseAdapter() {
	    public void mousePressed(MouseEvent me) {
	        JTable table =(JTable) me.getSource();
	        Point p = me.getPoint();
	        int row = table.rowAtPoint(p);
	        int col = table.columnAtPoint(p);
	        if (me.getClickCount() == 2) {
	            showReservation((Cottage) table.getModel().getValueAt(row, col),col);
	        }
	    }
	};
}
