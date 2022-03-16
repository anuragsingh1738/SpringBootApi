package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface IStudentService {
	
	//1.save student
	Integer saveStudent(Student std);
	
	//2.get all student
	List<Student> getAllStudents();
	
	//3.get student by id
	Student getStudentById(Integer id);
	
	//4.delete student by id
	void deleteStudentById(Integer id);
	
	//5.update
	void updateStudent(Student std);
	
	//6.partial update
	Integer updateStudentAdd(Integer sid,String add);
}

