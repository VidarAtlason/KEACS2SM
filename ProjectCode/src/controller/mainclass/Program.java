package controller.mainclass;

import model.ReservationConnect;
import model.classes.Cottage;
import model.classes.CottageType;
import model.classes.Zip;
import controller.CottageController;
import controller.CustomerController;
import view.CottageWindow;
import view.CustomerWindow;
import view.MainWindow;

public class Program
{

	public static void main(String[] args)
	{
		// create test cottage:
		Cottage cottage = new Cottage(1, new CottageType(5, "Luxury 4", 4, 1000), "Silent Log 1", "Vagabond", "56", new Zip(2400, "Norrebro"));
		
		new CottageController(cottage);
		//new MainWindow();
		//new CustomerController();
		//ReservationConnect.insertNewReservation(); // test connection
	}

}
