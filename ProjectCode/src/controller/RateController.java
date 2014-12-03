package controller;

import java.sql.SQLException;

import model.RateConnect;
import model.classes.RateByWeek;

public class RateController 
{
	public static double getRateByWeekNo(int weekNo)
	{
		try 
		{
			RateByWeek[] allRates = RateConnect.getRatesFromDB();
			for (int i = 0; i < allRates.length; i++) 
			{
				if(allRates[i].getWeekNo() == weekNo)
					return allRates[i].getRate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
