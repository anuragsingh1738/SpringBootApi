package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Student;
import com.app.repo.StudentRepository;
import com.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Integer saveStudent(Student std) {
		std = repo.save(std);
		return 1;
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> opt = repo.findById(id);
		
		if(opt.isEmpty()) {
			return null;
		}
		
		return opt.get();
	}

	@Override
	public void deleteStudentById(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public void updateStudent(Student std) {
		repo.save(std);
	}

	@Transactional
	public Integer updateStudentAdd(Integer sid, String add) {
		// TODO Auto-generated method stub
		return repo.updateStudentAddById(sid, add);
	}

}