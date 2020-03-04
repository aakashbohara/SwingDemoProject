package com.swingdemo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import com.swingdemo.model.Staff;
import com.swingdemo.service.StaffService;
import com.swingdemo.service.StaffServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUpForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblAddress;
	private JLabel lblBranch;
	private JLabel lblBranch_1;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField nametxt;
	private JTextField addresstxt;
	private JTextField usernametxt;
	private JButton signupbtn;
	private JLabel lblNewLabel_1;
	private JButton login1btn;
	private JComboBox branchcombobox;
	private JDateChooser dateChooser;
	private JPasswordField passwordField;
	private JLabel msgnamelabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpForm frame = new SignUpForm();
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
	public SignUpForm() {
		setTitle("SIgnUp Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 749);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblAddress());
		contentPane.add(getLblBranch());
		contentPane.add(getLblBranch_1());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getNametxt());
		contentPane.add(getAddresstxt());
		contentPane.add(getUsernametxt());
		contentPane.add(getSignupbtn());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLogin1btn());
		contentPane.add(getBranchcombobox());
		contentPane.add(getDateChooser());
		contentPane.add(getPasswordField());
		contentPane.add(getMsgnamelabel());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Name");
			lblNewLabel.setBounds(37, 49, 110, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(37, 110, 110, 16);
		}
		return lblAddress;
	}
	private JLabel getLblBranch() {
		if (lblBranch == null) {
			lblBranch = new JLabel("D.O.B");
			lblBranch.setBounds(37, 166, 110, 16);
		}
		return lblBranch;
	}
	private JLabel getLblBranch_1() {
		if (lblBranch_1 == null) {
			lblBranch_1 = new JLabel("Branch");
			lblBranch_1.setBounds(37, 226, 110, 16);
		}
		return lblBranch_1;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setBounds(37, 290, 110, 16);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(37, 356, 110, 16);
		}
		return lblPassword;
	}
	private JTextField getNametxt() {
		if (nametxt == null) {
			nametxt = new JTextField();
			
			nametxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {

					nametxt.setText(makeFirstLetterCapital(nametxt.getText()));
				}
			});
			nametxt.setBounds(159, 46, 231, 22);
			nametxt.setColumns(10);
		}
		return nametxt;
	}
	private JTextField getAddresstxt() {
		if (addresstxt == null) {
			addresstxt = new JTextField();
			addresstxt.setColumns(10);
			addresstxt.setBounds(159, 107, 231, 22);
		}
		return addresstxt;
	}
	private JTextField getUsernametxt() {
		if (usernametxt == null) {
			usernametxt = new JTextField();
			usernametxt.setColumns(10);
			usernametxt.setBounds(159, 287, 231, 22);
		}
		return usernametxt;
	}
	private JButton getSignupbtn() {
		if (signupbtn == null) {
			signupbtn = new JButton("SignUp");
			signupbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Staff st = new Staff();
					
					st.setName(nametxt.getText());
					st.setAddress(addresstxt.getText());
					st.setDateofbirth(new Date(dateChooser.getDate().getTime()));
					st.setBranch(branchcombobox.getSelectedItem().toString());
					st.setUsername(usernametxt.getText());
					st.setPassword(passwordField.getText());
					
					
					StaffService ss = new StaffServiceImpl();
					
					
					
					if(ss.addStaff(st))
					{
						JOptionPane.showMessageDialog(null, "successfully saved");
					}else
					{
						JOptionPane.showMessageDialog(null, "Failed");
					}
					
					clearInputForm();
					
					
				
					
				
					
					
					
					
					
					
					
				}
			});
			signupbtn.setBackground(new Color(255, 215, 0));
			signupbtn.setBounds(204, 443, 110, 25);
		}
		return signupbtn;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("already have an account?");
			lblNewLabel_1.setBounds(37, 522, 155, 16);
		}
		return lblNewLabel_1;
	}
	private JButton getLogin1btn() {
		if (login1btn == null) {
			login1btn = new JButton("Login");
			login1btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			login1btn.setBackground(new Color(0, 250, 154));
			login1btn.setBounds(204, 518, 110, 25);
		}
		return login1btn;
	}
	private JComboBox getBranchcombobox() {
		if (branchcombobox == null) {
			branchcombobox = new JComboBox();
			branchcombobox.setModel(new DefaultComboBoxModel(new String[] {"                  ---BRANCH---", "HR", "TEACHER", "SECURITY", "CANTEEN"}));
			branchcombobox.setBounds(159, 223, 231, 22);
		}
		return branchcombobox;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(159, 160, 231, 22);
		}
		return dateChooser;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(159, 353, 231, 22);
		}
		return passwordField;
	}
	
	private void clearInputForm() {
		nametxt.setText("");
		addresstxt.setText("");
		dateChooser.setCalendar(null);
		usernametxt.setText("");
		passwordField.setText("");
//		lname.setText("");
//		buttonGroup.clearSelection();
//		clz.setText("");
//		semester.setSelectedIndex(0);
//		faculty.setSelectedIndex(0);
//		dateChooser.setCalendar(null);
//		roll.setText("");
//		cntry.setText("");
//		cty.setText("");
//		stat.setText("");
//		email.setText("");
//		phn.setText("");
	}
	private JLabel getMsgnamelabel() {
		if (msgnamelabel == null) {
			msgnamelabel = new JLabel("");
			msgnamelabel.setBounds(389, 49, 56, 16);
		}
		return msgnamelabel;
	}
	
	private String makeFirstLetterCapital(String str) {

		// Create a char array of given String
		char ch[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {

			// If first character of a word is found
			if (i == 0 && ch[i] != ' ' || ch[i] != ' ' && ch[i - 1] == ' ') {

				// If it is in lower-case
				if (ch[i] >= 'a' && ch[i] <= 'z') {

					// Convert into Upper-case
					ch[i] = (char) (ch[i] - 'a' + 'A');
				}
			}

			// If apart from first character
			// Any one is in Upper-case
			else if (ch[i] >= 'A' && ch[i] <= 'Z')

				// Convert into Lower-Case
				ch[i] = (char) (ch[i] + 'a' - 'A');
		}      

		// Convert the char array to equivalent String
		String st = new String(ch);
		return st;

		// return sb.toString();
	}
	
	
}
