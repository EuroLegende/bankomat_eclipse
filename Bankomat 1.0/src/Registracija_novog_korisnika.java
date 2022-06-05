import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
//klasa nije zavrsena jer je razrada cijele logike registracije jos uvijek u tijeku
//ne dolazi brisanje korisnika itd....
public class Registracija_novog_korisnika {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void baja2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registracija_novog_korisnika window = new Registracija_novog_korisnika();
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
	/**
	 * Create the application.
	 */
	public Registracija_novog_korisnika() {
		initialize();
		conn= sqlConnect.dbConnection();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 355, 405);
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
		try {String quers ="insert into Baza_korisnika (Ime,Prezime,Broj_kartice,Sifra_kartice,Racun) values (?,?,?,?,?) ";
		PreparedStatement ps=conn.prepareStatement(quers);
		ps.setString(1, ime_text.getText());
		ps.setString(2, prezime_text.getText());
		ps.setString(3, broj_text.getText());
		ps.setString(4, sifra_text.getText());
		ps.setString(5, racun_text.getText());
		ps.execute();
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
		btnNewButton_1.setBounds(10, 332, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
