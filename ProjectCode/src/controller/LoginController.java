package controller;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.UserConnect;
import view.LoginWindow;

public class LoginController {

	private LoginWindow loginWindow;
	
	public LoginController()
	{
		loginWindow = new LoginWindow();
	}
	public void addActionListener(ActionListener listener)
	{
		loginWindow.setListener(listener);
	}
	public boolean loginCorrect()
	{
		try {
			return UserConnect.isUser(loginWindow.getUsername(), loginWindow.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void showFrame(boolean b) {
		loginWindow.setVisible(b);
	}
	public void resetInformation() {
		loginWindow.clearPassword();
	}
	public String getUsername() {
		return loginWindow.getUsername();
	}
}
