package com.itntraining.studentmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itntraining.studentmanagement.entities.Student;
import com.itntraining.studentmanagement.repositories.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@PostMapping("/students")
	public ResponseEntity<?>saveStudent(@RequestBody Student student){
		studentRepository.save(student);
		return ResponseEntity.ok("saved");
		
	}
	@GetMapping("/students")
	public ResponseEntity<?>getAllStudents(){
		List<Student> studentList=studentRepository.findAll();
		return ResponseEntity.ok(studentList);
	}
	
}
