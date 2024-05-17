import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class Ordonnance_frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField code_medicament;
	private JTextField nom_medicament;
	private JTextField dose;
	private JTextField nb_jours;
	Rendezvous_s rdzs;
	private JTextField code_ordonnace;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordonnance_frame frame = new Ordonnance_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 * @param medecin 
	 * @param connection 
	 */
	public Ordonnance_frame(Connection connection, Medecin medecin) {
		rdzs = new Rendezvous_s();
		setResizable(false);
		setTitle("Cabinet Medical");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs\\icon_window.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(medecin.toString());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 561, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter un medicament : ");
		lblNewLabel_1.setBounds(20, 42, 121, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Code : ");
		lblNewLabel_2.setBounds(20, 79, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom : ");
		lblNewLabel_3.setBounds(20, 114, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		code_medicament = new JTextField();
		code_medicament.setBounds(71, 73, 86, 20);
		contentPane.add(code_medicament);
		code_medicament.setColumns(10);
		
		nom_medicament = new JTextField();
		nom_medicament.setBounds(71, 108, 86, 20);
		contentPane.add(nom_medicament);
		nom_medicament.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		
		btnNewButton.setIcon(new ImageIcon("imgs\\add.png"));
		btnNewButton.setBounds(39, 153, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dose et nombre de jours :");
		lblNewLabel_1_1.setBounds(20, 203, 137, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Dose : ");
		lblNewLabel_4.setBounds(20, 246, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		dose = new JTextField();
		dose.setBounds(71, 243, 86, 20);
		contentPane.add(dose);
		dose.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("NB Jours : ");
		lblNewLabel_5.setBounds(20, 286, 58, 14);
		contentPane.add(lblNewLabel_5);
		
		nb_jours = new JTextField();
		nb_jours.setBounds(71, 283, 86, 20);
		contentPane.add(nb_jours);
		nb_jours.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ajouter ");
		
		btnNewButton_1.setIcon(new ImageIcon("imgs\\add.png"));
		btnNewButton_1.setBounds(39, 314, 102, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(352, 84, 137, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Patient : ");
		lblNewLabel_6.setBounds(290, 88, 52, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Associer Ordonnance à un patient : ");
		lblNewLabel_7.setBounds(297, 42, 192, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Code : ");
		lblNewLabel_8.setBounds(290, 126, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		code_ordonnace = new JTextField();
		code_ordonnace.setBounds(352, 123, 86, 20);
		contentPane.add(code_ordonnace);
		code_ordonnace.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Date : ");
		lblNewLabel_9.setBounds(290, 166, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel date = new JLabel("");
		date.setText("");
		date.setBounds(352, 166, 137, 14);
		contentPane.add(date);
		
		JButton btnNewButton_2 = new JButton("Associer");
		
		btnNewButton_2.setIcon(new ImageIcon("imgs\\add.png"));
		btnNewButton_2.setBounds(352, 208, 102, 23);
		contentPane.add(btnNewButton_2);
		
		JComboBox list_medicament = new JComboBox();
		list_medicament.setBounds(290, 251, 219, 22);
		contentPane.add(list_medicament);
		
		JButton btnNewButton_3 = new JButton("Ajouter Medicament à Ordonnance");
	
		btnNewButton_3.setIcon(new ImageIcon("imgs\\add.png"));
		btnNewButton_3.setBounds(290, 291, 219, 23);
		contentPane.add(btnNewButton_3);
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT PATIENT.ID_PATIENT,PATIENT.NOM_PATIENT, PATIENT.PRENOM_PATIENT, RENDEZ_VOUS.ID_MEDECIN"
					+ ", RENDEZ_VOUS.DATE_RENDEZ_VOUS, RENDEZ_VOUS.HEURE, RENDEZ_VOUS.MINUTES " +
					" FROM PATIENT, RENDEZ_VOUS WHERE " + " RENDEZ_VOUS.ID_MEDECIN = " + 
					medecin.getMatricule()+" AND PATIENT.ID_PATIENT = RENDEZ_VOUS.ID_PATIENT";
			System.out.println(sql);
			ResultSet rs = statement.executeQuery(sql);
			int i = 0;
			String nom_s ="",prenom_s="";int heure=0,minutes=0,id_s=0;Date date_s;
		        while (rs.next()) {
		            i++;
		            nom_s = rs.getString("NOM_PATIENT");
		            prenom_s  = rs.getString("PRENOM_PATIENT");
		            id_s  = rs.getInt("ID_PATIENT");
		            date_s= rs.getDate("DATE_RENDEZ_VOUS");
		            heure = rs.getInt("HEURE");
		            minutes = rs.getInt("MINUTES");
					Rendez_vous rdz = new Rendez_vous( new Dates(date_s.getDay(),date_s.getMonth(),date_s.getYear()),heure,minutes,medecin);
					rdzs.getRendez_vous().add(rdz);
		           comboBox.addItem(nom_s + " - " + prenom_s + " - " + id_s);
		        }
		        
		       
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement ;
				try {
					statement = connection.createStatement();
					String code_s = code_medicament.getText();
					String nom_s = nom_medicament.getText();
					
						String sql;
							 sql = "INSERT INTO MEDICAMENT VALUES("+code_s+",'"+nom_s
																	+
																		 "')";
						System.out.println(sql);
						
						statement.execute(sql);
						JOptionPane.showMessageDialog(new JFrame(),
								"Medicament ajouté",
							    "Error",
							    JOptionPane.INFORMATION_MESSAGE);	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(),
							e1.toString(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement ;
				//String value = (String) comboBox.getSelectedItem();
			//	String [] values  = value.split(" - ");
				//System.out.println(value);
		//		String id_patient= values[2];
				try {
					statement = connection.createStatement();
					String code_s = code_medicament.getText();
					String dose_s = dose.getText();
					String nb_jours_s = nb_jours.getText();
						String sql;
							 sql = "INSERT INTO AVOIR2 VALUES("+code_s+","+dose_s+","+ nb_jours_s
																	+
																		 ")";
						System.out.println(sql);
						
						statement.execute(sql);
						JOptionPane.showMessageDialog(new JFrame(),
								"Dose et nb_jours ajoutés",
							    "Error",
							    JOptionPane.INFORMATION_MESSAGE);	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(),
							e1.toString(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);					
				}
				
			}
		});
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String value = (String) comboBox.getSelectedItem();
		    	System.out.println(value);
		    	String [] values= value.split(" - ");
		    	 for (String a : values)
		             System.out.println(a);
		    	date.setText(rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).toString2());
		    }
		    
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String) comboBox.getSelectedItem();
				String [] values  = value.split(" - ");
				System.out.println(value);
				String id_patient= values[2];
				Statement statement ;
				try {
					statement = connection.createStatement();
					String code_s = code_ordonnace.getText();
					int day =  rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getJours();
					int month =  rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getMois();;
					int year = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getAnnee();;
					int h = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).heure;
					int  m = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).minute;
						String sql;
							 sql = "INSERT INTO ORDONANCE VALUES("+code_s+","+id_patient+","+  
									 								"TO_DATE('"+year+"/"+month+"/"+day+"','YYY/MM/DD')"+
																		 ")";
						System.out.println(sql);
						
						statement.execute(sql);
						JOptionPane.showMessageDialog(new JFrame(),
								"Ordonnance Associée",
							    "Error",
							    JOptionPane.INFORMATION_MESSAGE);	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(),
							e1.toString(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		
		Statement statement1;
		try {
			statement1 = connection.createStatement();
			String sql = "SELECT ID_MEDICAMENT, NOM_MEDICAMENT FROM MEDICAMENT";
			System.out.println(sql);
			ResultSet rs = statement1.executeQuery(sql);
			int i = 0;
			String nom_s ="";int id=0;
		        while (rs.next()) {
		            i++;
		            nom_s = rs.getString("NOM_MEDICAMENT");
		            id  = rs.getInt("ID_MEDICAMENT");
		           list_medicament.addItem(nom_s + " - " + id);
		        }
		     				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement ;
				String value = (String) list_medicament.getSelectedItem();
				String [] values  = value.split(" - ");
				System.out.println(value);
				String id_medicament= values[1];
				String value1 = (String) comboBox.getSelectedItem();
				String [] values1  = value1.split(" - ");
				System.out.println(value1);
				String id_patient= values1[2];
				try {
					statement = connection.createStatement();
					String code_s = code_ordonnace.getText();
						String sql;
							 sql = "INSERT INTO AVOIR VALUES("+code_s+","+id_medicament+","+ id_patient
																	+
																		 ")";
						System.out.println(sql);
						
						statement.execute(sql);
						JOptionPane.showMessageDialog(new JFrame(),
								"Medicament ajouté à l'ordonnance",
							    "Error",
							    JOptionPane.INFORMATION_MESSAGE);	
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
