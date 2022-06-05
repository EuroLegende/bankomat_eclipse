import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

public class Bankomat_rad extends Prijava_korisnika {

	private JFrame frame;//GUI prozor
	private JTextField textUpis;//field za upis sume novca
	static JTextField textIspis;//ispis stanja racuna 
	
	 static JTextArea textIzlaz_novca;//ispis novca koj j ekroisnik dobio
	/**
	 * Launch the application.
	 */
	public static void baja() {//metoda koja pokrece GUI

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bankomat_rad window = new Bankomat_rad();
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
	public Bankomat_rad() {//metoda koja poziva metodu za funkcije GUI prozora
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {//tu se begi sve radi
		frame = new JFrame();//kreirali smo frejm
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 693, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane()
				.setLayout(new MigLayout("", "[73px][52px][15px][51px][][9px][133px][][145px][11px][168px,grow]", "[14px][88px][30px][59px][1px][53px][18px][29px,grow][grow][47px][][39px]"));

		JLabel lblPowered = new JLabel("powered by stepbystep");
		lblPowered.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		frame.getContentPane().add(lblPowered, "cell 0 0 3 1,grow");
		//gornji oblacic nije bitno
		JLabel lblNewLabel_2 = new JLabel("NEMOJ DA DIRAS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		frame.getContentPane().add(lblNewLabel_2, "flowx,cell 10 3");
//ukras
		JLabel lblIme_prezime = new JLabel(Druga_pretvorba_stringa_ime.potreban3);
		lblIme_prezime.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 17));
		frame.getContentPane().add(lblIme_prezime, "cell 10 1 1 3,growx,aligny center");
		//ispis korisnika tko je
		JLabel lblUNOS= new JLabel("Upisite unos");
		lblUNOS.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		frame.getContentPane().add(lblUNOS, "cell 1 6");
		//text koji pokazuje na unos
	    textIzlaz_novca = new JTextArea();
		textIzlaz_novca.setEnabled(false);
		textIzlaz_novca.setBackground(Color.BLACK);
		frame.getContentPane().add(textIzlaz_novca, "cell 10 7,grow");
		//deklariranje area da se moze ispisat novac koji izlazi
		JScrollPane scrollPane = new JScrollPane(textIzlaz_novca);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		frame.getContentPane().add(scrollPane, "cell 10 8,grow");
		//scroll za area di se ispisuju pare
		JButton btnStavljanje_novca = new JButton("DEPOSIT");
		btnStavljanje_novca.setBackground(UIManager.getColor("Button.light"));
		btnStavljanje_novca.addActionListener(new ActionListener() {//akcija deposti tipke
			public void actionPerformed(ActionEvent e) {

				int suma = 0;
				try {

					suma = Integer.parseInt(textUpis.getText());//dobijamo input korisnika
					Algoritam_depozita_na_banku.provjera_uslova_depozita(suma);//pozivamo algoritam provjere ispravnosti unjeteog unosa

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Neispravan unjet unos");
				}

			}
		});

		
		
			
		

		textIspis = new JTextField();
		textIspis.setEnabled(false);
		textIspis.setBackground(Color.BLACK);
		textIspis.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textIspis.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textIspis, "cell 1 4 7 1,grow");
		textIspis.setColumns(10);
		//ispis racuna
		

		textUpis = new JTextField();
		textUpis.setBackground(UIManager.getColor("Button.background"));
		textUpis.setHorizontalAlignment(SwingConstants.CENTER);
		textUpis.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		frame.getContentPane().add(textUpis, "flowx,cell 6 6,alignx left,aligny bottom");
		textUpis.setColumns(10);
//upis racuna 
		JLabel lblNewLabel = new JLabel("Novac koji ste preuzeli");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.ITALIC, 14));
		frame.getContentPane().add(lblNewLabel, "cell 9 6 2 1,grow");

		btnStavljanje_novca.setFont(new Font("Sylfaen", Font.BOLD, 16));
		frame.getContentPane().add(btnStavljanje_novca, "cell 1 9 5 1,grow");

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(Color.RED);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//metoda za vracanje na login prozor
				frame.dispose();
				Bankomat_sign_up.main(ime);
			}
		});

		JButton btnSkidanje_novca = new JButton("WITHDRAW");
		btnSkidanje_novca.setBackground(UIManager.getColor("Button.light"));
		btnSkidanje_novca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//metoda za skida nje para

				int suma = 0;
				try {
					suma = Integer.parseInt(textUpis.getText());
					Algoritam_isplate.provjera_uslova_isplate(suma);//pozivanje meotode za provjeru unosa

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Neispravan unjet unos");
				}

			}
		});
		btnSkidanje_novca.setFont(new Font("Sylfaen", Font.BOLD, 16));
		frame.getContentPane().add(btnSkidanje_novca, "cell 7 9,alignx center,growy");

		btnReset.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(btnReset, "cell 1 11 5 1,grow");

		JLabel lblNaslov = new JLabel("BANKOMAT - STEP BY STEP");
		lblNaslov.setBackground(UIManager.getColor("Button.shadow"));
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaslov.setFont(new Font("Sylfaen", Font.BOLD, 22));
		frame.getContentPane().add(lblNaslov, "cell 0 1 11 1,grow");
//ukras
		JButton btnStanje_novca = new JButton("CHECK");
		btnStanje_novca.setBackground(UIManager.getColor("Button.light"));
		btnStanje_novca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textIspis.setText(Baza_racuna.get_Izvod());//ispis stanja racuna

			}
		});
		btnStanje_novca.setFont(new Font("Sylfaen", Font.BOLD, 16));
		frame.getContentPane().add(btnStanje_novca, "cell 7 11,grow");
//nako
	}
}
