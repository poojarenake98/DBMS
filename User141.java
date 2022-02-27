package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class User141 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User141 frame = new User141();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User141() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PARENT_INFO");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(554, 67, 222, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parent_id");
		lblNewLabel_1.setBackground(new Color(255, 0, 102));
		lblNewLabel_1.setForeground(new Color(102, 51, 51));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(177, 167, 153, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFathername = new JLabel("Father_name");
		lblFathername.setHorizontalAlignment(SwingConstants.CENTER);
		lblFathername.setForeground(new Color(102, 51, 51));
		lblFathername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFathername.setBackground(new Color(255, 0, 102));
		lblFathername.setBounds(177, 251, 153, 39);
		contentPane.add(lblFathername);
		
		JLabel lblMothername = new JLabel("Mother_name");
		lblMothername.setHorizontalAlignment(SwingConstants.CENTER);
		lblMothername.setForeground(new Color(102, 51, 51));
		lblMothername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMothername.setBackground(new Color(255, 0, 102));
		lblMothername.setBounds(177, 330, 153, 39);
		contentPane.add(lblMothername);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setHorizontalAlignment(SwingConstants.CENTER);
		lblNationality.setForeground(new Color(102, 51, 51));
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNationality.setBackground(new Color(255, 0, 102));
		lblNationality.setBounds(177, 399, 153, 39);
		contentPane.add(lblNationality);
		
		textField = new JTextField();
		textField.setBounds(454, 174, 263, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(454, 261, 263, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(454, 340, 263, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(454, 409, 263, 29);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-IOVK88N:xe","system","Admin");
				String query="insert into parent_infos values(?,?,?,?)";
				PreparedStatement st=con.prepareStatement(query);
				st.setString(1, textField.getText());
				st.setString(2, textField_1.getText());
				st.setString(3, textField_2.getText());
				st.setString(4, textField_3.getText());
				st.execute();
					JOptionPane.showMessageDialog(null, "data inserted successfully");
				con.close();
				} catch  (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBackground(new Color(153, 255, 255));
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(889, 229, 153, 33);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("BACK");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User1 m=new User1();
				m.setVisible(true);
			}
		});
		btnUpdate.setBackground(new Color(153, 255, 255));
		btnUpdate.setForeground(new Color(255, 0, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(889, 359, 153, 33);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewp a = null;
				try {
					a = new Viewp();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "view being done");
				a.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(255, 0, 204));
		btnNewButton_1.setBackground(new Color(153, 255, 255));
		btnNewButton_1.setBounds(768, 500, 128, 48);
		contentPane.add(btnNewButton_1);
	}
}
