package com.swingdemo.service;

import java.util.List;

import com.swingdemo.model.Student;

public interface StudentService {

	boolean addStudent(Student s);

	boolean deleteStudent(int id);

	boolean updateStudent(Student s);

	Student getById(int id);

	List<Student> getAllStudent();

	List<Student> search(String input);
}
