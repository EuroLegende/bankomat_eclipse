import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

//dodat da se vidi stanje banke ispises tablicu i da se moze promjeniti
public class Promjena_stanja_banke extends Baza_novca_bankomat {

	private JFrame frame;

	private JTable table;
	private JTextField ime;
	private JTextField prezime;
	private JTextField broj_kartice;
	private JTextField sifra_kartice;
	private JTextField redni_broj;

	/**
	 * Launch the application.
	 */
	public static void prikaz() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Promjena_stanja_banke window = new Promjena_stanja_banke();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Promjena_stanja_banke() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 488, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		table = new JTable();
		table.setBounds(32, 129, 427, 49);
		frame.getContentPane().add(table);

		JLabel lblNewLabel = new JLabel("STANJE BANKE");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(32, 79, 176, 39);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_remove_add.pokretanje();
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(14, 524, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblime = new JLabel("DVADESET");
		lblime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblime.setBounds(32, 329, 89, 23);
		frame.getContentPane().add(lblime);

		JLabel lblNewLabel_1 = new JLabel("PEDESET");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(32, 356, 89, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("STO");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(32, 391, 89, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DVJESTO");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(14, 435, 107, 33);
		frame.getContentPane().add(lblNewLabel_3);

		ime = new JTextField();
		ime.setBounds(145, 331, 86, 20);
		frame.getContentPane().add(ime);
		ime.setColumns(10);

		prezime = new JTextField();
		prezime.setBounds(145, 359, 86, 20);
		frame.getContentPane().add(prezime);
		prezime.setColumns(10);

		broj_kartice = new JTextField();
		broj_kartice.setBounds(145, 394, 86, 20);
		frame.getContentPane().add(broj_kartice);
		broj_kartice.setColumns(10);

		sifra_kartice = new JTextField();
		sifra_kartice.setBounds(145, 438, 86, 20);
		frame.getContentPane().add(sifra_kartice);
		sifra_kartice.setColumns(10);

		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int deset2 = 0;
				int dvadeset2 = 0;
				int pedeset2 = 0;
				int sto2 = 0;
				int dvjesto2 = 0;
				try {
					deset2 = Integer.parseInt(redni_broj.getText());
					dvadeset2 = Integer.parseInt(ime.getText());
					pedeset2 = Integer.parseInt(prezime.getText());
					sto2 = Integer.parseInt(broj_kartice.getText());
					dvjesto2 = Integer.parseInt(sifra_kartice.getText());

				} catch (Exception e2) {
					// TODO: handle exception
				}

				try {
					if (deset2 <= 30 && dvadeset2 <= 30 && pedeset2 <= 40 && sto2 <= 40 && dvjesto2 <= 30) {
						deset = deset2;
						dvadeset = dvadeset2;
						pedeset = pedeset2;
						sto = sto2;
						dvjesto = dvjesto2;

						Connection conn = sqlConnect.dbConnection();// deklariranje konekcije

						PreparedStatement izraz = null;
						ResultSet result = null;
						try {
							String quers = "UPDATE  Bankomat_racun set Deset=?,  Dvadeset=?,  Pedeset=?,  Sto=?, Dvjesto=? ";
							izraz = conn.prepareStatement(quers);
							izraz.setInt(1, deset);
							izraz.setInt(2, dvadeset);
							izraz.setInt(3, pedeset);
							izraz.setInt(4, sto);
							izraz.setInt(5, dvjesto);
							pohrana_stanja();
							izraz.execute();
							JOptionPane.showMessageDialog(null, "Data saved");
							izraz.close();
						} catch (Exception e2) {
							System.out.println("Pogreska u update stanja banke");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Ne mozete dodati vise novcanica nego sto je u izradi bankomata stavljeno");
						throw new InputMismatchException();
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		update.setBackground(Color.RED);
		update.setFont(new Font("Sylfaen", Font.BOLD, 14));
		update.setBounds(128, 473, 124, 39);
		frame.getContentPane().add(update);

		JButton btnNewButton = new JButton("PRIKAZI STANJE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = sqlConnect.dbConnection();// deklariranje konekcije

				PreparedStatement izraz = null;
				ResultSet result = null;
				// inicijalizacija
				try {
					String query = "Select * from Bankomat_racun ";// uslov z abazu
					izraz = conn.prepareStatement(query);// uslov za bazu koji se prosledujuje
					result = izraz.executeQuery();// dobijanje rezultata
					table.setModel(DbUtils.resultSetToTableModel(result));
				} catch (Exception e2) {
					System.out.println("Problem u bazi, kriv uslov, stanje_banke");
				} finally {
					try {
						izraz.close();
						result.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 12));
		btnNewButton.setBounds(32, 189, 129, 33);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_5 = new JLabel("UPDETANJE STANJA");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setBounds(32, 254, 176, 27);
		frame.getContentPane().add(lblNewLabel_5);

		redni_broj = new JTextField();
		redni_broj.setBounds(145, 298, 86, 20);
		frame.getContentPane().add(redni_broj);
		redni_broj.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("DESET");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(14, 301, 107, 20);
		frame.getContentPane().add(lblNewLabel_6);
	}

}
