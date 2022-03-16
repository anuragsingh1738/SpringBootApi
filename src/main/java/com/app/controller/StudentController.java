package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	//1.save student
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student std){
		ResponseEntity<String> response = null;
		//call the service 
		Integer id = service.saveStudent(std);
		String msg  = "Student with id '"+id+"' is saved";
		response = new ResponseEntity<String>(msg,HttpStatus.OK);
		return response;
	}
	
	//2.get all student
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAll(){
		ResponseEntity<List<Student>> response = null;
		//call the service
		List<Student> list = service.getAllStudents();
		
		response = new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		
		return response;
	}
	
	//3.get One student
	@GetMapping("/get/{sid}")
	public ResponseEntity<Student> getOneStudent(@PathVariable Integer sid){
		ResponseEntity<Student> response = null;
		//call the service
		Student std = service.getStudentById(sid);
		response = new ResponseEntity<Student>(std,HttpStatus.OK);
		return response;
	}
	
	//4.update student
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student std){
		ResponseEntity<String> response = null;
		//call the service
		service.updateStudent(std);
		String msg = "Student Updated";
		response = new ResponseEntity<String>(msg,HttpStatus.OK);
		return response;
	}
	
	//5.delete student by id
	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<String> deleteOneStudent(@PathVariable Integer sid){
		ResponseEntity<String> response = null;
		//call the service
		service.deleteStudentById(sid);
		String msg = "Student Deleted";
		response = new ResponseEntity<String>(msg,HttpStatus.OK);
		return response;
	}
	
}