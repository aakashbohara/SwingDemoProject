package com.swingdemo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField usernametxt;
	private JTextField passwordtxt;
	private JButton loginbtn;
	private JButton signupbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 385);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getUsernametxt());
		contentPane.add(getPasswordtxt());
		contentPane.add(getLoginbtn());
		contentPane.add(getSignupbtn());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Username");
			lblNewLabel.setBounds(38, 78, 104, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setBounds(38, 176, 83, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getUsernametxt() {
		if (usernametxt == null) {
			usernametxt = new JTextField();
			usernametxt.setBounds(133, 75, 182, 22);
			usernametxt.setColumns(10);
		}
		return usernametxt;
	}
	private JTextField getPasswordtxt() {
		if (passwordtxt == null) {
			passwordtxt = new JTextField();
			passwordtxt.setBounds(133, 173, 182, 22);
			passwordtxt.setColumns(10);
		}
		return passwordtxt;
	}
	private JButton getLoginbtn() {
		if (loginbtn == null) {
			loginbtn = new JButton("Login");
			loginbtn.setBackground(new Color(50, 205, 50));
			loginbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String un = usernametxt.getText();
					String pwd = passwordtxt.getText();
					
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdemo","root","");
						

						String sql = "select username, password from staff where username = '"+un+"' and password = '"+pwd+"' ";
						Statement st = (Statement) con.createStatement();
						ResultSet rs = st.executeQuery(sql);
						

						if(rs.next())
						{
							//JOptionPane.showMessageDialog(null, "Login Successful");
							
							 
							new StudentForm().setVisible(true);
							dispose();
						}else
						{
							JOptionPane.showMessageDialog(null, "Login Failed");
							dispose();
							
							new LoginForm().setVisible(true);
						}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			});
			loginbtn.setBounds(218, 261, 97, 25);
		}
		return loginbtn;
	}
	private JButton getSignupbtn() {
		if (signupbtn == null) {
			signupbtn = new JButton("SignUp");
			signupbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new SignUpForm().setVisible(true);
					dispose();
				}
			});
			signupbtn.setBackground(new Color(0, 206, 209));
			signupbtn.setBounds(385, 32, 97, 25);
		}
		return signupbtn;
	}
}
