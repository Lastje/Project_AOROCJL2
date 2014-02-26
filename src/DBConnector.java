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
	 * @param String sUsername
	 * @param String sPassword
	 * @return boolean
	 */
	public static boolean authenticateUser(String sUsername, String sPassword) {
		
		try {
			
			// execute query and obtain resultset
	    	Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM Login INNER JOIN Contact ON Login.`Contact_id` = Contact.`ContactID` WHERE `gebruikersnaam` = '" + sUsername + "' AND `wachtwoord` = '" + sPassword + "'");
	   
	        // user doesn't exists, return false
	        if(!resultSet.next()) return false;
	        
	        // user exists, store user ID
	        Adresboek.iAuthenticatedUser = resultSet.getInt("Contact_id");
	        
	        // everything is OK, grant access
			return true;
			
	    } catch (SQLException e) {
	    	
	    	// something went wrong, display error and close
	    	JOptionPane.showMessageDialog(null, "Kan de query niet uitvoeren:\n" + e.getMessage(), "Adresboek", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    	
	    }
		
		return false;
		
	}
	
	/**
	 * Create a vector from the resultsets
	 * 
	 * @return Vector
	 */
	public static Vector fillContactsList() {
		
		// create vector
        Vector data = new Vector();
		
		try {
			
			// execute query and get resultset
	    	Statement statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT * FROM Contacts");
	        
	        // get column headers
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnCount = rsmd.getColumnCount();
	       
	        // get resultset
	        while (rs.next()) {
	        	
	        	// create a second vector
	        	Vector row = new Vector(columnCount);
	        	
	        	// loop though data and push rows to the vector
	            for (int i = 1; i <= columnCount; i++) {
	            	row.addElement(rs.getString(i));
	            }
	            
	            // add vector to global vector
	            data.addElement(row);
	        }
	        
	        
	    } catch (SQLException e ) {
	    	
	    }
		
		// retouneer vector met alle rows
		return data;
	}
	
}
