package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	private final static String URL = "jdbc:mysql://localhost";
    private final static String PORT = "3306";
    private final static String USER = "root";
    private final static String PASS = "";//enter the password here if you have one
    private final static String DB = "sunshineresort";
    
    public static Connection getConnection()
    {
        String urlForConnection = URL + ":" + PORT + "/" + DB;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlForConnection, USER, PASS);
            return conn;
        } catch (ClassNotFoundException |SQLException ex)
        {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
