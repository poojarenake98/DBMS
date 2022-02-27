package mysql;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User15 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User15 frame = new User15();
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
	public User15() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROPERTY_INFO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(145, 13, 168, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adhar_id");
		lblNewLabel_1.setBackground(SystemColor.textInactiveText);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(36, 43, 95, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblRegisterid = new JLabel("Register_id");
		lblRegisterid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRegisterid.setBackground(SystemColor.textInactiveText);
		lblRegisterid.setBounds(36, 78, 95, 22);
		contentPane.add(lblRegisterid);
		
		JLabel lblRegistername = new JLabel("Register_name");
		lblRegistername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRegistername.setBackground(SystemColor.textInactiveText);
		lblRegistername.setBounds(36, 113, 114, 22);
		contentPane.add(lblRegistername);
		
		JLabel lblRegisterdate = new JLabel("Register_date");
		lblRegisterdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRegisterdate.setBackground(SystemColor.textInactiveText);
		lblRegisterdate.setBounds(36, 142, 114, 22);
		contentPane.add(lblRegisterdate);
		
		JLabel lblRegister_time = new JLabel("Register_time");
		lblRegister_time.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRegister_time.setBackground(SystemColor.textInactiveText);
		lblRegister_time.setBounds(36, 174, 95, 22);
		contentPane.add(lblRegister_time);
		
		textField = new JTextField();
		textField.setBounds(178, 44, 187, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(178, 79, 187, 22);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(178, 143, 187, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(178, 175, 187, 22);
		contentPane.add(textField_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 113, 187, 22);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-IOVK88N:xe","system","Admin");
				String query="insert into property1 values(?,?,?,?,?)";
				PreparedStatement st=con.prepareStatement(query);
				st.setString(1, textField.getText());
				st.setString(2, textField_1.getText());
				st.setString(3, textField_2.getText());
				st.setString(4,  textField_3.getText());
				st.setString(5, textField_4.getText());
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
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(67, 215, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewprop z = null;
				try {
					z = new Viewprop();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "view being done");
				z.setVisible(true);
				
			}
		});
		btnNewButton_1.setBackground(new Color(153, 255, 255));
		btnNewButton_1.setForeground(new Color(255, 0, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(301, 216, 97, 25);
		contentPane.add(btnNewButton_1);
	}

}
