package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Viewprop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewprop frame = new Viewprop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Viewprop() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-IOVK88N:xe","system","Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1275, 759);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOAD PROPERTY DATA");
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select adhar_id,registration_id,register_name,register_date from property1 ";
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
		btnNewButton.setBounds(718, 55, 274, 46);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 152, 946, 512);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblRegisterid = new JLabel("Register_id");
		lblRegisterid.setForeground(new Color(124, 252, 0));
		lblRegisterid.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegisterid.setBounds(12, 303, 111, 46);
		contentPane.add(lblRegisterid);
		
		JLabel lblRegistereddate = new JLabel("Registered_name");
		lblRegistereddate.setForeground(new Color(124, 252, 0));
		lblRegistereddate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistereddate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistereddate.setBounds(12, 384, 159, 46);
		contentPane.add(lblRegistereddate);
		
		JLabel lblRegistereddate_1 = new JLabel("Registered_date");
		lblRegistereddate_1.setForeground(new Color(124, 252, 0));
		lblRegistereddate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistereddate_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistereddate_1.setBounds(0, 466, 171, 46);
		contentPane.add(lblRegistereddate_1);
		
		JLabel label = new JLabel("Adhar_id");
		label.setForeground(new Color(124, 252, 0));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(12, 244, 111, 46);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(135, 258, 142, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 317, 142, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 398, 122, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(166, 468, 132, 32);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setForeground(new Color(255, 69, 0));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
		
				String query="delete from property1 where adhar_id='"+textField.getText()+"' and registration_id='"+textField_1.getText()+"' ";
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
		btnNewButton_1.setBounds(60, 525, 111, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 69, 0));
		btnUpdate.setBackground(new Color(30, 144, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="update property1 set adhar_id='"+textField.getText()+"' ,registration_id='"+textField_1.getText()+"' ,register_name='"+textField_2.getText()+"',register_date='"+textField_3.getText()+"'    where adhar_id='"+textField.getText()+"' ";
				    PreparedStatement st=con.prepareStatement(query);
				    st.execute();
					  JOptionPane.showMessageDialog(null, "data updated successfully");
				} catch  (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnUpdate.setBounds(60, 599, 111, 46);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User15 s=new User15();
				s.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setForeground(new Color(255, 69, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnNewButton_2.setBounds(176, 674, 97, 25);
		contentPane.add(btnNewButton_2);
	}
}
