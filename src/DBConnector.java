import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	 * Execute query and obtain ResultSet
	 * 
	 * @param sQuery
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sQuery) {
		
		// execute query and obtain resultset
		try {
			
			Statement statement = connection.createStatement();
			return statement.executeQuery(sQuery);
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		
		return null;
		
	}
	
	/**
	 * Remove a user
	 * 
	 * @param String sUserID
	 * @return ResultSet
	 */
	public static boolean deleteUser(String sUserID) {
		
		// execute query
		try {
			
			Statement statement = connection.createStatement();
			statement.executeQuery("DELETE FROM Contact WHERE `ContactID` = '" + sUserID + "'");
			statement.executeQuery("DELETE FROM Login WHERE `Contact_id`  = '" + sUserID + "'");
			
			return true;
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		
		return false;
		
	}
	
	/**
	 * Create a Table Model for use in JTable
	 * 
	 * @param ResultSet rs
	 * @return Vector
	 */
	public static DefaultTableModel createTableModel(ResultSet rs) {
		
		try {
			
			// get table meta
			ResultSetMetaData metaData = rs.getMetaData();
			
			// create vector with columnnames
		    Vector<String> columnNames = new Vector<String>();
		    
		    int columnCount = metaData.getColumnCount();
		    
		    // add columnnames to vector
		    for (int column = 1; column <= columnCount; column++) columnNames.add(metaData.getColumnName(column));

		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    
		    // loop through records
		    while (rs.next()) {
		    	
		    	// create new vector that holds a row
		        Vector<Object> vector = new Vector<Object>();
		        
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)  vector.add(rs.getObject(columnIndex));
		        
		        // add to vector
		        data.add(vector);
		    }
		    
		    // return table model
		    return new DefaultTableModel(data, columnNames);
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}

	    return null;
		
	}
	
}
