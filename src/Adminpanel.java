import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Toolkit;


public class Adminpanel extends JFrame {

	private JPanel contentPane;
	private JTextField txtGebruikersnaam;
	private JTextField txtWachtwoord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminpanel frame = new Adminpanel();
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
	public Adminpanel() {
		setTitle("Adresboek");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gebruiker\\Documents\\GitHub\\Project_AOROCJL2\\Documenten\\icon.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblHoofdgebruikersBeheren = new JLabel("Hoofdgebruikers beheren");
		lblHoofdgebruikersBeheren.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblHoofdgebruikersBeheren, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHoofdgebruikersBeheren, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblHoofdgebruikersBeheren);
		
		JButton btnVerwijderen = new JButton("Verwijderen");
		btnVerwijderen.setBackground(SystemColor.controlShadow);
		btnVerwijderen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerwijderen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("verwijderen");
			}
		});
		contentPane.add(btnVerwijderen);
		
		JButton btnAanmaken = new JButton("Aanmaken");
		btnAanmaken.setBackground(SystemColor.controlShadow);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAanmaken, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVerwijderen, 0, SpringLayout.EAST, btnAanmaken);
		btnAanmaken.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAanmaken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aanmaken");
			}
		});
		contentPane.add(btnAanmaken);
		
		txtGebruikersnaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtGebruikersnaam, -10, SpringLayout.EAST, contentPane);
		txtGebruikersnaam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtGebruikersnaam.setText("gebruikersnaam");
		contentPane.add(txtGebruikersnaam);
		txtGebruikersnaam.setColumns(10);
		
		txtWachtwoord = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAanmaken, 4, SpringLayout.SOUTH, txtWachtwoord);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtWachtwoord, 4, SpringLayout.SOUTH, txtGebruikersnaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtWachtwoord, 0, SpringLayout.WEST, txtGebruikersnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtWachtwoord, -10, SpringLayout.EAST, contentPane);
		txtWachtwoord.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtWachtwoord.setText("wachtwoord");
		contentPane.add(txtWachtwoord);
		txtWachtwoord.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		
		
		JButton btnSluiten = new JButton("Sluiten");
		btnSluiten.setBackground(SystemColor.controlShadow);
		btnSluiten.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSluiten, -10, SpringLayout.EAST, contentPane);
		btnSluiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSluiten, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnSluiten);
		
		JList list = new JList();
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 50, SpringLayout.NORTH, txtWachtwoord);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 50, SpringLayout.WEST, lblHoofdgebruikersBeheren);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 75, SpringLayout.NORTH, btnAanmaken);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, -185, SpringLayout.EAST, contentPane);
		JScrollPane scrollPane_1 = new JScrollPane(list);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtGebruikersnaam, 67, SpringLayout.EAST, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAanmaken, 95, SpringLayout.EAST, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_1, 350, SpringLayout.WEST, lblHoofdgebruikersBeheren);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_1, 0, SpringLayout.WEST, lblHoofdgebruikersBeheren);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_1, -223, SpringLayout.SOUTH, contentPane);
		contentPane.add( scrollPane_1);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Gebruiker 1", "Gebruiker 2", "Gebruiker 3", "Gebruiker 1", "Gebruiker 2", "Gebruiker 3", "Gebruiker 1", "Gebruiker 2", "Gebruiker 3", "Gebruiker 1", "Gebruiker 2", "Gebruiker 3", "Gebruiker 1", "Gebruiker 2", "Gebruiker 3", "Gebruiker 1", "Gebruiker 2", "Gebruiker 3", "Gebruiker 1", "Gebruiker 2", "Gebruiker 3", "Gebruiker 1", "Gebruiker 2", "Gebruiker 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JList list_1 = new JList();
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee", "lijstje twee"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, list_1, 38, SpringLayout.SOUTH, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, list_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list_1, 156, SpringLayout.SOUTH, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, list_1, 0, SpringLayout.EAST, scrollPane_1);
		JScrollPane scrollPane_2 = new JScrollPane(list_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVerwijderen, 93, SpringLayout.EAST, scrollPane_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_2, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_2, -71, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_2, -228, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane_2);
		
		JLabel lblBeschikbareGebruikers = new JLabel("Beschikbare gebruikers:");
		lblBeschikbareGebruikers.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_2, 8, SpringLayout.SOUTH, lblBeschikbareGebruikers);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBeschikbareGebruikers, -197, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBeschikbareGebruikers, 0, SpringLayout.WEST, lblHoofdgebruikersBeheren);
		contentPane.add(lblBeschikbareGebruikers);
		
		JLabel lblHuidigeHoofdgebruikers = new JLabel("Huidige hoofdgebruikers:");
		lblHuidigeHoofdgebruikers.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblHuidigeHoofdgebruikers, -351, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_1, 10, SpringLayout.SOUTH, lblHuidigeHoofdgebruikers);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHuidigeHoofdgebruikers, 0, SpringLayout.WEST, lblHoofdgebruikersBeheren);
		contentPane.add(lblHuidigeHoofdgebruikers);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 126, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -315, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtGebruikersnaam, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 42, SpringLayout.EAST, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, contentPane);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		
		JLabel lblMaakDeGeselecteerde = new JLabel("Hoofdgebruiker toevoegen");
		lblMaakDeGeselecteerde.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblMaakDeGeselecteerde);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMaakDeGeselecteerde, 107, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblMaakDeGeselecteerde, -10, SpringLayout.EAST, contentPane);
		lblMaakDeGeselecteerde.setForeground(Color.WHITE);
		lblMaakDeGeselecteerde.setBackground(SystemColor.windowText);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 46, SpringLayout.EAST, scrollPane_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -176, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVerwijderen, 6, SpringLayout.SOUTH, panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_1);
		
		JLabel lblHoofdgebruikerVerwijderen = new JLabel("Hoofdgebruiker verwijderen");
		lblHoofdgebruikerVerwijderen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHoofdgebruikerVerwijderen.setForeground(Color.WHITE);
		lblHoofdgebruikerVerwijderen.setBackground(Color.BLACK);
		panel_1.add(lblHoofdgebruikerVerwijderen);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.controlShadow);
		sl_contentPane.putConstraint(SpringLayout.NORTH, separator, 2, SpringLayout.NORTH, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, separator, 21, SpringLayout.EAST, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, separator, 0, SpringLayout.SOUTH, scrollPane_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, separator, -18, SpringLayout.WEST, panel);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);
		
		JLabel lblSelecteerEenGebruiker = new JLabel("Selecteer een gebruiker om deze inlog rechten te geven of de rechten te verwijderen");
		lblSelecteerEenGebruiker.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSelecteerEenGebruiker, 6, SpringLayout.SOUTH, lblHoofdgebruikersBeheren);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSelecteerEenGebruiker, 0, SpringLayout.WEST, lblHoofdgebruikersBeheren);
		contentPane.add(lblSelecteerEenGebruiker);
	
	}
}
