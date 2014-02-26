import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class Mainpanel extends JFrame {
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpanel frame = new Mainpanel();
					
					DefaultTableModel tableMod = new DefaultTableModel() {

					    @Override
					    public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
					};
					tableMod.setColumnCount(4);
					
					table.setModel(tableMod);
					
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
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 559);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnprogramma = new JMenu("Programma");
		menuBar.add(mnprogramma);
		
		JMenuItem mntmAfmelden = new JMenuItem("Afmelden...");
		mnprogramma.add(mntmAfmelden);
		
		JSeparator separator = new JSeparator();
		mnprogramma.add(separator);
		
		JMenuItem mntmAfsluiten = new JMenuItem("Afsluiten");
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
		toolBar.add(btnNewButton);
		
		JButton btnGeselecteerdVerwijderen = new JButton("Geselecteerd verwijderen");
		toolBar.add(btnGeselecteerdVerwijderen);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JButton btnAdminPanel = new JButton("Admin Panel");
		btnAdminPanel.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(btnAdminPanel);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		splitPane.setLeftComponent(table);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JLabel lblVoornaamAchternaam = new JLabel("Voornaam Achternaam");
		lblVoornaamAchternaam.setFont(new Font("Arial", Font.PLAIN, 30));
		
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
		
		JLabel label = new JLabel("<Voornaam>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_1 = new JLabel("<Achternaam>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_2 = new JLabel("<Geboortedatum>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_3 = new JLabel("<Straatnaam + Huisnummer>");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_4 = new JLabel("<Woonplaats>");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_2 = new JLabel("<Postcode>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_5 = new JLabel("<Telefoonnummer>");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_6 = new JLabel("<E-mail adres>");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVoornaamAchternaam, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblVoornaam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblGeboortedatum, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblStraat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3)
									.addGap(116)
									.addComponent(lblHuisnummer)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2))
								.addComponent(label_4)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTelefoonnummer)
								.addComponent(lblEmailAdres))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6)
								.addComponent(label_5))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblVoornaamAchternaam, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVoornaam)
						.addComponent(label))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeboortedatum)
						.addComponent(label_2))
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStraat)
						.addComponent(label_3)
						.addComponent(lblHuisnummer)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(label_4))
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefoonnummer)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmailAdres)
						.addComponent(label_6))
					.addGap(132))
		);
		
		JLabel lblPersoonlijkeGegevens = new JLabel("Persoonlijke gegevens");
		panel_1.add(lblPersoonlijkeGegevens);
		lblPersoonlijkeGegevens.setBackground(Color.DARK_GRAY);
		lblPersoonlijkeGegevens.setForeground(Color.WHITE);
		lblPersoonlijkeGegevens.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
