import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class Bankomat_sign_up {//sign up GUI

	private JFrame frame;//imenovanje GUI frejma
	private JTextField Upis_kartice;//glovalna varijavla za upis kartice
	private JTextField UpisPINA;//globalna varijavla za upis pina

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Baza_novca_bankomat.popuna_nizova();
		Baza_novca_bankomat.pohrana_stanja();
		System.out.println(Baza_novca_bankomat.ukupno_stanje);
		Baza_korisnika.pohrana();
		Admin_remove_add.pohrana_admina();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bankomat_sign_up window = new Bankomat_sign_up();
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
	public Bankomat_sign_up() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 374, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[127px][161px][12px][249px]", "[14px][112px][34px][24px][23px][][][][][][][][][][]"));
		
		JLabel lblPowered = new JLabel("Powered by stepbystep");
		lblPowered.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		frame.getContentPane().add(lblPowered, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("STEP BY STEP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel, "cell 1 1 2 1,grow");
		
		JLabel lblCardNo = new JLabel("Card NO.");
		lblCardNo.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(lblCardNo, "cell 0 5,alignx right,growy");
		
		Upis_kartice = new JTextField();
		frame.getContentPane().add(Upis_kartice, "cell 1 5,alignx center,aligny center");
		Upis_kartice.setColumns(10);
		
		JLabel lblPIN = new JLabel("Card PIN");
		lblPIN.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(lblPIN, "cell 0 7,alignx right,growy");
		
		UpisPINA = new JTextField();
		frame.getContentPane().add(UpisPINA, "cell 1 7,alignx center,aligny top");
		UpisPINA.setColumns(10);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//akcija za buton sign up 
				//vrsenje pohrane podataka u nizove preko metode pohrane izu klase baza_korisnika
			int card_no=0,card_pin=0;
			try {
				card_no=Integer.parseInt(Upis_kartice.getText());
				card_pin=Integer.parseInt(UpisPINA.getText());
				//Dobijamo input korisnika 
				boolean istina=Prijava_korisnika.Prijava(card_pin, card_no);//poziv meotode ta prijavu iz klase prijava
				if (istina!=true) {
					JOptionPane.showMessageDialog(null, "Podaci su neispravni!!");
					throw new InputMismatchException("Podatci su netoèni!");
					//ukoliko unos nije valjan
				}else{//ako je uslov istinit krecemo na drugu klasu GUI aplikacije
					
				frame.dispose();
				Bankomat_rad rad=new Bankomat_rad();
				rad.baja();
				}
				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Unjeli ste neispravan iskaz!!");
			}
			
				
			}
		});
		btnSignUp.setForeground(Color.DARK_GRAY);
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setFont(new Font("Sitka Text", Font.BOLD, 16));
		frame.getContentPane().add(btnSignUp, "cell 1 12,alignx center,growy");
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_login.pokretanje();
			}
		});
		btnNewButton.setBackground(Color.RED);
		frame.getContentPane().add(btnNewButton, "cell 0 14");
	}
}
