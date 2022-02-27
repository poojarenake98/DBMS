package mysql;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;

public class Viewp extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewp frame = new Viewp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton_2;
	private JTextField textField_1;
	private JLabel lblFathername;
	private JLabel lblMothername;
	private JTextField textField_2;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Viewp() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-IOVK88N:xe","system","Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 754);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOAD_PARENT_DATA");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select parent_id,father_name,mother_name from parent_infos";
					PreparedStatement st=con.prepareStatement(query);
					ResultSet rs=st.executeQuery();
					JOptionPane.showMessageDialog(null, "connection sucessfully");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(739, 60, 259, 39);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(437, 182, 752, 456);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
		
				String query="delete from parent_infos where parent_id='"+textField.getText()+"' ";
				PreparedStatement st=con.prepareStatement(query);
				
				
				st.execute();
					JOptionPane.showMessageDialog(null, "Data deleted");
				st.close();
				} catch  (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(80, 461, 141, 31);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Parent_id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(63, 205, 77, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(185, 215, 171, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="update parent_infos set parent_id='"+textField.getText()+"' ,father_name='"+textField_1.getText()+"' ,mother_name='"+textField_2.getText()+"'  where parent_id='"+textField.getText()+"' ";
				    PreparedStatement st=con.prepareStatement(query);
				    st.execute();
					  JOptionPane.showMessageDialog(null, "data updated successfully");
				} catch  (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(80, 532, 141, 39);
		contentPane.add(btnNewButton_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(185, 285, 171, 29);
		contentPane.add(textField_1);
		
		lblFathername = new JLabel("Father_name");
		lblFathername.setHorizontalAlignment(SwingConstants.CENTER);
		lblFathername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFathername.setBounds(29, 275, 111, 39);
		contentPane.add(lblFathername);
		
		lblMothername = new JLabel("Mother_name");
		lblMothername.setHorizontalAlignment(SwingConstants.CENTER);
		lblMothername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMothername.setBounds(29, 346, 111, 39);
		contentPane.add(lblMothername);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(185, 344, 171, 29);
		contentPane.add(textField_2);
	}
}
