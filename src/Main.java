import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Main {

	private JFrame frmCabinetMedical;
	private JTextField username;
	private JPasswordField password;
	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	private Connection connection;
	private Statement statement;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCabinetMedical.setVisible(true);
					window.frmCabinetMedical.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCabinetMedical = new JFrame();
		frmCabinetMedical.setResizable(false);

		frmCabinetMedical.getContentPane().setBackground(new Color(255, 255, 255));
		frmCabinetMedical.setIconImage(Toolkit.getDefaultToolkit().getImage("imgs\\icon_window.png"));
		frmCabinetMedical.setTitle("Cabinet Medical");
		frmCabinetMedical.setBounds(100, 100, 571, 352);
		frmCabinetMedical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCabinetMedical.getContentPane().setLayout(null);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","souhil","souhil");
			System.out.println("Connection effectué !");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imgs\\connection.jpg"));
		lblNewLabel.setBounds(193, 0, 352, 313);
		frmCabinetMedical.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Connexion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(32, 11, 151, 44);
		frmCabinetMedical.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(83, 95, 106, 20);
		frmCabinetMedical.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username : ");
		lblNewLabel_2.setBounds(10, 95, 82, 14);
		frmCabinetMedical.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password :");
		lblNewLabel_2_1.setBounds(10, 126, 82, 14);
		frmCabinetMedical.getContentPane().add(lblNewLabel_2_1);
		
		password = new JPasswordField();
		password.setBounds(83, 126, 106, 20);
		frmCabinetMedical.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.setIcon(new ImageIcon("imgs\\connection.png"));

		btnNewButton.setBounds(46, 198, 130, 23);
		frmCabinetMedical.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Type :");
		lblNewLabel_2_1_1.setBounds(10, 156, 82, 14);
		frmCabinetMedical.getContentPane().add(lblNewLabel_2_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 155, 106, 22);
		comboBox.addItem("Medecin");
		comboBox.addItem("Secretaire");
		frmCabinetMedical.getContentPane().add(comboBox);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "Secretaire") {
					
					Statement statement ;
					try {
						statement =  getConnection().createStatement();
						String user = username.getText();
						String pass = password.getText();
						String sql = "SELECT ID_SECRETAIRE, NOM_SECRETAIRE, PRENOM_SECRETAIRE FROM SECRETAIRE WHERE "
								+ "USERNAME = " + "'" + user + "'" + " AND " + "PASSWORD = "+ "'" + pass + "'";
						System.out.println(sql);
						ResultSet result = statement.executeQuery(sql);
						//System.out.println(result.getRow());
						 int i = 0;
						 String nom = "",prenom = "";
						 int id_matricule=0;
					        while (result.next()) {
					            i++;
					            nom = result.getString("NOM_SECRETAIRE");
					            prenom  = result.getString("PRENOM_SECRETAIRE");
					            id_matricule  = result.getInt("ID_SECRETAIRE");
					        }
						if(i>0) {
							Secretaire secretaire = new Secretaire(id_matricule,nom,prenom );
							Rendezvousframe frame_rendezvous  = new Rendezvousframe(getConnection(),secretaire);
							frame_rendezvous.setVisible(true);
							frame_rendezvous.setLocationRelativeTo(null);
						}else {
							JOptionPane.showMessageDialog(new JFrame(),
								    "Compte n'existe pas ! ",
								    "Warning",
								    JOptionPane.WARNING_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					Statement statement ;
					try {
						statement =  getConnection().createStatement();
						String user = username.getText();
						String pass = password.getText();
						String sql = "SELECT ID_MEDECIN, NOM_MEDECIN, PRENOM_MEDECIN, ADRESSE_MEDECIN, SPECIALITE_MEDECIN,USERNAME FROM MEDECIN WHERE "
								+ "USERNAME = " + "'" + user + "'" + " AND " + "PASSWORD = "+ "'" + pass + "'";
						System.out.println(sql);
						ResultSet result = statement.executeQuery(sql);
						//System.out.println(result.getRow());
						 int i = 0;
						 String nom = "",prenom = "",adresse="",specialite="",username="";
						 int id_matricule=0;
					        while (result.next()) {
					            i++;
					            nom = result.getString("NOM_MEDECIN");
					            prenom  = result.getString("PRENOM_MEDECIN");
					            id_matricule  = result.getInt("ID_MEDECIN");
					            adresse = result.getString("ADRESSE_MEDECIN");
					            specialite = result.getString("SPECIALITE_MEDECIN");
					            username = result.getString("USERNAME");
					        }
						if(i>0) {
							Medecin medecin = new Medecin(nom,prenom,adresse,specialite,id_matricule);
							Management management  = new Management(getConnection(),medecin);
							management.setVisible(true);
							management.setLocationRelativeTo(null);
						}else {
							JOptionPane.showMessageDialog(new JFrame(),
								    "Compte n'existe pas ! ",
								    "Warning",
								    JOptionPane.WARNING_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		JButton btnNewButton_1 = new JButton("Inscrivez-Vous !");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription incsription = new Inscription(getConnection());
				incsription.setVisible(true);
				incsription.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("imgs\\add.png"));
		btnNewButton_1.setBounds(46, 226, 130, 23);
		frmCabinetMedical.getContentPane().add(btnNewButton_1);
		
		
		
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
