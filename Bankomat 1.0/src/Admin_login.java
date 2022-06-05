import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class Admin_login {

	private JFrame frame;
	private JTextField textField_BROJ;
	private JTextField textFieldSIFRA;
//caoo
	/**
	 * Launch the application.
	 */
	public static void pokretanje() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login window = new Admin_login();
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
	public Admin_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 255, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BROJ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel.setBounds(34, 87, 59, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIFRA");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(34, 136, 59, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_BROJ = new JTextField();
		textField_BROJ.setBounds(120, 89, 86, 20);
		frame.getContentPane().add(textField_BROJ);
		textField_BROJ.setColumns(10);
		
		textFieldSIFRA = new JTextField();
		textFieldSIFRA.setBounds(120, 138, 86, 20);
		frame.getContentPane().add(textFieldSIFRA);
		textFieldSIFRA.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int card_no=0,card_pin=0;
				try {
					card_no=Integer.parseInt(textField_BROJ.getText());
					card_pin=Integer.parseInt(textFieldSIFRA.getText());
				
					//Dobijamo input korisnika 
					boolean istina=Prijava_admina.Prijava(card_no, card_pin);//poziv meotode ta prijavu iz klase prijava
					if (istina!=true) {
						JOptionPane.showMessageDialog(null, "Podaci su neispravni!!");
						throw new InputMismatchException("Podatci su netoèni!");
						//ukoliko unos nije valjan
					}else{//ako je uslov istinit krecemo na drugu klasu GUI aplikacije
						
					frame.dispose();
					Admin_remove_add.pokretanje();
					
					}
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Unjeli ste neispravan iskaz!!");
				}
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(120, 196, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel_2.setBounds(49, 11, 153, 55);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
