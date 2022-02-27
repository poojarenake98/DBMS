package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Viewbirth extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewbirth frame = new Viewbirth();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Viewbirth() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-IOVK88N:xe","system","Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 758);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOAD BIRTH DATA");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from birth_info ";
					PreparedStatement st=con.prepareStatement(query);
					ResultSet rs=st.executeQuery();
					JOptionPane.showMessageDialog(null, "connection sucessfully");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(791, 74, 265, 49);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(432, 178, 777, 492);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Birth_id");
		lblNewLabel.setForeground(new Color(204, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 217, 102, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblBirthdate = new JLabel("Birth_date");
		lblBirthdate.setForeground(new Color(204, 255, 0));
		lblBirthdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthdate.setBounds(31, 299, 102, 32);
		contentPane.add(lblBirthdate);
		
		JLabel lblBirthtime = new JLabel("Birth_place");
		lblBirthtime.setForeground(new Color(204, 255, 0));
		lblBirthtime.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBirthtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthtime.setBounds(31, 380, 102, 32);
		contentPane.add(lblBirthtime);
		
		textField = new JTextField();
		textField.setBounds(184, 223, 182, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 299, 182, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(184, 380, 182, 32);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setBackground(new Color(204, 204, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
		
				String query="delete from birth_info where birth_id='"+textField.getText()+"' ";
				PreparedStatement st=con.prepareStatement(query);
				
				st.execute();
					JOptionPane.showMessageDialog(null, "Data deleted");
				st.close();
				} catch  (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnNewButton_1.setBounds(148, 521, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(204, 204, 0));
		btnUpdate.setForeground(new Color(220, 20, 60));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="update birth_info set birth_id='"+textField.getText()+"' ,birth_date='"+textField_1.getText()+"' ,birth_place='"+textField_2.getText()+"' ,birth_time='"+textField_3.getText()+"'  where birth_id='"+textField.getText()+"' ";
				    PreparedStatement st=con.prepareStatement(query);
				    st.execute();
					  JOptionPane.showMessageDialog(null, "data updated successfully");
				} catch  (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnUpdate.setBounds(128, 596, 148, 25);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User13 s=new User13();
				s.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(153, 204, 0));
		btnBack.setForeground(new Color(220, 20, 60));
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnBack.setBounds(311, 642, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblBirthtime_1 = new JLabel("Birth_time");
		lblBirthtime_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthtime_1.setForeground(new Color(204, 255, 0));
		lblBirthtime_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBirthtime_1.setBounds(31, 438, 102, 32);
		contentPane.add(lblBirthtime_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(184, 444, 182, 32);
		contentPane.add(textField_3);
	}
}
