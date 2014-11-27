package controller.applicationclasses;

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


	public double calculatePrice(int weekNo, double standardPrice)
	{
		// TODO - implement RateByWeek.calculatePrice
		throw new UnsupportedOperationException();
	}


	public boolean updateRate(int weekNo, int newRate)
	{
		// TODO - implement RateByWeek.updateRate
		throw new UnsupportedOperationException();
	}

}