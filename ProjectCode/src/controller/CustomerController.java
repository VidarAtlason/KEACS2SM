package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.classes.Company;
import model.classes.Customer;
import view.CustomerWindow;

public class CustomerController {
	private final CustomerWindow frame = new CustomerWindow();
	
	public CustomerController() {
	    frame.addButtonActionListener(
	      new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	if (frame.isCompany())
	        	{
	        		Company newCompany = frame.getCompany();
	        		//Martins addCompany method from CompanyDB
	        		
	        	}
	        	else {
	        		Customer newCustomer = frame.getCustomer();
	        	}
	        	showFrame(false);
	        }
	      }
	    );
	    
	  }
	public void showFrame(boolean show){
		frame.setVisible(show);
	}
}
