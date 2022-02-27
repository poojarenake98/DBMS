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

public class Viewdeath extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewdeath frame = new Viewdeath();
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
	private JTextField textField_4;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Viewdeath() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-IOVK88N:xe","system","Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1275, 749);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOAD DEATH DATA");
		btnNewButton.setForeground(new Color(199, 21, 133));
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from death_info1 ";
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
		btnNewButton.setBounds(728, 61, 292, 43);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 158, 779, 519);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Adhar_id");
		lblNewLabel.setForeground(new Color(123, 104, 238));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 195, 147, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblDeathcerno = new JLabel("Death_cer_no");
		lblDeathcerno.setForeground(new Color(123, 104, 238));
		lblDeathcerno.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeathcerno.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeathcerno.setBounds(12, 264, 147, 36);
		contentPane.add(lblDeathcerno);
		
		JLabel lblDeathdate = new JLabel("Death_date");
		lblDeathdate.setForeground(new Color(123, 104, 238));
		lblDeathdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeathdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeathdate.setBounds(12, 347, 147, 36);
		contentPane.add(lblDeathdate);
		
		JLabel lblDeathtime = new JLabel("Death_time");
		lblDeathtime.setForeground(new Color(123, 104, 238));
		lblDeathtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeathtime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeathtime.setBounds(12, 428, 147, 36);
		contentPane.add(lblDeathtime);
		
		JLabel lblDeathplace = new JLabel("Death_place");
		lblDeathplace.setForeground(new Color(123, 104, 238));
		lblDeathplace.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeathplace.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeathplace.setBounds(12, 505, 147, 36);
		contentPane.add(lblDeathplace);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1.setForeground(new Color(199, 21, 133));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
		
				String query="delete from death_info1 where adhar_id='"+textField.getText()+"' and death_certificate_no='"+textField_1.getText()+"'  ";
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
		btnNewButton_1.setBounds(89, 572, 97, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(199, 21, 133));
		btnUpdate.setBackground(new Color(127, 255, 212));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="update death_info1 set adhar_id='"+textField.getText()+"' ,death_certificate_no='"+textField_1.getText()+"' ,death_date='"+textField_2.getText()+"',death_time='"+textField_3.getText()+"' ,death_place='"+textField_4.getText()+"'    where death_certificate_no='"+textField_1.getText()+"' ";
				    PreparedStatement st=con.prepareStatement(query);
				    st.execute();
					  JOptionPane.showMessageDialog(null, "data updated successfully");
				} catch  (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnUpdate.setBounds(292, 572, 113, 43);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User1 e=new User1();
				e.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(127, 255, 212));
		btnBack.setForeground(new Color(199, 21, 133));
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnBack.setBounds(187, 632, 97, 43);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(215, 204, 190, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 273, 190, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(215, 347, 190, 36);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(215, 428, 190, 36);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(215, 505, 190, 36);
		contentPane.add(textField_4);
	}

}
