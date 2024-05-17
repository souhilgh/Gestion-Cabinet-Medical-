import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Rendezvousframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField telephone;
	private JTextField prenom;
	private JTextField nom;
	private JTable table;
	private JTextField matricule;
	private JTextField adresse;
	private int medecin_matricule;
	  private String medecin_nom;
	  private String medecin_prenom;
	  private String medecin_specialite;
	  private String medecin_adresse;
	    public String getMedecin_adresse() {
		return medecin_adresse;
	}

	public void setMedecin_adresse(String medecin_adresse) {
		this.medecin_adresse = medecin_adresse;
	}

		public String getMedecin_specialite() {
		return medecin_specialite;
	}

	public void setMedecin_specialite(String medecin_specialite) {
		this.medecin_specialite = medecin_specialite;
	}

		public String getMedecin_nom() {
		return medecin_nom;
	}

	public void setMedecin_nom(String medecin_nom) {
		this.medecin_nom = medecin_nom;
	}

	public String getMedecin_prenom() {
		return medecin_prenom;
	}

	public void setMedecin_prenom(String medecin_prennom) {
		this.medecin_prenom = medecin_prennom;
	}


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rendezvousframe frame = new Rendezvousframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public int getMedecin_matricule() {
		return medecin_matricule;
	}

	public void setMedecin_matricule(int medecin_matricule) {
		this.medecin_matricule = medecin_matricule;
	}

	/**
	 * Create the frame.
	 * @param connection 
	 * @param secretaire 
	 */
	public Rendezvousframe(Connection connection, Secretaire secretaire) {
		setTitle("Cabinet Medical");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs\\icon_window.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 904, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des Rendez-Vous !");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(296, 11, 245, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date : ");
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1712790000000L), new Date(1712790000000L), null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(85, 59, 121, 20);
		contentPane.add(spinner);
		
		JButton ajouter = new JButton("Ajouter");
		
		ajouter.setIcon(new ImageIcon("imgs\\ajouter.png"));
		ajouter.setBounds(117, 358, 89, 23);
		contentPane.add(ajouter);
		
		JComboBox medecin_comboBox = new JComboBox();
		medecin_comboBox.setBounds(85, 87, 121, 22);
		contentPane.add(medecin_comboBox);
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT ID_MEDECIN,NOM_MEDECIN, PRENOM_MEDECIN , SPECIALITE_MEDECIN, ADRESSE_MEDECIN FROM MEDECIN";
			ResultSet rs = statement.executeQuery(sql);
			int i = 0;
			  this.medecin_nom = "";this.medecin_prenom = ""; this.medecin_matricule = 0;this.medecin_specialite="";this.medecin_adresse="";
		        while (rs.next()) {
		            i++;
		            this.medecin_nom = rs.getString("NOM_MEDECIN");
		            this.medecin_prenom  = rs.getString("PRENOM_MEDECIN");
		            this.medecin_matricule  = rs.getInt("ID_MEDECIN");
		            this.medecin_specialite=rs.getString("SPECIALITE_MEDECIN");
		            this.medecin_adresse=rs.getString("ADRESSE_MEDECIN");
		            medecin_comboBox.addItem(this.medecin_nom+ "-" + this.medecin_prenom + "-" + this.medecin_matricule);
		        }
		        
		       
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel lblNewLabel_2 = new JLabel("Medecin : ");
		lblNewLabel_2.setBounds(10, 91, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom : ");
		lblNewLabel_3.setBounds(10, 168, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom : ");
		lblNewLabel_4.setBounds(10, 193, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age : ");
		lblNewLabel_5.setBounds(10, 218, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sexe : ");
		lblNewLabel_6.setBounds(10, 280, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Telephone : ");
		lblNewLabel_7.setBounds(10, 312, 65, 14);
		contentPane.add(lblNewLabel_7);
		
		telephone = new JTextField();
		telephone.setBounds(85, 309, 121, 20);
		contentPane.add(telephone);
		telephone.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(85, 190, 121, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(85, 165, 121, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		JComboBox sexe = new JComboBox();
		sexe.addItem("M");
		sexe.addItem("F");
		sexe.setBounds(85, 279, 121, 22);
		contentPane.add(sexe);
		
		JSpinner age = new JSpinner();
		age.setModel(new SpinnerNumberModel(18, 0, 120, 1));
		age.setBounds(85, 215, 121, 20);
		contentPane.add(age);
		
		JLabel lblNewLabel_8 = new JLabel("Patient : ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(73, 120, 89, 14);
		contentPane.add(lblNewLabel_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(286, 87, 592, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_8_1 = new JLabel("Liste de Rendez-Vous Disponible : ");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(286, 61, 255, 14);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel secretaire_label = new JLabel("");
		secretaire_label.setBounds(10, 36, 420, 14);
		contentPane.add(secretaire_label);
		secretaire_label.setText(secretaire.toString());
		
		JLabel lblNewLabel_9 = new JLabel("Matricule : ");
		lblNewLabel_9.setBounds(10, 143, 75, 14);
		contentPane.add(lblNewLabel_9);
		
		matricule = new JTextField();
		matricule.setBounds(85, 140, 121, 20);
		contentPane.add(matricule);
		matricule.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Adresse : ");
		lblNewLabel_10.setBounds(10, 244, 65, 14);
		contentPane.add(lblNewLabel_10);
		
		adresse = new JTextField();
		adresse.setBounds(85, 241, 121, 20);
		contentPane.add(adresse);
		adresse.setColumns(10);
		try {
			Statement statement2;
			statement2 = connection.createStatement();
			String sql2 = "SELECT ID_SECRETAIRE,ID_PATIENT, ID_MEDECIN , DATE_RENDEZ_VOUS, HEURE, MINUTES FROM RENDEZ_VOUS";
			ResultSet rs2 = statement2.executeQuery(sql2);
			table.setModel(DbUtils.resultSetToTableModel(rs2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement ;
				try {
					statement = connection.createStatement();
					String matricule_s = matricule.getText();
					String nom_s = nom.getText();
					String prenom_s = prenom.getText();
					String adresse_s = adresse.getText();
					String age_s = age.getValue()+"";
					String sexe_s= (String) sexe.getSelectedItem();
					String telephone_s = telephone.getText();
						String sql;
							 sql = "INSERT INTO PATIENT VALUES("+matricule_s+",'"
																		+ nom_s+"','"
																		+ prenom_s+"','"
																		+ adresse_s+"',"
																		+ age_s+",'"
																		+ sexe_s +"',"
																		+ telephone_s+")";
						System.out.println(sql);
						statement.execute(sql);
						Date value = (Date) spinner.getModel().getValue();

//						System.out.println("date " + spinner.getValue().toString());
						int day =  value.getDate();
						int month =  value.getMonth();
						int year = value.getYear();
						int h = value.getHours();
						int  m = value.getMinutes();
					String sql2 = "INSERT INTO RENDEZ_VOUS VALUES("+secretaire.getMatricule()+","
							+ matricule_s+","
							+ getMedecin_matricule() +","
							+ "TO_DATE('"+year+"/"+month+"/"+day+"','YYY/MM/DD'),"
							+ h+","
							+ m + ")";
					System.out.println(sql2);
					//Medecin medecin = new Medecin(getMedecin_nom(),getMedecin_prenom(),getMedecin_adresse(),getMedecin_specialite(),getMedecin_matricule());
					//Patient p = new Patient(nom_s,prenom_s,adresse_s,Integer.parseInt(age_s),sexe_s.toCharArray()[0],Integer.parseInt(telephone_s) );
					//Rendez_vous rdz = new Rendez_vous(new Dates(day,month,year),h,m,p,medecin);
					//secretaire.fixer_rendezVous(rdz);
					statement.execute(sql2);
					System.out.println(sql2);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(),
							e1.toString(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);					
				}
				try {
					Statement statement2;
					statement2 = connection.createStatement();
					String sql2 = "SELECT ID_SECRETAIRE,ID_PATIENT, ID_MEDECIN , DATE_RENDEZ_VOUS, HEURE, MINUTES FROM RENDEZ_VOUS";
					ResultSet rs2 = statement2.executeQuery(sql2);
					table.setModel(DbUtils.resultSetToTableModel(rs2));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
	}
}
