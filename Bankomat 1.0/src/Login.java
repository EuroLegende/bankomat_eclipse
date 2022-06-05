import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//klasa je probni nacin prijave ZANEMARI OVU KLASU
public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
private JTextField textField;
private JTextField textField_1;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqlConnect.dbConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 468, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setBounds(156, 155, 45, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(211, 152, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sifra");
		lblNewLabel_1.setBounds(156, 203, 45, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 200, 86, 20);
		textField_1.setToolTipText("*");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login ");
		btnNewButton.setBounds(211, 253, 86, 23);
	Image img =new ImageIcon(this.getClass().getResource("/log-in.png")).getImage();
		
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Select * from Baza_korisnika where Ime=? and Sifra_kartice=?";
					
					
					PreparedStatement pst =connection.prepareStatement(query);
					
					pst.setString(1,textField.getText() );
					pst.setString(2,textField_1.getText() );
			
					ResultSet rs =pst.executeQuery();
					int brojac=0;
					while (rs.next()) {
						brojac++;
					}
					if (brojac==1) {
						JOptionPane.showMessageDialog(null, "Tocna prijava");
						frame.dispose();
						
						
					}else {
						JOptionPane.showMessageDialog(null, " Netocna prijava");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		Image img2 =new ImageIcon(this.getClass().getResource("/fingernail.png")).getImage();
		
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(0, 7, 474, 407);
		frame.getContentPane().add(lblNewLabel_2);
	}
}

