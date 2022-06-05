import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Admin_remove_add {

	private JFrame frame;
static String[]ime_admina=new String[2];
static String[]prezime_admina =new String [2];
static int[]sifra_admina1 =new int [2];
static int[]broj_admina1 =new int [2];
	/**
	 * Launch the application.
	 */
	
	public static void pokretanje() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_remove_add window = new Admin_remove_add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}public static void pohrana_admina () {
		Connection conn=sqlConnect.dbConnection();
		
		PreparedStatement izraz=null;
		ResultSet result=null;
		try {String query ="Select Ime from Admini  ";
			izraz=conn.prepareStatement(query);
			result=izraz.executeQuery();
			int brojac=0;
			while (result.next()) {
				ime_admina[brojac]=result.getString("Ime");
				brojac++;
			}
		} catch (Exception e) {
			System.out.println("Problem u bazi, kriv uslov, izraz-admin");
		}finally {
			try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}//zatvaranje parametara za komunaickju sa bazom
		}	try {String query ="Select Prezime from Admini  ";
		izraz=conn.prepareStatement(query);
		result=izraz.executeQuery();
		int brojac=0;
		while (result.next()) {
			prezime_admina[brojac]=result.getString("Prezime");
			brojac++;
		}
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-admin");
	}finally {
		try {
		izraz.close();
		result.close();
	} catch (Exception e) {
		// TODO: handle exception
	}//zatvaranje parametara za komunaickju sa bazom
	}	try {String query ="Select Sifra_kartice from Admini  ";
	izraz=conn.prepareStatement(query);
	result=izraz.executeQuery();
	int brojac=0;
	while (result.next()) {
		sifra_admina1[brojac]=result.getInt("Sifra_kartice");
		brojac++;
	}
} catch (Exception e) {
	System.out.println("Problem u bazi, kriv uslov, izraz-admin");
}finally {
	try {
	izraz.close();
	result.close();
} catch (Exception e) {
	// TODO: handle exception
}//zatvaranje parametara za komunaickju sa bazom
}	try {String query ="Select Broj_kartice from Admini  ";
izraz=conn.prepareStatement(query);
result=izraz.executeQuery();
int brojac=0;
while (result.next()) {
	broj_admina1[brojac]=result.getInt("Broj_kartice");
	brojac++;
}
} catch (Exception e) {
System.out.println("Problem u bazi, kriv uslov, izraz-admin");
}finally {
try {
izraz.close();
result.close();
} catch (Exception e) {
// TODO: handle exception
}//zatvaranje parametara za komunaickju sa bazom
}

	}

	/**
	 * Create the application.
	 */
	public Admin_remove_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 336, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOBRO DO\u0160LI ADMINE");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 22, 225, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIspisAdmina = new JLabel(Druga_pretvorba_stringa_ime.potreban3);
		lblIspisAdmina.setForeground(Color.RED);
		lblIspisAdmina.setBackground(SystemColor.scrollbar);
		lblIspisAdmina.setHorizontalAlignment(SwingConstants.CENTER);
		lblIspisAdmina.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblIspisAdmina.setBounds(73, 76, 169, 24);
		frame.getContentPane().add(lblIspisAdmina);
		
		JButton btnStanje_korisnika = new JButton("CHECK USERS");
		btnStanje_korisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Ispis_korisnika_tabela.prikaz();
				
				
			}
		});
		btnStanje_korisnika.setBackground(SystemColor.info);
		btnStanje_korisnika.setFont(new Font("Sylfaen", Font.BOLD, 12));
		btnStanje_korisnika.setBounds(10, 171, 136, 41);
		frame.getContentPane().add(btnStanje_korisnika);
		
		JButton btnBanka = new JButton("BANKA");
		btnBanka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Promjena_stanja_banke.prikaz();
			}
		});
		btnBanka.setBackground(SystemColor.info);
		btnBanka.setFont(new Font("Sylfaen", Font.BOLD, 12));
		btnBanka.setBounds(10, 256, 136, 41);
		frame.getContentPane().add(btnBanka);
		
		JButton btnadd_korisnik = new JButton("ADD USERS");
		btnadd_korisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Registracija_novog_korisnika.baja2();
			}
		});
		btnadd_korisnik.setBackground(SystemColor.info);
		btnadd_korisnik.setFont(new Font("Sylfaen", Font.BOLD, 12));
		btnadd_korisnik.setBounds(174, 171, 136, 41);
		frame.getContentPane().add(btnadd_korisnik);
		
		JButton btnremov_korisnik = new JButton("REMOVE USERS");
		btnremov_korisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Brisanje_korisnika.pokretanje();
			}
		});
		btnremov_korisnik.setBackground(SystemColor.info);
		btnremov_korisnik.setFont(new Font("Sylfaen", Font.BOLD, 12));
		btnremov_korisnik.setBounds(174, 256, 136, 41);
		frame.getContentPane().add(btnremov_korisnik);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(114, 328, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
