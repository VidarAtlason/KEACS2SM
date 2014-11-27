package controller.applicationclasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import view.CustomerWindow;

public class Controller
{
	ActionListener listener = new ActionListener()
	{
		
		public void actionPerformed(ActionEvent arg0)
		{
			Company c = cw.getCompany();
			CompanyDB.insertCompany(c);
			updateView();
		}
	};
	public void Controller(){
		CustomerWindow cw = new CustomerWindow();
		cw.addActionlisteners(listener);
	}
}
