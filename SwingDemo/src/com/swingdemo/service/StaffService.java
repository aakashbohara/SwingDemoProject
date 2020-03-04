package com.swingdemo.service;

import com.swingdemo.model.Staff;

public interface StaffService {
	
	boolean addStaff(Staff st);
	boolean deleteStaff(int id);
	
	
	Staff getById(int id);

}
