package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class LoginWindow extends JFrame
{
    private JTextField txtUsername;
    private JPasswordField pwPassword;
    private JButton btnOk;

    public LoginWindow()
    {
	getContentPane().setLayout(null);
	this.setSize(400, 200);

	btnOk = new JButton("Log in");
	btnOk.setBounds(134, 119, 89, 23);
	getContentPane().add(btnOk);

	txtUsername = new JTextField();
	txtUsername.setBounds(134, 31, 145, 20);
	getContentPane().add(txtUsername);
	txtUsername.setColumns(10);

	pwPassword = new JPasswordField();
	pwPassword.setBounds(134, 62, 145, 20);
	getContentPane().add(pwPassword);

	JLabel lblUsername = new JLabel("Username:");
	lblUsername.setBounds(70, 34, 54, 14);
	getContentPane().add(lblUsername);

	JLabel lblPassword = new JLabel("Password:");
	lblPassword.setBounds(70, 65, 54, 14);
	getContentPane().add(lblPassword);
    }

    public String getUsername()
    {
	return txtUsername.getText();
    }

    public String getPassword()
    {
	return new String(pwPassword.getPassword());
    }

    public void setListener(ActionListener listener)
    {
	btnOk.addActionListener(listener);
    }

    public void clearPassword()
    {
	pwPassword.setText("");
	pwPassword.grabFocus();
    }
}
