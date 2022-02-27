package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class User1 extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User1 frame = new User1();
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
	public User1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 754);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CENSUS RECORD");
		lblNewLabel.setForeground(SystemColor.controlDkShadow);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(359, 45, 648, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BIRTH_INFO");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User13 a=new User13();
				a.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(554, 212, 266, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PARENT_INFO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User141 v=new User141();
				v.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(554, 282, 266, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PROPERTY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User15 n=new User15();
				n.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(554, 348, 266, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DEATH_INFO");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Userdea r=new Userdea();
				r.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_3.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_3.setBounds(554, 417, 266, 31);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login a = null;
				try {
					a = new Login();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setBounds(932, 522, 97, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("PERSONEL_INFO");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User12Info1 q=new User12Info1();
				q.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_5.setBounds(554, 143, 266, 31);
		contentPane.add(btnNewButton_5);
	}
}
