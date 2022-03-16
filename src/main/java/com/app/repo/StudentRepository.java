package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Modifying//non-select
	@Query("UPDATE Student SET studentAddresss=:add WHERE studentId=:id")
	Integer updateStudentAddById(Integer id,String add);
}