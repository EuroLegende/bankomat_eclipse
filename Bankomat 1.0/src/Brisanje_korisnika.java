import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;

public class Brisanje_korisnika {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void pokretanje() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brisanje_korisnika window = new Brisanje_korisnika();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTextField ime_text;
	private JTextField prezime_text;
	private JTextField broj_text;
	private JTextField sifra_text;
	private JTextField racun_text;
	private JTable table;
	/**
	 * Create the application.
	 */
	public Brisanje_korisnika() {
		initialize();
		conn= sqlConnect.dbConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(25, 49, 94, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(25, 86, 94, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Broj kartice");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(25, 118, 94, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sifra kartice");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(25, 149, 94, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Racun");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(25, 181, 94, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		ime_text = new JTextField();
		ime_text.setBounds(145, 50, 94, 20);
		frame.getContentPane().add(ime_text);
		ime_text.setColumns(10);
		
		prezime_text = new JTextField();
		prezime_text.setBounds(145, 87, 94, 20);
		frame.getContentPane().add(prezime_text);
		prezime_text.setColumns(10);
		
		broj_text = new JTextField();
		broj_text.setBounds(145, 119, 94, 21);
		frame.getContentPane().add(broj_text);
		broj_text.setColumns(10);
		
		sifra_text = new JTextField();
		sifra_text.setBounds(145, 150, 94, 20);
		frame.getContentPane().add(sifra_text);
		sifra_text.setColumns(10);
		
		racun_text = new JTextField();
		racun_text.setBounds(145, 182, 94, 21);
		frame.getContentPane().add(racun_text);
		racun_text.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {String quers ="delete from Baza_korisnika ";
		PreparedStatement ps=conn.prepareStatement(quers);
		
		ps.setString(1, sifra_text.getText());
		
		JOptionPane.showMessageDialog(null, "Data saved");
		ps.close();
		} catch (Exception e2) {
			
		}	
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(145, 232, 94, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_remove_add.pokretanje();
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(10, 368, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(288, 62, 492, 329);
		frame.getContentPane().add(table);
		
		JButton btnNewButton_2 = new JButton("Prikaz Korisnika");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(431, 28, 209, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
	

}
