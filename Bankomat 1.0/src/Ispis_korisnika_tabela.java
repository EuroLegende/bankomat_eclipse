import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ispis_korisnika_tabela {

	private JFrame frame;
	private JTable table;
	private JTextField ime;
	private JTextField prezime;
	private JTextField broj_kartice;
	private JTextField sifra_kartice;
	private JTextField racun;
	private JTextField redni_broj;

	/**
	 * Launch the application.
	 */
	public static void prikaz() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ispis_korisnika_tabela window = new Ispis_korisnika_tabela();
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
	public Ispis_korisnika_tabela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(32, 129, 483, 372);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("VASI KORISNICI");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 25, 293, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Prikazi korisnike");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=sqlConnect.dbConnection();//deklariranje konekcije
				
				PreparedStatement izraz=null;
				ResultSet result=null;
				//inicijalizacija 
				try {String query ="Select * from Baza_korisnika ";//uslov z abazu
					izraz=conn.prepareStatement(query);//uslov za bazu koji se prosledujuje
					result=izraz.executeQuery();//dobijanje rezultata
					table.setModel(DbUtils.resultSetToTableModel(result));
				} catch (Exception e2) {
					System.out.println("Problem u bazi, kriv uslov, izraz");
				}finally {
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
		btnNewButton.setBounds(196, 63, 129, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_remove_add.pokretanje();
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(32, 524, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblime = new JLabel("IME");
		lblime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblime.setBounds(582, 129, 89, 23);
		frame.getContentPane().add(lblime);
		
		JLabel lblNewLabel_1 = new JLabel("PREZIME");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(582, 163, 89, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BROJ KARTICE");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(582, 207, 89, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SIFRA KARTICE");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(564, 251, 107, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RACUN");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(582, 295, 89, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		ime = new JTextField();
		ime.setBounds(697, 132, 86, 20);
		frame.getContentPane().add(ime);
		ime.setColumns(10);
		
		prezime = new JTextField();
		prezime.setBounds(697, 166, 86, 20);
		frame.getContentPane().add(prezime);
		prezime.setColumns(10);
		
		broj_kartice = new JTextField();
		broj_kartice.setBounds(697, 210, 86, 20);
		frame.getContentPane().add(broj_kartice);
		broj_kartice.setColumns(10);
		
		sifra_kartice = new JTextField();
		sifra_kartice.setBounds(697, 254, 86, 20);
		frame.getContentPane().add(sifra_kartice);
		sifra_kartice.setColumns(10);
		
		racun = new JTextField();
		racun.setBounds(697, 298, 86, 20);
		frame.getContentPane().add(racun);
		racun.setColumns(10);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
Connection conn=sqlConnect.dbConnection();//deklariranje konekcije
				int redni_broj2=Integer.parseInt(redni_broj.getText());
				int sifra_kartice2= Integer.parseInt(sifra_kartice.getText());
				int broj_kartice2= Integer.parseInt(broj_kartice.getText());
				int racun2= Integer.parseInt(racun.getText());
				PreparedStatement izraz=null;
				ResultSet result=null;
				try {String quers ="UPDATE  Baza_korisnika set Ime=?,  Prezime=?,  Broj_kartice=?,  Sifra_kartice=?, Racun=?  WHERE rowid=?";
				 izraz=conn.prepareStatement(quers);
				izraz.setString(1, ime.getText());
	
				izraz.setString(2, prezime.getText());
				
				izraz.setInt(3, broj_kartice2);
			
				izraz.setInt(4, sifra_kartice2);
			
				izraz.setInt(5, racun2);
				izraz.setInt(6, redni_broj2);
			
				izraz.execute();
				JOptionPane.showMessageDialog(null, "Data saved");
				izraz.close();
				} catch (Exception e2) {
					System.out.println("Pogreska u update korisnika");
				}	
			}
		});
		update.setBackground(Color.RED);
		update.setFont(new Font("Sylfaen", Font.BOLD, 14));
		update.setBounds(677, 350, 124, 39);
		frame.getContentPane().add(update);
		
		JLabel lblNewLabel_5 = new JLabel("UPDETANJE KORISNIKA");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(625, 52, 176, 27);
		frame.getContentPane().add(lblNewLabel_5);
		
		redni_broj = new JTextField();
		redni_broj.setBounds(697, 101, 86, 20);
		frame.getContentPane().add(redni_broj);
		redni_broj.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("REDNI BROJ");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(564, 104, 107, 20);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
