package com.swingdemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.swingdemo.db.DB;
import com.swingdemo.model.Staff;

public class StaffServiceImpl implements StaffService{
	
	Connection con = null;
	
	 public StaffServiceImpl() {
		con = DB.getDbCon();
	}
	
	

	@Override
	public boolean addStaff(Staff st) {
		
		String sql = "insert into staff(name,address,dateofbirth,username,password) values(?,?,?,?,?) ";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, st.getName());
			pstm.setString(2, st.getAddress());
			pstm.setDate(3, st.getDateofbirth());
			pstm.setString(4, st.getUsername());
			pstm.setString(5, st.getPassword());
			

			pstm.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStaff(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Staff getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
