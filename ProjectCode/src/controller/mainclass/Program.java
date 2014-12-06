package controller.mainclass;

import model.classes.Cottage;
import model.classes.CottageType;
import model.classes.Zip;
import controller.GuiController;
import controller.ReservationController;
import view.CustomerWindow;
import view.MainWindow;

public class Program
{

	public static void main(String[] args)
	{

		// create test cottage:
		//Cottage cottage = new Cottage(1, new CottageType(5, "Luxury 4", 4, 1000), "Silent Log 1", "Vagabond", "56", new Zip(2400, "Norrebro"));
		
		//new ReservationController(cottage);
		//new MainWindow();
		//new CustomerController();

		//new CustomerWindow();
		
		new GuiController();
		

	}

}
