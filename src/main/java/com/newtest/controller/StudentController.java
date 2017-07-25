package com.newtest.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newtest.bean.Student;
import com.newtest.dao.StudentDao;
import com.newtest.entity.StudentEntity;
import com.newtest.utils.StudentUtils;

@RestController
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/newtest/students/upload/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public List<Student> uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {

		List<Student> list = new ArrayList<>();
		StudentUtils studentUtils = new StudentUtils();
		// System.out.println("gggggg " + studentUtils.toString());
		// System.out.println("yyyy " + file);
		File file1 = studentUtils.convert(file);

		BufferedReader bufferedreader = new BufferedReader(new FileReader(file1));

		String Line;
		while ((Line = bufferedreader.readLine()) != null) {
			System.out.println(Line);
			StudentEntity st = studentUtils.convertLineToStudentEntity(Line);
			StudentEntity studentEntity = studentDao.saveStudent(st);

			Student student = new Student();
			student.setFirstname(studentEntity.getFirstname());
			student.setLastname(studentEntity.getLastname());
			student.setAddress(studentEntity.getAddress());
			student.setPhone(studentEntity.getPhone());

			list.add(student);
		}
		bufferedreader.close();

		return list;

	}
}
