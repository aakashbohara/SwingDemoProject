package com.swingdemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.swingdemo.db.DB;
import com.swingdemo.model.Student;

public class StudentServiceImpl implements StudentService {

	Connection con = null;

	public StudentServiceImpl() {

		con = DB.getDbCon();
	}

	@Override
	public boolean addStudent(Student s) {
		String sql = "insert into student(firstname,lastname,gender,college,semester,faculty,dateofbirth,rollno,country,state,city,email,phone) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getFname());
			pstm.setString(2, s.getLname());
			pstm.setString(3, s.getGender());
			pstm.setString(4, s.getCollege());
			pstm.setString(5, s.getSemester());
			pstm.setString(6, s.getFaculty());
			pstm.setDate(7, s.getDob());
			pstm.setInt(8, s.getRollno());
			pstm.setString(9, s.getCountry());
			pstm.setString(10, s.getState());
			pstm.setString(11, s.getCity());
			pstm.setString(12, s.getEmail());
			pstm.setString(13, s.getPhone());

			pstm.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteStudent(int id) {

		String sql = "delete from student where id = " + id;
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		 
		String sql = "update  student set firstname=?,lastname=?,gender=?,college=?,semester=?,faculty=?,dateofbirth=?,rollno=?,country=?,state=?,city=?,email=?,phone=? where id=? ";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getFname());
			pstm.setString(2, s.getLname());
			pstm.setString(3, s.getGender());
			pstm.setString(4, s.getCollege());
			pstm.setString(5, s.getSemester());
			pstm.setString(6, s.getFaculty());
			pstm.setDate(7, s.getDob());
			pstm.setInt(8, s.getRollno());
			pstm.setString(9, s.getCountry());
			pstm.setString(10, s.getState());
			pstm.setString(11, s.getCity());
			pstm.setString(12, s.getEmail());
			pstm.setString(13, s.getPhone());
			pstm.setInt(14, s.getId());

			pstm.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		return false;
	}

	@Override
	public Student getById(int id) {

		Student s = new Student();

		String sql = "select * from student where id=" + id;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				s.setId(rs.getInt("id"));
				s.setFaculty(rs.getString("faculty"));
				s.setFname(rs.getString("firstname"));
				s.setLname(rs.getString("lastname"));
				s.setCity(rs.getString("city"));
				s.setCountry(rs.getString("country"));
				s.setCollege(rs.getString("college"));
				s.setDob(rs.getDate("dateofbirth"));
				s.setPhone(rs.getString("phone"));
				s.setGender(rs.getString("gender"));
				s.setEmail(rs.getString("email"));
				s.setSemester(rs.getString("semester"));
				s.setState(rs.getString("state"));
				s.setRollno(rs.getInt("rollno"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public List<Student> getAllStudent() {

		List<Student> slist = new ArrayList<Student>();

		String sql = "select * from student";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFaculty(rs.getString("faculty"));
				s.setFname(rs.getString("firstname"));
				s.setLname(rs.getString("lastname"));
				s.setCity(rs.getString("city"));
				s.setCountry(rs.getString("country"));
				s.setCollege(rs.getString("college"));

				slist.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return slist;
	}

	@Override
	public List<Student> search(String input) {
		
		
		List<Student> slist = new ArrayList<Student>();

		String sql = "select * from student where firstname like '%"+input+"%'  OR  faculty like '%"+input+"%'  ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFaculty(rs.getString("faculty"));
				s.setFname(rs.getString("firstname"));
				s.setLname(rs.getString("lastname"));
				s.setCity(rs.getString("city"));
				s.setCountry(rs.getString("country"));
				s.setCollege(rs.getString("college"));

				slist.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return slist;
	}

}
