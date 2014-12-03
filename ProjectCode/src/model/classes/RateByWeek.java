package model.classes;

import java.sql.SQLException;

import model.RateConnect;

public class RateByWeek
{

	private int weekNo;
	private double rate;
	
	public RateByWeek(int weekNo, double rate)
	{
		this.weekNo = weekNo;
		this.rate = rate;
	}

	public int getWeekNo()
	{
		return this.weekNo;
	}
	public double getRate()
	{
		return this.rate;
	}
}