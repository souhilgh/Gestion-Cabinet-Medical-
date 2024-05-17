import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Consultationframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField id;
	Rendezvous_s rdzs;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultationframe frame = new Consultationframe();
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
	public Consultationframe(Connection connection, Medecin medecin) {
		rdzs = new Rendezvous_s();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs\\icon_window.png"));
		setTitle("Cabinet Medical");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(medecin.toString());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 525, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Patient : ");
		lblNewLabel_1.setBounds(10, 64, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom Patient : ");
		lblNewLabel_2.setBounds(10, 104, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matricule Patient : ");
		lblNewLabel_3.setBounds(10, 146, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		nom = new JTextField();
		nom.setBounds(103, 61, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(103, 101, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		id = new JTextField();
		id.setBounds(103, 143, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date : ");
		lblNewLabel_4.setBounds(10, 189, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel date_label = new JLabel("");
		date_label.setBounds(55, 189, 134, 14);
		contentPane.add(date_label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 31, 179, 22);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(199, 59, 336, 144);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Consulter");
		
		btnNewButton.setIcon(new ImageIcon("imgs\\add.png"));
		btnNewButton.setBounds(436, 231, 99, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Symptomes : ");
		lblNewLabel_6.setBounds(199, 35, 76, 14);
		contentPane.add(lblNewLabel_6);
		
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
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement ;
				try {
					statement = connection.createStatement();
					String matricule_s = id.getText();
					String nom_s = nom.getText();
					String prenom_s = prenom.getText();
					int day =  rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getJours();
					int month =  rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getMois();;
					int year = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).date.getAnnee();;
					int h = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).heure;
					int  m = rdzs.getRendez_vous().get(comboBox.getSelectedIndex()).minute;
						String sql;
							 sql = "INSERT INTO CONSULTATION VALUES("+matricule_s+","
																		+ medecin.getMatricule()+
																		 ",TO_DATE('"+year+"/"+month+"/"+day+"','YYY/MM/DD'),"
																		 + "'"+ textArea.getText()+ "')";
						System.out.println(sql);
						
						statement.execute(sql);
						JOptionPane.showMessageDialog(new JFrame(),
								"Consultation insérée",
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
