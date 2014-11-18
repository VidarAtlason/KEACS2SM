import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CottageWindow extends JFrame{
	public CottageWindow() {
		setTitle("ReserveCottage");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea txtaCottageInfo = new JTextArea();
		txtaCottageInfo.setRows(8);
		txtaCottageInfo.setBounds(45, 30, 378, 100);
		getContentPane().add(txtaCottageInfo);
		
		JLabel lblCottageInformation = new JLabel("Cottage Information");
		lblCottageInformation.setBounds(47, 13, 125, 16);
		getContentPane().add(lblCottageInformation);
		
		JComboBox cbCustomer = new JComboBox();
		cbCustomer.setBounds(124, 143, 170, 22);
		getContentPane().add(cbCustomer);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(44, 146, 56, 16);
		getContentPane().add(lblCustomer);
		
		JLabel lblWeekfrom = new JLabel("WeekFrom:");
		lblWeekfrom.setBounds(45, 185, 71, 16);
		getContentPane().add(lblWeekfrom);
		
		JComboBox cbWeekFrom = new JComboBox();
		cbWeekFrom.setBounds(124, 182, 56, 22);
		getContentPane().add(cbWeekFrom);
		
		JLabel lblWeekto = new JLabel("WeekTo:");
		lblWeekto.setBounds(202, 185, 71, 16);
		getContentPane().add(lblWeekto);
		
		JComboBox cbWeekTo = new JComboBox();
		cbWeekTo.setBounds(281, 182, 56, 22);
		getContentPane().add(cbWeekTo);
		
		JLabel lblDateFrom = new JLabel("10/10/1010");
		lblDateFrom.setBounds(109, 214, 71, 16);
		getContentPane().add(lblDateFrom);
		
		JLabel lblDateTo = new JLabel("10/10/1010");
		lblDateTo.setBounds(266, 214, 71, 16);
		getContentPane().add(lblDateTo);
		
		JLabel lblPriceStatic = new JLabel("Price:");
		lblPriceStatic.setBounds(45, 263, 71, 16);
		getContentPane().add(lblPriceStatic);
		
		JLabel lblPrice = new JLabel("One Million Dollars!");
		lblPrice.setBounds(124, 263, 144, 16);
		getContentPane().add(lblPrice);
		
		JCheckBox chbPaid = new JCheckBox("Paid");
		chbPaid.setBounds(299, 320, 56, 25);
		getContentPane().add(chbPaid);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(0, 377, 97, 25);
		getContentPane().add(btnSave);
		
		JLabel lblDiscountStatic = new JLabel("Discount:");
		lblDiscountStatic.setBounds(45, 292, 71, 16);
		getContentPane().add(lblDiscountStatic);
		
		JLabel lblDiscount = new JLabel("One Cent");
		lblDiscount.setBounds(124, 292, 144, 16);
		getContentPane().add(lblDiscount);
		
		JLabel lblTotalPriceStatic = new JLabel("Total Price:");
		lblTotalPriceStatic.setBounds(45, 324, 71, 16);
		getContentPane().add(lblTotalPriceStatic);
		
		JLabel lblTotalPrice = new JLabel("999.999.99$");
		lblTotalPrice.setBounds(124, 324, 144, 16);
		getContentPane().add(lblTotalPrice);
		
		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerWindow c = new CustomerWindow();
				c.setVisible(true);
			}
		});
		btnNewCustomer.setBounds(306, 143, 117, 25);
		getContentPane().add(btnNewCustomer);
		this.setSize(new Dimension(479, 449));
		
		this.setVisible(true);
	}
}
