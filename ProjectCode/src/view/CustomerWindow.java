package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;











import model.classes.Company;
import model.classes.Customer;
import model.classes.PrivateCustomer;
import model.classes.Zip;


//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.util.Calendar;


public class CustomerWindow extends JFrame {
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtCountryCode;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JTextField txtStreetName;
	private JTextField txtStreetNumber;
	private JTextField txtCity;
	private JTextField txtZip;
	private JTextField txtPaymentInfo;
	private JTextField txtBirthDate;
	private JTextField textField_1;
	private JTextField txtCompanyName;
	private JTextField txtCVR;
	private JTextField txtFaxNo;
	private JTextField txtContactPersonName;
	private JTextField txtContactPhoneNo;
	private JPanel company;
	private final JPanel private1;
	private JComboBox cbGender;
	private JButton btnSave;
	final JCheckBox chbCompany;
	public CustomerWindow() {
		setTitle("Customer");
		this.setSize(476, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		txtCountryCode = new JTextField();
		txtCountryCode.setBounds(114, 83, 336, 22);
		txtCountryCode.setColumns(10);
		getContentPane().add(txtCountryCode);
		
		JLabel lblCountryCode = new JLabel("Country Code:");
		lblCountryCode.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCountryCode.setBounds(12, 86, 90, 16);
		getContentPane().add(lblCountryCode);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(309, 83, 141, 22);
		txtPhoneNumber.setColumns(10);
		getContentPane().add(txtPhoneNumber);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(215, 86, 97, 16);
		getContentPane().add(lblPhoneNumber);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(114, 48, 336, 22);
		txtEmail.setColumns(10);
		getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(12, 51, 90, 16);
		getContentPane().add(lblEmail);
		
		txtStreetName = new JTextField();
		txtStreetName.setBounds(114, 119, 336, 22);
		txtStreetName.setColumns(10);
		getContentPane().add(txtStreetName);
		
		JLabel lblStreetName = new JLabel("Street Name:");
		lblStreetName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStreetName.setBounds(12, 122, 90, 16);
		getContentPane().add(lblStreetName);
		
		txtStreetNumber = new JTextField();
		txtStreetNumber.setBounds(383, 118, 67, 22);
		txtStreetNumber.setColumns(10);
		getContentPane().add(txtStreetNumber);
		
		JLabel lblStreetNumber = new JLabel("Street Number:");
		lblStreetNumber.setBounds(288, 122, 97, 16);
		getContentPane().add(lblStreetNumber);
		
		txtCity = new JTextField();
		txtCity.setBounds(114, 155, 336, 22);
		txtCity.setColumns(10);
		getContentPane().add(txtCity);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setBounds(288, 158, 97, 16);
		getContentPane().add(lblZipCode);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Information:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(11, 399, 130, 16);
		getContentPane().add(lblNewLabel_1);
		
		txtPaymentInfo = new JTextField();
		txtPaymentInfo.setBounds(153, 396, 297, 22);
		getContentPane().add(txtPaymentInfo);
		txtPaymentInfo.setColumns(10);
		
		chbCompany = new JCheckBox("Company");
		chbCompany.setBounds(364, 442, 86, 25);
		getContentPane().add(chbCompany);
		chbCompany.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (chbCompany.isSelected())
				{
					company.setVisible(true);
					private1.setVisible(false);
				}
				else if (!chbCompany.isSelected())
				{
					company.setVisible(false);
					private1.setVisible(true);
				}
				
			}
		});
		
		btnSave = new JButton("Save");
		btnSave.setBounds(0, 447, 85, 29);
		getContentPane().add(btnSave);
		
		txtZip = new JTextField();
		txtZip.setBounds(351, 154, 99, 22);
		txtZip.setColumns(10);
		getContentPane().add(txtZip);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCountry.setBounds(12, 158, 90, 16);
		getContentPane().add(lblCountry);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(114, 13, 336, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setBounds(12, 16, 90, 16);
		getContentPane().add(lblId);
		
		company = new JPanel();
		company.setBounds(0, 193, 458, 193);
		getContentPane().add(company);
		company.setLayout(null);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCompanyName.setBounds(13, 24, 102, 16);
		company.add(lblCompanyName);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setBounds(117, 21, 333, 22);
		company.add(txtCompanyName);
		txtCompanyName.setColumns(10);
		
		JLabel lblCvr = new JLabel("CVR");
		lblCvr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCvr.setBounds(13, 56, 102, 16);
		company.add(lblCvr);
		
		txtCVR = new JTextField();
		txtCVR.setColumns(10);
		txtCVR.setBounds(117, 53, 333, 22);
		company.add(txtCVR);
		
		JLabel lblFaxno = new JLabel("FaxNo");
		lblFaxno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFaxno.setBounds(13, 88, 102, 16);
		company.add(lblFaxno);
		
		txtFaxNo = new JTextField();
		txtFaxNo.setColumns(10);
		txtFaxNo.setBounds(117, 85, 333, 22);
		company.add(txtFaxNo);
		
		JLabel lblContactPerson = new JLabel("Contact Person");
		lblContactPerson.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContactPerson.setBounds(13, 120, 102, 16);
		company.add(lblContactPerson);
		
		txtContactPersonName = new JTextField();
		txtContactPersonName.setColumns(10);
		txtContactPersonName.setBounds(117, 117, 333, 22);
		company.add(txtContactPersonName);
		
		JLabel lblContactPhoneno = new JLabel("Contact PhoneNo");
		lblContactPhoneno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContactPhoneno.setBounds(13, 152, 102, 16);
		company.add(lblContactPhoneno);
		
		txtContactPhoneNo = new JTextField();
		txtContactPhoneNo.setColumns(10);
		txtContactPhoneNo.setBounds(117, 149, 333, 22);
		company.add(txtContactPhoneNo);
		
		private1 = new JPanel();
		private1.setLayout(null);
		private1.setBounds(0, 193, 458, 193);
		getContentPane().add(private1);
		
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(13, 33, 92, 16);
		private1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(113, 31, 333, 22);
		private1.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(13, 71, 92, 16);
		private1.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(113, 68, 333, 22);
		private1.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setBounds(223, 103, 56, 16);
		private1.add(lblBirthdate);
		lblBirthdate.setHorizontalAlignment(SwingConstants.TRAILING);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setBounds(291, 100, 149, 22);
		private1.add(txtBirthDate);
		txtBirthDate.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(12, 106, 93, 16);
		private1.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		
		cbGender = new JComboBox();
		cbGender.addItem((Object)new String("Male"));
		cbGender.addItem((Object)new String("Female"));
		cbGender.setBounds(113, 103, 98, 22);
		private1.add(cbGender);
		//getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtCountryCode, lblCountryCode, txtPhoneNumber, lblPhoneNumber, txtEmail, lblEmail, txtStreetName, lblStreetName, txtStreetNumber, lblStreetNumber, txtCity, lblZipCode, lblNewLabel_1, txtPaymentInfo, chbCompany, btnSave, txtZip, lblCountry, textField_1, lblId, lblCompanyName, txtCompanyName, lblCvr, txtCVR, lblFaxno, txtFaxNo, lblContactPerson, txtContactPersonName, lblContactPhoneno, txtContactPhoneNo, private1, company, lblNewLabel, txtFirstName, lblLastName, txtLastName, lblBirthdate, txtBirthDate, lblGender, cbGender}));
		company.setVisible(false);
		this.setVisible(true);
	}
	public boolean isCompany(){
		if (chbCompany.isSelected())
			return true;
		return false;
	}
	public void addButtonActionListener(ActionListener actionListener) {
		btnSave.addActionListener(actionListener);
	}
	public Company getCompany(){
		return new Company(0, txtEmail.getText(), txtPhoneNumber.getText(),
				txtStreetName.getText(),txtStreetNumber.getText(), new Zip(Integer.parseInt(txtZip.getText()),"Norrebro"),
				txtCountryCode.getText(), txtCompanyName.getText(), txtCVR.getText(),
				txtFaxNo.getText(),txtContactPersonName.getText());
	}
	public Customer getCustomer(){
		Calendar c = Calendar.getInstance();
		c.set(1998, Calendar.MARCH, 15);
		return new PrivateCustomer(0,txtEmail.getText(), txtPhoneNumber.getText(),
				txtStreetName.getText(),txtStreetNumber.getText(), new Zip(Integer.parseInt(txtZip.getText()),"Norrebro"),
				txtCountryCode.getText(),txtFirstName.getText(),txtLastName.getText(),(cbGender.getSelectedIndex()==1)?true:false,
				c);
	}
}
