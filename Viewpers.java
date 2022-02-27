package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Viewpers extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewpers frame = new Viewpers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Viewpers() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-IOVK88N:xe","system","Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(366, 207, 816, 475);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("DELETE ");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 69, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
		
				String query="delete from personal_info2 where adhar_id='"+textField.getText()+"' ";
				PreparedStatement st=con.prepareStatement(query);
				
				st.execute();
					JOptionPane.showMessageDialog(null, "Data deleted");
				st.close();
				} catch  (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(33, 599, 112, 42);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(0, 0, 128));
		btnUpdate.setForeground(new Color(255, 69, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="update personal_info2 set parent_id='"+textField.getText()+"' ,name='"+textField_1.getText()+"' ,birth_id='"+textField_2.getText()+"',age='"+textField_3.getText()+"' ,qualification='"+textField_4.getText()+"'    where adhar_id='"+textField.getText()+"' ";
				    PreparedStatement st=con.prepareStatement(query);
				    st.execute();
					  JOptionPane.showMessageDialog(null, "data updated successfully");
				} catch  (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(198, 599, 112, 42);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User1 n=new User1();
				n.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(0, 0, 128));
		btnBack.setForeground(new Color(255, 69, 0));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(114, 654, 112, 42);
		contentPane.add(btnBack);
		
		JButton btnNewButton_1 = new JButton("LOAD PERSONAL DATA");
		btnNewButton_1.setForeground(new Color(240, 128, 128));
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select adhar_id,name,birth_id,age,qualification from personal_info2 ";
					PreparedStatement st=con.prepareStatement(query);
					ResultSet rs=st.executeQuery();
					JOptionPane.showMessageDialog(null, "connection sucessfully");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(669, 84, 309, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(255, 20, 147));
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(12, 431, 96, 23);
		contentPane.add(lblAge);
		
		JLabel lblAdharid = new JLabel("Adhar_id");
		lblAdharid.setForeground(new Color(255, 20, 147));
		lblAdharid.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdharid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdharid.setBounds(12, 243, 96, 34);
		contentPane.add(lblAdharid);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 20, 147));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 303, 96, 23);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(114, 243, 196, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Birth_id");
		label.setForeground(new Color(255, 20, 147));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(12, 379, 96, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Qualification");
		label_1.setForeground(new Color(255, 20, 147));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(12, 486, 112, 23);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 304, 196, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(114, 368, 196, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(114, 420, 196, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(141, 487, 196, 34);
		contentPane.add(textField_4);
		
		JButton btnQuery = new JButton("Query");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select name,registration_id from personal_info2 a,property1 p  where a.adhar_id=p.adhar_id ";
					PreparedStatement st=con.prepareStatement(query);
					ResultSet rs=st.executeQuery();
					JOptionPane.showMessageDialog(null, "connection sucessfully");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
			});
		btnQuery.setForeground(new Color(255, 69, 0));
		btnQuery.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnQuery.setBackground(new Color(0, 0, 128));
		btnQuery.setBounds(114, 534, 112, 42);
		contentPane.add(btnQuery);
	}
}
