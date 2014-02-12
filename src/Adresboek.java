import javax.swing.JOptionPane;

/**
 * Application Bootstrapper
 * @author Rik Brugman
 * @package Adresboek
 */

public class Adresboek {

	/**
	 * Execute at launch
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create class instances
		DBConnector dbConnection = new DBConnector();
		
		// connect to the database
		String sConnectResult = dbConnection.connect();
		
		if(sConnectResult != "CONNECTED") {
			
			// connection failed, show message and kill application
			JOptionPane.showMessageDialog(null, "Verbinding met database is mislukt.\n\nFoutcode van ODBC driver:\n" + sConnectResult, "Adresboek", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
			
		} else {
			
			// connection is made!
			
			
		}

	}

}
