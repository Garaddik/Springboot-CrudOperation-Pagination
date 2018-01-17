package com.dotdesigner.StudentApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dotdesigner.StudentApp.model.Student;
import com.dotdesigner.StudentApp.repository.StudentRepository;

/**
 * 
 * @author Kirankumar Garaddi
 *
 * @date 17-Jan-2018
 */
@Service
public class StudentService {

	@Value("${pagination.limit}")
	private int limit;

	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public List<Student> getstudents(int page) {

		List<Student> studentList = new ArrayList<Student>();
		if (page <= 0) {
			page = 1;
		}

		Pageable pageRequest = new PageRequest(page, limit);

		Page<Student> pageStudents = studentRepository.findAll(pageRequest);

		for (Student student : pageStudents) {
			studentList.add(student);
		}
		return studentList;

	}

	public void deleteStudent(long studentId) {
		studentRepository.delete(studentId);
	}

	public Student studentDetails(long studentId) {
		return studentRepository.findOne(studentId);
	}

	public void updateStudent(long studentId, Student student) {

		student.setStudentId(studentId);

		studentRepository.save(student);
	}

}
