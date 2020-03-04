package com.swingdemo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;

import com.swingdemo.model.Student;
import com.swingdemo.service.StudentService;
import com.swingdemo.service.StudentServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JLabel lblDob;
	private JLabel lblGender;
	private JLabel lblCollege;
	private JTextField clz;
	private JLabel lblSemester;
	private JLabel lblFaculty;
	private JLabel lblRollNo;
	private JTextField roll;
	private JLabel lblCountry;
	private JTextField cntry;
	private JLabel lblState;
	private JTextField stat;
	private JLabel lblCity;
	private JTextField cty;
	private JLabel lblEmail;
	private JTextField email;
	private JLabel lblPhone;
	private JTextField phn;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JDateChooser dateChooser;
	private JButton updatebtn;
	JRadioButton maleradiobtn;
	JRadioButton rdbtnFemale;
	JComboBox semester;
	JComboBox faculty;
	int sid = 0;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setTitle("StudentForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1138, 781);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(41, 50, 86, 16);
		contentPane.add(lblNewLabel);

		fname = new JTextField();
		// -------capitalizing--------------
		fname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				fname.setText(makeFirstLetterCapital(fname.getText()));
			}
		});

		fname.setBounds(133, 47, 180, 22);
		contentPane.add(fname);
		fname.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(41, 93, 86, 16);
		contentPane.add(lblLastName);

		lname = new JTextField();
		lname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				lname.setText(makeFirstLetterCapital(lname.getText()));
			}
		});
		lname.setColumns(10);
		lname.setBounds(133, 90, 180, 22);
		contentPane.add(lname);

		lblDob = new JLabel("D.O.B");
		lblDob.setBounds(41, 133, 86, 16);
		contentPane.add(lblDob);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(41, 172, 86, 16);
		contentPane.add(lblGender);

		lblCollege = new JLabel("College");
		lblCollege.setBounds(41, 213, 86, 16);
		contentPane.add(lblCollege);

		clz = new JTextField();

		clz.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				clz.setText(makeFirstLetterCapital(clz.getText()));
			}
		});
		clz.setColumns(10);
		clz.setBounds(133, 210, 180, 22);
		contentPane.add(clz);

		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(41, 255, 86, 16);
		contentPane.add(lblSemester);

		lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(41, 301, 86, 16);
		contentPane.add(lblFaculty);

		lblRollNo = new JLabel("Roll No.");
		lblRollNo.setBounds(41, 348, 86, 16);
		contentPane.add(lblRollNo);

		roll = new JTextField();
		roll.setColumns(10);
		roll.setBounds(133, 345, 180, 22);
		contentPane.add(roll);

		lblCountry = new JLabel("Country");
		lblCountry.setBounds(41, 390, 86, 16);
		contentPane.add(lblCountry);

		cntry = new JTextField();
		cntry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				cntry.setText(makeFirstLetterCapital(cntry.getText()));
			}
		});
		cntry.setColumns(10);
		cntry.setBounds(133, 387, 180, 22);
		contentPane.add(cntry);

		lblState = new JLabel("State");
		lblState.setBounds(41, 446, 86, 16);
		contentPane.add(lblState);

		stat = new JTextField();
		stat.setColumns(10);
		stat.setBounds(133, 443, 180, 22);
		contentPane.add(stat);

		lblCity = new JLabel("City");
		lblCity.setBounds(41, 492, 86, 16);
		contentPane.add(lblCity);

		cty = new JTextField();
		cty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				cty.setText(makeFirstLetterCapital(cty.getText()));
			}
		});
		cty.setColumns(10);
		cty.setBounds(133, 489, 180, 22);
		contentPane.add(cty);

		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(41, 537, 86, 16);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(133, 534, 180, 22);
		contentPane.add(email);

		lblPhone = new JLabel("Phone");
		lblPhone.setBounds(41, 587, 86, 16);
		contentPane.add(lblPhone);

		phn = new JTextField();
		phn.setColumns(10);
		phn.setBounds(133, 584, 180, 22);
		contentPane.add(phn);

		maleradiobtn = new JRadioButton("Male");
		buttonGroup.add(maleradiobtn);
		maleradiobtn.setBounds(133, 168, 55, 25);
		contentPane.add(maleradiobtn);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(205, 168, 71, 25);
		contentPane.add(rdbtnFemale);

		JRadioButton rdbtnOthers = new JRadioButton("Others");
		buttonGroup.add(rdbtnOthers);
		rdbtnOthers.setBounds(296, 168, 71, 25);
		contentPane.add(rdbtnOthers);

		semester = new JComboBox();
		semester.setModel(new DefaultComboBoxModel(
				new String[] { "SEMESTER", "1ST", "2ND", "3RD", "4TH", "5TH", "6TH", "7TH", "8TH" }));
		semester.setBounds(133, 252, 180, 22);
		contentPane.add(semester);

		faculty = new JComboBox();
		faculty.setModel(new DefaultComboBoxModel(new String[] { "FACULTY", "ENGINEERING", "BBA", "B.Sc" }));
		faculty.setBounds(133, 301, 180, 22);
		contentPane.add(faculty);

		JButton savebtn = new JButton("Save");
		savebtn.setBorder(UIManager.getBorder("Button.border"));

		savebtn.setBackground(Color.GREEN);
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// create object
				Student s = new Student();

				// getting value from variables 1st method
				String firstName = fname.getText();
				String lastName = lname.getText();
				String gender;
				if (maleradiobtn.isSelected()) {
					gender = "male";
				} else if (rdbtnFemale.isSelected()) {
					gender = "female";

				} else {
					gender = "others";
				}

				String colz = clz.getText();
				String sem = semester.getSelectedItem().toString();
				String facul = faculty.getSelectedItem().toString();

				// getting value from variables 2nd method
				s.setFname(firstName);

				s.setLname(lastName);
				s.setGender(gender);
				s.setCollege(colz);
				s.setSemester(sem);
				s.setFaculty(facul);
				s.setDob(new Date(dateChooser.getDate().getTime()));
				s.setRollno(Integer.parseInt(roll.getText()));
				s.setCountry(cntry.getText());
				s.setCity(cty.getText());
				s.setState(stat.getText());
				s.setEmail(email.getText());
				s.setPhone(phn.getText());

