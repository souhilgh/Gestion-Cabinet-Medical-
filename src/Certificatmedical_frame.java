import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Certificatmedical_frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField id;
	private JTextField code;
	Rendezvous_s rdzs;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Certificatmedical_frame frame = new Certificatmedical_frame();
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
	 * @param connection 
	 * @param medecin 
	 */
	public Certificatmedical_frame(Connection connection, Medecin medecin) {
		rdzs = new Rendezvous_s();
		setTitle("Cabinet Medical");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs\\icon_window.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel((String) medecin.toString());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 525, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 31, 179, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Patient : ");
		lblNewLabel_1.setBounds(10, 64, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(103, 61, 86, 20);
		contentPane.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(103, 101, 86, 20);
		contentPane.add(prenom);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom Patient : ");
		lblNewLabel_2.setBounds(10, 104, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matricule Patient : ");
		lblNewLabel_3.setBounds(10, 146, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(103, 143, 86, 20);
		contentPane.add(id);
		
		JLabel lblNewLabel_4 = new JLabel("Date : ");
		lblNewLabel_4.setBounds(10, 189, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel date_label = new JLabel("");
		date_label.setBounds(55, 189, 134, 14);
		contentPane.add(date_label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(199, 59, 336, 144);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_6 = new JLabel("Texte : ");
		lblNewLabel_6.setBounds(199, 35, 76, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnCertifier = new JButton("Certifier");
		btnCertifier.setIcon(new ImageIcon("imgs\\add.png"));
		
		btnCertifier.setBounds(436, 231, 99, 23);
		contentPane.add(btnCertifier);
		
		JLabel lblNewLabel_5 = new JLabel("Code : ");
		lblNewLabel_5.setBounds(10, 235, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		code = new JTextField();
		code.setBounds(55, 232, 134, 20);
		contentPane.add(code);
		code.setColumns(10);
		
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
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String value = (String) comboBox.getSelectedItem();
		    	System.out.println(value);
		    	String [] values= value.split(" - ");
		    	 for (String a : values)
		             System.out.println(a);
		    	 nom.setText(values[0]);
		    	 prenom.setText(values[1]);
		    	 id.setText(values[2]);
		    	 date_label.setText(rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).toString2());
		    }
		    
		});
		btnCertifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement ;
				try {
					statement = connection.createStatement();
					String matricule_s = id.getText();
					String nom_s = nom.getText();
					String prenom_s = prenom.getText();
					String code_s  = code.getText();
					int day =  rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getJours();
					int month =  rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getMois();;
					int year = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getAnnee();;
					int h = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).heure;
					int  m = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).minute;
						String sql;
							 sql = "INSERT INTO CERTIFICAT_MEDICAL VALUES("+code_s+","+matricule_s
																	+
																		 ",TO_DATE('"+year+"/"+month+"/"+day+"','YYY/MM/DD'),"
																		 + "'"+ textArea.getText()+ "')";
						System.out.println(sql);
						
						statement.execute(sql);
						JOptionPane.showMessageDialog(new JFrame(),
								"Certificat medical ajouté",
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
