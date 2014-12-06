package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;

import model.CustomerConnect;
import model.classes.Company;
import model.classes.Customer;
import model.classes.PrivateCustomer;
import view.CustomerWindow;

public class CustomerController {
	private final CustomerWindow frame = new CustomerWindow();
	
	public CustomerController() {
	    frame.addButtonActionListener(listener);
	    
	  }
	public void showFrame(boolean show){
		frame.setVisible(show);
	}
	private ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	if (frame.isCompany())
        	{
        		Company newCompany = frame.getCompany();
        		try {
					CustomerConnect.addNewCustomer(newCompany);
					System.out.println("Company Added");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
        		
        	}
        	else {
        		PrivateCustomer newCustomer = frame.getCustomer();
        		try {
					CustomerConnect.addNewCustomer(newCustomer);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	showFrame(false);        	
        }
      };

	public void addListener(ActionListener showReservation) {
		frame.addListenerToSave(showReservation);
		
	}
}