//				if(firstName.length()==0) {
//					
//					firstName.setError("Enter first name");
//					
//				}else {
//					
//				}

				StudentService ss = new StudentServiceImpl();

				if (sid != 0) {
					s.setId(sid);
					
					if (ss.updateStudent(s)) {
						JOptionPane.showMessageDialog(null, "update success");
						displayData();
					} else {
						JOptionPane.showMessageDialog(null, "update failed");
					}
				} else {

					if (ss.addStudent(s)) {
						JOptionPane.showMessageDialog(null, "added success");
						displayData();
					} else {
						JOptionPane.showMessageDialog(null, "added failed");
					}

				}

//				DefaultTableModel model = (DefaultTableModel) table.getModel();
//				model.addRow(new Object[]{firstName,colz,faculty,sem});

				// ---------reset values for next insertion------

				clearInputForm();

//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
//					
//					String sql = "insert into user(firstname,lastname,gender,college,semester,faculty) values('"+firstName+"','"+lastName+"','"+gender+"','"+colz+"','"+sem+"','"+facul+"' ) ";
//					Statement stm = con.createStatement();
//					stm.executeUpdate(sql);
//					
//					
//
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}

		});
		savebtn.setBounds(133, 675, 97, 25);
		contentPane.add(savebtn);

		JButton btnDelete = new JButton("delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (table_1.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "select any row");
					return;
				}

				int rows[] = table_1.getSelectedRows();

				for (int row : rows) {
					int id = (int) table_1.getModel().getValueAt(row, 0);

					StudentService ss = new StudentServiceImpl();
					ss.deleteStudent(id);
//					if (ss.deleteStudent(id)) {
//						
//					}
				}
				JOptionPane.showMessageDialog(null, "deleted success");
				displayData();
			}
		});
		btnDelete.setBounds(706, 675, 97, 25);
		contentPane.add(btnDelete);

		JButton btnClose = new JButton("close");
		btnClose.setBackground(new Color(255, 99, 71));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		btnClose.setBounds(981, 675, 97, 25);
		contentPane.add(btnClose);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(412, 76, 671, 577);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				editStudentInfo();
			}
		});
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Name", "Country", "College", "Faculty" }));
		scrollPane.setViewportView(table_1);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String input = textField.getText().trim();
				StudentService ss = new StudentServiceImpl();
				List<Student>  slist = ss.search(input);
				
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.setRowCount(0);

				for (Student s : slist) {
					model.addRow(new Object[] { s.getId(), s.getFname() + " " + s.getLname(),
							s.getCity() + ", " + s.getCountry(), s.getCollege(), s.getFaculty() });
				}
				
			}
		});
		textField.setToolTipText("id/name");
		textField.setBounds(874, 47, 170, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(getDateChooser());
		contentPane.add(getUpdatebtn());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());

		displayData();

	}

	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(133, 127, 180, 22);
		}
		return dateChooser;
	}

	// ---------------capitalizing-----------------------

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
//        
//         

		// Convert the char array to equivalent String
		String st = new String(ch);
		return st;

		// return sb.toString();
	}

	// display student data in jtable
	private void displayData() {

		StudentService ss = new StudentServiceImpl();
		List<Student> slist = ss.getAllStudent();

		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);

		for (Student s : slist) {
			model.addRow(new Object[] { s.getId(), s.getFname() + " " + s.getLname(),
					s.getCity() + ", " + s.getCountry(), s.getCollege(), s.getFaculty() });
		}

	}

	private JButton getUpdatebtn() {
		if (updatebtn == null) {
			updatebtn = new JButton("update");
			updatebtn.setBackground(new Color(0, 250, 154));
			updatebtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					// create object
					Student s = new Student();

					s.setId(sid);
					// getting value from variables 1st method

					String firstName = fname.getText();
					String lastName = lname.getText();
					String gender;
					if (maleradiobtn.isSelected()) {
						gender = "male";
					} else if (rdbtnFemale.isSelected()) {
						gender = "female";

					} else {
						gender = "others";
					}

					String colz = clz.getText();
					String sem = semester.getSelectedItem().toString();
					String facul = faculty.getSelectedItem().toString();

					// getting value from variables 2nd method
					s.setFname(firstName);

					s.setLname(lastName);
					s.setGender(gender);
					s.setCollege(colz);
					s.setSemester(sem);
					s.setFaculty(facul);
					s.setDob(new Date(dateChooser.getDate().getTime()));
					s.setRollno(Integer.parseInt(roll.getText()));
					s.setCountry(cntry.getText());
					s.setCity(cty.getText());
					s.setState(stat.getText());
					s.setEmail(email.getText());
					s.setPhone(phn.getText());

//					if(firstName.length()==0) {
//						
//						firstName.setError("Enter first name");
//						
//					}else {
//						
//					}

					StudentService ss = new StudentServiceImpl();

					if (ss.updateStudent(s)) {
						JOptionPane.showMessageDialog(null, "update success");
						displayData();
					} else {
						JOptionPane.showMessageDialog(null, "update failed");
					}

					clearInputForm();
				}
			});
			updatebtn.setBounds(597, 675, 97, 25);
		}
		return updatebtn;
	}

	public void editStudentInfo() {

		int row = table_1.getSelectedRow();
		int id = (int) table_1.getModel().getValueAt(row, 0);
		sid = id;

		StudentService ss = new StudentServiceImpl();
		Student s = ss.getById(id);

		fname.setText(s.getFname());
		lname.setText(s.getLname());
		dateChooser.setDate(s.getDob());
		clz.setText(s.getCollege());
		cntry.setText(s.getCountry());
		cty.setText(s.getCity());
		phn.setText(s.getPhone());
		email.setText(s.getEmail());
		faculty.setSelectedItem(s.getFaculty());
		semester.setSelectedItem(s.getSemester());
		roll.setText(String.valueOf(s.getRollno()));
		stat.setText(s.getState());

		if (s.getGender().equalsIgnoreCase("male")) {
			maleradiobtn.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}

	}

	private void clearInputForm() {
		fname.setText("");
		lname.setText("");
		buttonGroup.clearSelection();
		clz.setText("");
		semester.setSelectedIndex(0);
		faculty.setSelectedIndex(0);
		dateChooser.setCalendar(null);
		roll.setText("");
		cntry.setText("");
		cty.setText("");
		stat.setText("");
		email.setText("");
		phn.setText("");
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Search");
			lblNewLabel_1.setBounds(767, 50, 56, 16);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("print");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						table_1.print();
					} catch (PrinterException e) {
						e.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(825, 675, 97, 25);
		}
		return btnNewButton;
	}
}
