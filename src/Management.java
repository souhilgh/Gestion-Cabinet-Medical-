import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Management extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param medecin 
	 * @param connection 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*

	/**
	 * Create the frame.
	 */
	public Management(Connection connection, Medecin medecin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs\\icon_window.png"));
		setTitle("Cabinet Medical");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		setBounds(100, 100, 599, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		String value = medecin.toString();
		JLabel lblNewLabel = new JLabel(value);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 21, 563, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultationframe cf = new Consultationframe(connection,medecin);
				cf.setVisible(true);
				cf.setLocationRelativeTo(null);

			}
		});
		btnNewButton.setIcon(new ImageIcon("imgs\\loup.png"));
		btnNewButton.setBounds(26, 83, 161, 146);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Consultation");
		lblNewLabel_1.setBounds(75, 240, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ordonnance_frame of = new Ordonnance_frame(connection,medecin);
				of.setVisible(true);
				of.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("imgs\\ordonnance.png"));
		btnNewButton_1.setBounds(210, 83, 161, 146);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Certificatmedical_frame cmf = new Certificatmedical_frame(connection,medecin);
				cmf.setVisible(true);
				cmf.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("imgs\\certificate.png"));
		btnNewButton_2.setBounds(387, 83, 161, 146);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gestion des Ordonnances");
		lblNewLabel_1_1.setBounds(233, 240, 127, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Certificat Medicales");
		lblNewLabel_1_2.setBounds(418, 240, 94, 14);
		contentPane.add(lblNewLabel_1_2);
	}
}
