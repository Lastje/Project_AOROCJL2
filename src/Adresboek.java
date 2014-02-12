import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * Application Bootstrapper
 * @author Rik Brugman
 * @package Adresboek
 */

public class Adresboek {

	/**
	 * Defined variables (will be accesible until app is destoyed)
	 */
	public static int iAuthenticatedUser;
	
	/**
	 * Execute at launch
	 * @param args
	 */
	public static void main(String[] args) {
		
		// connect to the database
		String sConnectResult = DBConnector.connect();
		
		if(sConnectResult != "CONNECTED") {
			
			// connection failed, show message and kill application
			JOptionPane.showMessageDialog(null, "Verbinding met database is mislukt.\n\nFoutcode van ODBC driver:\n" + sConnectResult, "Adresboek", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
			
		} else {
			
			// connection is made! autenticate user
			if(DBConnector.authenticateUser("Rik", "Brugman")) {
			
				// valid user, show mainscreen
				
			}
			
		}

	}

}
