import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database Connector
 * @author Rik Brugman
 * @package Adresboek
 */

public class DBConnector {
	
	/**
	 * Constructor
	 */
	public DBConnector() {
		
		
		
	}
	/**
	 * Connect to the Access Database
	 * @return String
	 */
	public String connect() {
		
		// create DB connection
		try {
			
			// check if class exists
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			// create connection
			Connection connection = DriverManager.getConnection("AdresboekApplication","", null);
			
		// something went wrong, return message depending on the error	
		} catch(ClassNotFoundException e) {
			
			return e.getMessage();
			
		} catch(SQLException e) {
			
			return e.getMessage();
			
		} catch(Exception e) {
			
			return e.getMessage();
			
		}


		return "CONNECTED";
		
	}
	
}
