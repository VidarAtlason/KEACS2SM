package view;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import controller.CottageController;
import model.classes.Cottage;
import model.classes.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;


public class CottageWindow extends JFrame
{
	private JComboBox cbWeekFrom;
	private JComboBox cbWeekTo;
	JComboBox cbYearFrom;
	JComboBox cbYearTo;
	private JTextArea txtaCottageInfo;
	private JComboBox cbCustomer;
	private JLabel lblPrice;
	private JLabel lblDiscount;
	private JLabel lblTotalPrice;
	private JButton btnNewCustomer;
	private JButton btnSave;
	private JCheckBox chbPaid;
	
	public CottageWindow() {
		setTitle("ReserveCottage");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtaCottageInfo = new JTextArea();
		txtaCottageInfo.setRows(8);
		txtaCottageInfo.setBounds(45, 30, 378, 100);
		getContentPane().add(txtaCottageInfo);
		
		JLabel lblCottageInformation = new JLabel("Cottage Information");
		lblCottageInformation.setBounds(47, 13, 125, 16);
		getContentPane().add(lblCottageInformation);
		
		cbCustomer = new JComboBox(new CottageController().getCustomersArray());
		cbCustomer.setBounds(124, 143, 170, 22);
		getContentPane().add(cbCustomer);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(44, 146, 56, 16);
		getContentPane().add(lblCustomer);
		
		// Add list of weekNo to combobox
		String[] weekNo = new String[52];
		for (int i = 0; i < weekNo.length; i++)
		{
			weekNo[i] = "" + (i + 1);
		}
		
		// Add list of years to combobox - 
		String [] yearNo = new String[10];
		for (int i = 0; i < yearNo.length; i++)
		{
			yearNo[i] = "" + (i+ Calendar.getInstance().get(Calendar.YEAR));
		}
		JLabel lblWeekfrom = new JLabel("WeekFrom:");
		lblWeekfrom.setBounds(45, 185, 71, 16);
		getContentPane().add(lblWeekfrom);
		
		cbWeekFrom = new JComboBox(weekNo);
		cbWeekFrom.setBounds(124, 182, 56, 22);
		getContentPane().add(cbWeekFrom);
		
		JLabel lblWeekto = new JLabel("WeekTo:");
		lblWeekto.setBounds(202, 185, 71, 16);
		getContentPane().add(lblWeekto);
		
		cbWeekTo = new JComboBox(weekNo);
		cbWeekTo.setBounds(281, 182, 56, 22);
		getContentPane().add(cbWeekTo);
		
		JLabel lblYearFrom = new JLabel("YearFrom");
		lblYearFrom.setBounds(45, 224, 71, 16);
		getContentPane().add(lblYearFrom);
		
		cbYearFrom = new JComboBox(yearNo);
		cbYearFrom.setBounds(124, 221, 56, 22);
		getContentPane().add(cbYearFrom);
		
		JLabel lblYearto = new JLabel("YearTo");
		lblYearto.setBounds(202, 224, 71, 16);
		getContentPane().add(lblYearto);
		
		cbYearTo = new JComboBox(yearNo);
		cbYearTo.setBounds(281, 221, 56, 22);
		getContentPane().add(cbYearTo);

		JLabel lblPriceStatic = new JLabel("Price:");
		lblPriceStatic.setBounds(45, 263, 71, 16);
		getContentPane().add(lblPriceStatic);
		
		lblPrice = new JLabel("0 DKK");
		lblPrice.setBounds(124, 263, 144, 16);
		getContentPane().add(lblPrice);
		
		chbPaid = new JCheckBox("Paid");
		chbPaid.setBounds(299, 320, 56, 25);
		getContentPane().add(chbPaid);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(0, 377, 97, 25);
		getContentPane().add(btnSave);
		
		JLabel lblDiscountStatic = new JLabel("Discount:");
		lblDiscountStatic.setBounds(45, 292, 71, 16);
		getContentPane().add(lblDiscountStatic);
		
		lblDiscount = new JLabel("0%");
		lblDiscount.setBounds(124, 292, 144, 16);
		getContentPane().add(lblDiscount);
		
		JLabel lblTotalPriceStatic = new JLabel("Total Price:");
		lblTotalPriceStatic.setBounds(45, 324, 71, 16);
		getContentPane().add(lblTotalPriceStatic);
		
		lblTotalPrice = new JLabel("0 DKK");
		lblTotalPrice.setBounds(124, 324, 144, 16);
		getContentPane().add(lblTotalPrice);
		
		btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.setBounds(306, 143, 117, 25);
		getContentPane().add(btnNewCustomer);

		this.setSize(new Dimension(479, 449));
		
		this.setVisible(true);
	}
	
	// method
	public void setTextCottageInfo(Cottage cottage)
	{
		String address = cottage.getStreet() + " " + cottage.getHouseNumber() + ", " + cottage.getZip().getZipCode() + " " + cottage.getZip().getCity();
		String cottagetype = cottage.getCottageType().getTypeName();
		String noOfBeds = "" + cottage.getCottageType().getNoOfBeds();
		String standardPrice = "" + cottage.getCottageType().getStandardPrice();
		String fullText = cottage.getCottageName() + 
				"\nAddress: " + address + 
				"\nCottage Type: " + cottagetype + 
				"\nBeds: " + noOfBeds + 
				"\nStandard price per week: " + standardPrice;
		txtaCottageInfo.setText(fullText);
	
	}
	
	// get selected items in combobox
	public int getSelectedWeekFrom()
	{
		return cbWeekFrom.getSelectedIndex() + 1;
	}
	
	public int getSelectedWeekTo()
	{
		return cbWeekTo.getSelectedIndex() + 1;
	}
	
	public int getSelectedYearFrom()
	{
		return cbYearFrom.getSelectedIndex() + 1 + Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public int getSelectedYearTo()
	{
		return cbYearTo.getSelectedIndex() + 1 + Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public int getSelectedCustomer()
	{
		return cbCustomer.getSelectedIndex();
	}
	
	// set selected item in combobox
	public void setSelectedWeekFrom(int index)
	{
		cbWeekFrom.setSelectedIndex(index);
	}
	
	public void setSelectedWeekTo(int index)
	{
		cbWeekTo.setSelectedIndex(index);
	}
	
	public void setSelectedYearFrom(int index)
	{
		cbYearFrom.setSelectedIndex(index);
	}
	
	public void setSelectedYearTo(int index)
	{
		cbYearTo.setSelectedIndex(index);
	}
	
	// set price-related labels
	public void setPricelabel(String s)
	{
		lblPrice.setText(s);
	}
	
	public void setDiscountLabel(String s)
	{
		lblDiscount.setText(s);
	}
	
	public void setTotalPriceLabel(String s)
	{
		lblTotalPrice.setText(s);
	}
	
	// action listener
	public void addCbWeekFromActionListener(ActionListener actionListener) 
	{
		cbWeekFrom.addActionListener(actionListener);
		cbWeekTo.addActionListener(actionListener);
		cbYearFrom.addActionListener(actionListener);
		cbYearTo.addActionListener(actionListener);
	}
	

}
