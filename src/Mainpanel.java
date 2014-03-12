import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Mainpanel extends JFrame {
	
	public static JTable table;
	public static JLabel lbl_voornaam;
	public static JLabel lbl_achternaam;
	public static JLabel lbl_geboortedatum;
	public static JLabel lbl_adres;
	public static JLabel lbl_city;
	public static JLabel lbl_postcode;
	public static JLabel lbl_telefoonnummer;
	public static JLabel lbl_emailadres;
	public static JLabel lbl_titel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpanel frame = new Mainpanel();
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
	public Mainpanel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gebruiker\\Documents\\GitHub\\Project_AOROCJL2\\Documenten\\icon.png"));
		setTitle("Adresboek");
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 559);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnprogramma = new JMenu("Programma");
		menuBar.add(mnprogramma);
		
		JMenuItem mntmAfmelden = new JMenuItem("Afmelden...");
		mntmAfmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// restart application and show loginscreen
				StringBuilder cmd = new StringBuilder();
	            cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
	            for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
	                cmd.append(jvmArg + " ");
	            }
	            cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
	            cmd.append(Adresboek.class.getName()).append(" ");

	            try {
	                Runtime.getRuntime().exec(cmd.toString());
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            System.exit(0);
				
			}
		});
		mnprogramma.add(mntmAfmelden);
		
		JSeparator separator = new JSeparator();
		mnprogramma.add(separator);
		
		JMenuItem mntmAfsluiten = new JMenuItem("Afsluiten");
		mntmAfsluiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// remove form and shut down appilcation
				dispose();
				System.exit(0);
				
				
			}
		});
		mnprogramma.add(mntmAfsluiten);
		
		JSplitPane splitPane = new JSplitPane();
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 458, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("Nieuw...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// create new frame
				JFrame newUserFrame = new NewUser();
				newUserFrame.setVisible(true);

			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnGeselecteerdVerwijderen = new JButton("Geselecteerd verwijderen");
		btnGeselecteerdVerwijderen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int iAnswer = JOptionPane.showConfirmDialog(null, "Wilt u deze gebruiker echt verwijderen?", "Gebruiker vewijderen", JOptionPane.YES_NO_OPTION);
				
				// delete selected user
				if(iAnswer == JOptionPane.YES_OPTION) DBConnector.deleteUser(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				table.setModel(DBConnector.createTableModel(DBConnector.executeQuery("SELECT * FROM `Contact`")));
				
			}
		});
		toolBar.add(btnGeselecteerdVerwijderen);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JButton btnAdminPanel = new JButton("Admin Panel");
		btnAdminPanel.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(btnAdminPanel);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		lbl_titel = new JLabel("Voornaam Achternaam");
		lbl_titel.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel lblVoornaam = new JLabel("Voornaam:");
		lblVoornaam.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel = new JLabel("Achternaam:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblGeboortedatum = new JLabel("Geboortedatum:");
		lblGeboortedatum.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		
		JLabel lblAdresgegevens = new JLabel("Adresgegevens");
		lblAdresgegevens.setForeground(Color.WHITE);
		lblAdresgegevens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresgegevens.setBackground(Color.DARK_GRAY);
		panel_2.add(lblAdresgegevens);
		
		JLabel lblStraat = new JLabel("Adres:");
		lblStraat.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Woonplaats:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblHuisnummer = new JLabel("Postcode:");
		lblHuisnummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		
		JLabel lblContactgegevens = new JLabel("Contactgegevens");
		lblContactgegevens.setForeground(Color.WHITE);
		lblContactgegevens.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactgegevens.setBackground(Color.DARK_GRAY);
		panel_3.add(lblContactgegevens);
		
		JLabel lblTelefoonnummer = new JLabel("Telefoonnummer:");
		lblTelefoonnummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmailAdres = new JLabel("E-mail adres:");
		lblEmailAdres.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lbl_voornaam = new JLabel("<Voornaam>");
		lbl_voornaam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_achternaam = new JLabel("<Achternaam>");
		lbl_achternaam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_geboortedatum = new JLabel("<Geboortedatum>");
		lbl_geboortedatum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_adres = new JLabel("<Straatnaam + Huisnummer>");
		lbl_adres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_city = new JLabel("<Woonplaats>");
		lbl_city.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_postcode = new JLabel("<Postcode>");
		lbl_postcode.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_telefoonnummer = new JLabel("<Telefoonnummer>");
		lbl_telefoonnummer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_emailadres = new JLabel("<E-mail adres>");
		lbl_emailadres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_titel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblVoornaam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblGeboortedatum, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_geboortedatum)
								.addComponent(lbl_achternaam)
								.addComponent(lbl_voornaam)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblStraat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lbl_adres)
									.addGap(116)
									.addComponent(lblHuisnummer)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lbl_postcode))
								.addComponent(lbl_city)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTelefoonnummer)
								.addComponent(lblEmailAdres))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_emailadres)
								.addComponent(lbl_telefoonnummer))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lbl_titel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVoornaam)
						.addComponent(lbl_voornaam))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lbl_achternaam))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeboortedatum)
						.addComponent(lbl_geboortedatum))
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStraat)
						.addComponent(lbl_adres)
						.addComponent(lblHuisnummer)
						.addComponent(lbl_postcode))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lbl_city))
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefoonnummer)
						.addComponent(lbl_telefoonnummer))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmailAdres)
						.addComponent(lbl_emailadres))
					.addGap(132))
		);
		
		JLabel lblPersoonlijkeGegevens = new JLabel("Persoonlijke gegevens");
		panel_1.add(lblPersoonlijkeGegevens);
		lblPersoonlijkeGegevens.setBackground(Color.DARK_GRAY);
		lblPersoonlijkeGegevens.setForeground(Color.WHITE);
		lblPersoonlijkeGegevens.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(500, 23));
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable() {
			public boolean isCellEditable(int row, int column){  
				return false;
			}  
		};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
	        public void valueChanged(ListSelectionEvent event) {
				
				if(table.getSelectedRow() > -1) Adresboek.getUserDetails(table.getValueAt(table.getSelectedRow(), 0).toString());
				
			}
	    });
		
		table.setModel(DBConnector.createTableModel(DBConnector.executeQuery("SELECT * FROM `Contact`")));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
	public JLabel getLabel() {
		return lbl_voornaam;
	}
	public JLabel getLabel_1() {
		return lbl_achternaam;
	}
	public JLabel getLabel_2() {
		return lbl_geboortedatum;
	}
	public JLabel getLbl_adres() {
		return lbl_adres;
	}
	public JLabel getLbl_city() {
		return lbl_city;
	}
	public JLabel getLbl_postcode() {
		return lbl_postcode;
	}
	public JLabel getLabel_5() {
		return lbl_telefoonnummer;
	}
	public JLabel getLbl_emailadres() {
		return lbl_emailadres;
	}
	public JLabel getLblVoornaamAchternaam() {
		return lbl_titel;
	}
}
