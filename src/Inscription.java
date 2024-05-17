import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inscription extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField adresse;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField encore;
	private JTextField specialite;
	private JTextField matricule;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public Inscription(Connection connection) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs\\icon_window.png"));
		setTitle("Cabinet Medical");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(143, 11, 158, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom : ");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom : ");
		lblNewLabel_2.setBounds(10, 106, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse : ");
		lblNewLabel_3.setBounds(10, 146, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton inscriptionBtn = new JButton("Inscription");
		
		inscriptionBtn.setIcon(new ImageIcon("imgs\\add.png"));
		inscriptionBtn.setBounds(321, 245, 103, 23);
		contentPane.add(inscriptionBtn);
		
		JLabel lblNewLabel_4 = new JLabel("Username : ");
		lblNewLabel_4.setBounds(236, 108, 65, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password : ");
		lblNewLabel_5.setBounds(236, 143, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Encore: ");
		lblNewLabel_6.setBounds(236, 183, 65, 14);
		contentPane.add(lblNewLabel_6);
		
		nom = new JTextField();
		nom.setBounds(65, 68, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(65, 103, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		adresse = new JTextField();
		adresse.setBounds(65, 143, 86, 20);
		contentPane.add(adresse);
		adresse.setColumns(10);
		
		username = new JTextField();
		username.setBounds(303, 105, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(303, 140, 86, 20);
		contentPane.add(password);
		
		encore = new JPasswordField();
		encore.setBounds(303, 180, 86, 20);
		contentPane.add(encore);
		
		JLabel lblNewLabel_3_1 = new JLabel("Specialité : ");
		lblNewLabel_3_1.setBounds(10, 186, 60, 14);
		contentPane.add(lblNewLabel_3_1);
		
		specialite = new JTextField();
		specialite.setColumns(10);
		specialite.setBounds(65, 183, 86, 20);
		contentPane.add(specialite);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Type : ");
		lblNewLabel_3_1_1.setBounds(10, 219, 60, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 215, 86, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Medecin");
		comboBox.addItem("Secretaire");
		
		JLabel lblNewLabel_7 = new JLabel("Matricule : ");
		lblNewLabel_7.setBounds(236, 71, 65, 14);
		contentPane.add(lblNewLabel_7);
		
		matricule = new JTextField();
		matricule.setBounds(303, 68, 86, 20);
		contentPane.add(matricule);
		matricule.setColumns(10);
		inscriptionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement ;
				try {
					statement = connection.createStatement();
					String matricule_s = matricule.getText();
					String nom_s = nom.getText();
					String prenom_s = prenom.getText();
					String adresse_s = adresse.getText();
					String specialite_s= specialite.getText();
					String username_s = username.getText();
					String password_s = password.getText();
					String encore_s = encore.getText();
					if(password_s.equals(encore_s)) {
						String sql;
						if(comboBox.getSelectedItem() == "Medecin") {
							 sql = "INSERT INTO MEDECIN VALUES("+matricule_s+",'"
																		+ nom_s+"','"
																		+ prenom_s+"','"
																		+ adresse_s+"','"
																		+ specialite_s +"','"
																		+ username_s+"','"
																		+ password_s+"')";
						System.out.println(sql);
						}
						else {
							 sql = "INSERT INTO SECRETAIRE VALUES('"+matricule_s+"','"
									+ nom_s+"','"
									+ prenom_s+"','"
									+ username_s+"','"
									+ password_s+"')";
						}
						statement.execute(sql);
					} else {
						JOptionPane.showMessageDialog(new JFrame(),
							    "Reconfirmer le mot de pass !",
							    "Warning",
							    JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(),
							e1.toString(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
	}
}
