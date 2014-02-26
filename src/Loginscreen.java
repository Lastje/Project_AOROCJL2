import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Window.Type;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;


public class Loginscreen extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JButton btnInloggen;

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
		setBounds(100, 100, 400, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Adresboek - Applicatie");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -40, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblOmDezeApplicatie = new JLabel("Om deze applicatie te gebruiken dient u in te loggen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOmDezeApplicatie, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblOmDezeApplicatie, -10, SpringLayout.EAST, lblNewLabel);
		lblOmDezeApplicatie.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblOmDezeApplicatie);
		
		JLabel lblGebruikersnaam = new JLabel("Gebruikersnaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGebruikersnaam, 29, SpringLayout.SOUTH, lblOmDezeApplicatie);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGebruikersnaam, 0, SpringLayout.WEST, lblNewLabel);
		lblGebruikersnaam.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblGebruikersnaam);
		
		JLabel lblWachtwoord = new JLabel("Wachtwoord:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWachtwoord, 6, SpringLayout.SOUTH, lblGebruikersnaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWachtwoord, 0, SpringLayout.WEST, lblNewLabel);
		lblWachtwoord.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblWachtwoord);
		
		btnInloggen = new JButton("Inloggen");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnInloggen, 0, SpringLayout.EAST, lblNewLabel);
		btnInloggen.setBackground(SystemColor.controlShadow);
		btnInloggen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// try to authenticate user
				if(DBConnector.authenticateUser(usernameField.getText(), passwordField.getText())) {
					
					// hide login frame
					setVisible(false);
					
					// show adminpanel frame
					JFrame oMainpanel = new Mainpanel();
					oMainpanel.setVisible(true);
					
					// unset login frame
					dispose();
					
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Gebruikersnaam/wachtwoord onjuist.", "Adresboek", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordField.grabFocus();
					
				}
				
			}
		});
		contentPane.add(btnInloggen);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 39, SpringLayout.EAST, lblWachtwoord);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -40, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnInloggen, 6, SpringLayout.SOUTH, passwordField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH, lblWachtwoord);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyChar() == e.VK_ENTER) {
					
					btnInloggen.doClick();
					
				}
				
			}
		});
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		usernameField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, usernameField, -3, SpringLayout.NORTH, lblGebruikersnaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, usernameField, 16, SpringLayout.EAST, lblGebruikersnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, usernameField, -40, SpringLayout.EAST, contentPane);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
	}
}
