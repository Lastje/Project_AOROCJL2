import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.sqlite.JDBC;

/**
 * Database Connector
 * @author Rik Brugman
 * @package Adresboek
 */

public class DBConnector {
	
	/**
	 * Database Connection
	 * @var connection
	 * @access private
	 */
	private static Connection connection;
	
	/**
	 * Connect to the Access Database
	 * @return String
	 */
	public static String connect() {
		
		// create DB connection
		try {
			
			// check if class exists
			Class.forName("org.sqlite.JDBC");
			
			// update connection
			connection = DriverManager.getConnection("jdbc:sqlite:adresboek.db");
			
		// something went wrong, return message depending on the error	
		} catch(ClassNotFoundException e) {
			
			return e.getMessage();
			
		} catch(SQLException e) {
			
			return e.getMessage();
			
		} catch(Exception e) {
			
			return e.getMessage();
			
		}
		
		// everything is OK, return code
		return "CONNECTED";
		
	}
	
	/**
	 * Authenticate user login credentials
	 * 
	 * @param String sFirstname
	 * @param String sLastname
	 * @return boolean
	 */
	public static boolean authenticateUser(String sFirstname, String sLastname) {
		
		try {
			
			// execute query and obtain resultset
	    	Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM Contact WHERE `voornaam` = '" + sFirstname + "' AND `achternaam` = '" + sLastname + "'");
	   
	        // user doesn't exists, return false
	        if(!resultSet.next()) return false;
	        
	        // user exists, store user ID
	        Adresboek.iAuthenticatedUser = resultSet.getInt("id");
	        
	        // everything is OK, grant access
			return true;
			
	    } catch (SQLException e) {
	    	
	    	// something went wrong, display error and close
	    	JOptionPane.showMessageDialog(null, "Kan de query niet uitvoeren:\n" + e.getMessage(), "Adresboek", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    	
	    }
		
		return false;
		
	}
	
}
