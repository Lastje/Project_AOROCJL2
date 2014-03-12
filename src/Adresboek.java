import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Application Bootstrapper
 * @author Rik Brugman
 * @package Adresboek
 */

public class Adresboek {

	/**
	 * Defined variables (will be accessible until app is destoyed)
	 */
	public static int iAuthenticatedUser;
	
	/**
	 * Execute at launch
	 * @param args
	 */
	public static void main(String[] args) {
		
		// setup look and feel
		try {
			
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        
	    } catch (Exception e) {}
		
		// connect to the database
		String sConnectResult = DBConnector.connect();
		
		if(sConnectResult != "CONNECTED") {
			
			// connection failed, show message and kill application
			JOptionPane.showMessageDialog(null, "Verbinding met database is mislukt.\n\nFoutcode van ODBC driver:\n" + sConnectResult, "Adresboek", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
			
		} else {
			
			// connection is made! create loginscreen
			JFrame oLoginscreen = new Loginscreen();
			oLoginscreen.setVisible(true);
			
		}

	}
	
	/**
	 * Get user details and place them in the sidebar
	 * 
	 * @param sUserID
	 */
	public static void getUserDetails(String sUserID) {
		
		// execute query
		ResultSet rs = DBConnector.executeQuery("SELECT * FROM Contact WHERE `ContactID` = '" + sUserID + "'");
		
		// change labels
		try {
			
			Mainpanel.lbl_titel.setText(rs.getString("voornaam") + " " + rs.getString("achternaam"));
			Mainpanel.lbl_voornaam.setText(rs.getString("voornaam"));
			Mainpanel.lbl_achternaam.setText(rs.getString("achternaam"));
			Mainpanel.lbl_geboortedatum.setText(rs.getString("geboortedatum"));
			Mainpanel.lbl_adres.setText(rs.getString("adres"));
			Mainpanel.lbl_city.setText(rs.getString("plaatsnaam"));
			Mainpanel.lbl_postcode.setText(rs.getString("postcode"));
			Mainpanel.lbl_telefoonnummer.setText(rs.getString("telefoon"));
			Mainpanel.lbl_emailadres.setText(rs.getString("email"));
			
		} catch (SQLException e) {}
		
	}

}
