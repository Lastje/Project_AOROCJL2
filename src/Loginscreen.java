import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import javax.swing.JButton;


public class Loginscreen extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginscreen frame = new Loginscreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loginscreen() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Adresboek - Applicatie");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblOmDezeApplicatie = new JLabel("Om deze applicatie te gebruiken dient u in te loggen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOmDezeApplicatie, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOmDezeApplicatie, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblOmDezeApplicatie);
		
		JLabel lblGebruikersnaam = new JLabel("Gebruikersnaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGebruikersnaam, 46, SpringLayout.SOUTH, lblOmDezeApplicatie);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGebruikersnaam, 61, SpringLayout.WEST, contentPane);
		contentPane.add(lblGebruikersnaam);
		
		JLabel lblWachtwoord = new JLabel("Wachtwoord:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWachtwoord, 6, SpringLayout.SOUTH, lblGebruikersnaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWachtwoord, 10, SpringLayout.WEST, lblGebruikersnaam);
		contentPane.add(lblWachtwoord);
		
		JButton btnInloggen = new JButton("Inloggen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnInloggen, 21, SpringLayout.SOUTH, lblWachtwoord);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnInloggen, 0, SpringLayout.WEST, lblGebruikersnaam);
		contentPane.add(btnInloggen);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblWachtwoord);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 36, SpringLayout.EAST, lblWachtwoord);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -145, SpringLayout.EAST, contentPane);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, -262, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblGebruikersnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -176, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
