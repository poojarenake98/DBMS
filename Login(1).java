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
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Login() throws SQLException {
		setBackground(new Color(112, 128, 144));
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:DESKTOP-I0VK88N:xe","system","Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setForeground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 111, 135, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(255, 69, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPassword.setBackground(SystemColor.desktop);
		lblPassword.setBounds(117, 210, 135, 36);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.window);
		textField.setBounds(363, 111, 278, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.window);
		passwordField.setEchoChar('*');
		passwordField.setBounds(363, 210, 278, 31);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Username=textField.getText();
				String password=passwordField.getText();
				
				if((Username.equals("Admin")) && (password.equals("password")))
				{
					JOptionPane.showMessageDialog(null, "login successfull");
					User1 o=new User1();
					o.setVisible(true);
				    
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "login unsuccessfull");
			
				}
				
		}
	});
		
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(257, 331, 202, 57);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("LOGIN INFORMATION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 51, 102));
		label.setFont(new Font("Times New Roman", Font.BOLD, 26));
		label.setBackground(new Color(128, 0, 128));
		label.setBounds(447, 25, 368, 44);
		contentPane.add(label);
	}
}
