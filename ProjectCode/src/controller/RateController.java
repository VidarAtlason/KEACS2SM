package controller;

import java.sql.SQLException;

import model.RateConnect;
import model.classes.RateByWeek;

public class RateController 
{
	/**
	 * @author ai
	 * @param weekNo
	 * @return rate for input weekNo
	 */
	public static double getRateByWeekNo(int weekNo) throws SQLException
	{
		RateByWeek[] allRates = RateConnect.getRatesFromDB();
		for (int i = 0; i < allRates.length; i++) 
		{
			if(allRates[i].getWeekNo() == weekNo)
				return allRates[i].getRate();
		}
		return 0;
	}
}
