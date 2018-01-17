package com.dotdesigner.StudentApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotdesigner.StudentApp.model.Student;
import com.dotdesigner.StudentApp.service.StudentService;

/**
 * 
 * @author Kirankumar Garaddi
 *
 * @date 17-Jan-2018
 */
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.POST)
	public void addStudent(@RequestBody(required = true) Student student) {

		studentService.addStudent(student);
	}

	@RequestMapping
	public List<Student> getstudents(@RequestParam("page") int page) {
		return studentService.getstudents(page);
	}

	@RequestMapping(value = "/{studentid}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("studentid") long studentId) {
		studentService.deleteStudent(studentId);
	}

	@RequestMapping(value = "/{studentid}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable("studentid") long studentId,
			@RequestBody(required = true) Student student) {
		studentService.updateStudent(studentId, student);
	}

	@RequestMapping("/{studentid}")
	public Student studentDetails(@PathVariable("studentid") long studentId) {
		return studentService.studentDetails(studentId);
	}
}
