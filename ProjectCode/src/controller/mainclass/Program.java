package controller.mainclass;

import model.ReservationConnect;
import controller.CustomerController;
import view.CottageWindow;
import view.CustomerWindow;
import view.MainWindow;

public class Program
{

	public static void main(String[] args)
	{
		//new CottageWindow();
		//new MainWindow();
		//new CustomerController();
		ReservationConnect.insertNewReservation();
	}

}