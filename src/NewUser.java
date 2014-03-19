import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtVoornaam;
	private JTextField txtAchternaam;
	private JTextField txtGeboortedatum;
	private JTextField txtAdres;
	private JTextField txtWoonplaats;
	private JTextField txtZip;
	private JTextField txtPhone;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setTitle("Adresboek");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNieweGebruikerToevoegen = new JLabel("Nieuw contact toevoegen");
		lblNieweGebruikerToevoegen.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNaam = new JLabel("Naam:");
		lblNaam.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAchternaam = new JLabel("Achternaam:");
		lblAchternaam.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblGeboortedatum = new JLabel("Geboortedatum:");
		lblGeboortedatum.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblAdres = new JLabel("Adres:\r\n");
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblWoonplaats = new JLabel("Woonplaats");
		lblWoonplaats.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPostcode = new JLabel("Postcode:");
		lblPostcode.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTelefoonnummer = new JLabel("Telefoonnummer:\r\n");
		lblTelefoonnummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmailadres = new JLabel("E-mailadres:");
		lblEmailadres.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JSeparator separator_1 = new JSeparator();
		
		txtVoornaam = new JTextField();
		txtVoornaam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtVoornaam.setColumns(10);
		
		txtAchternaam = new JTextField();
		txtAchternaam.setText("\r\n");
		txtAchternaam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAchternaam.setColumns(10);
		
		txtGeboortedatum = new JTextField();
		txtGeboortedatum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtGeboortedatum.setColumns(10);
		
		txtAdres = new JTextField();
		txtAdres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAdres.setColumns(10);
		
		txtWoonplaats = new JTextField();
		txtWoonplaats.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtWoonplaats.setColumns(10);
		
		txtZip = new JTextField();
		txtZip.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtZip.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPhone.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMail.setColumns(10);
		
		JButton button = new JButton("Aanmaken");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// insert data into the DB
				boolean bInsertResult = DBConnector.addUser(
												txtVoornaam.getText(),
												txtAchternaam.getText(),
												txtGeboortedatum.getText(),
												txtAdres.getText(),
												txtWoonplaats.getText(),
												txtZip.getText(),
												txtPhone.getText(),
												txtMail.getText()
										);
				
				// check for errors
				if(!bInsertResult) {
					
					JOptionPane.showMessageDialog(null, "Er is een fout opgetreden. Probeer het opnieuw", "Nieuw contact", JOptionPane.ERROR_MESSAGE);
					
				} else {
				
					// update main grid
					Mainpanel.table.setModel(DBConnector.createTableModel(DBConnector.executeQuery("SELECT * FROM `Contact`")));
					
					// dispose window
					dispose();
					
				}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(SystemColor.controlShadow);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAchternaam, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAchternaam, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNaam, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtVoornaam, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblGeboortedatum, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtGeboortedatum, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAdres, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAdres, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblWoonplaats, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtWoonplaats, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPostcode, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtZip, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTelefoonnummer, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmailadres, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNieweGebruikerToevoegen, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
					.addGap(179))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNieweGebruikerToevoegen)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNaam)
						.addComponent(txtVoornaam, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAchternaam)
						.addComponent(txtAchternaam, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeboortedatum)
						.addComponent(txtGeboortedatum, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdres)
						.addComponent(txtAdres, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWoonplaats)
						.addComponent(txtWoonplaats, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPostcode)
						.addComponent(txtZip, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefoonnummer)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmailadres)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
