package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.classes.Company;
import model.classes.Cottage;
import model.classes.CottageType;
import model.classes.Customer;
import model.classes.Zip;
import view.CottageWindow;
import view.CustomerWindow;

public class CottageController
{
	private final CottageWindow frame = new CottageWindow();
	
	public CottageController(Cottage cottage) 
	{
		frame.setTextCottageInfo(cottage);
	}
	//  methods
	 
	public List<Customer> getListCustomer()
	{
		return null;
	}
}
