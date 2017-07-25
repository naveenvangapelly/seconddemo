package com.newtest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newtest.entity.StudentEntity;
import com.newtest.repository.StudentRepository;

@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;

	
	

	public StudentEntity saveStudent(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);
	}
}

	
