package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect
{
	/*
	 * This is where I would put all methods that retrieves/insert data to the db
	 * But it's not a very good idea to have all methods in here
	 * I think we should make separate db-connect classes in the data layer package,
	 * for example CustomerConnect that has only methods dealing with the Customer table,
	 * or ReservationConnect that has only methods dealing with the Reservation table, and so on
	 * These class can have their own properties like Connection conn, PreparedStatement preparedStatement, ResultSet, and so on
	 * but they can inherit from this DBConnect class for these properties and open/close connection methods  
	 */
	
	private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    
    /**
     * open connection to db
     */
    public void openConnection()
    {
        try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/sunshineresortdb?user=root&password=");
		} 
        catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * close connection to db
     */
    public void closeConnection()
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
}
