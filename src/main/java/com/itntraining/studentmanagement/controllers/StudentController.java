package com.itntraining.studentmanagement.controllers;

import com.itntraining.studentmanagement.StudentDTO;
import com.itntraining.studentmanagement.entities.Department;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itntraining.studentmanagement.entities.Student;
import com.itntraining.studentmanagement.repositories.DepartmentRepository;
import com.itntraining.studentmanagement.repositories.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Transactional
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAddress(studentDTO.getAddress());

        Department department = departmentRepository.findByDepartmentName(studentDTO.getDepartmentName());
        student.setDepartment(department);
        studentRepository.save(student);
        return ResponseEntity.ok("new student saved");

    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return ResponseEntity.ok(studentList);
    }
    //@Transactional
    @PutMapping("/students")
    public ResponseEntity<?> updateStudent(@RequestParam Long studentId, @RequestBody StudentDTO studentDTO){
        Student oldStudent = studentRepository.findOne(studentId);
        oldStudent.setFirstName(studentDTO.getFirstName());
        oldStudent.setLastName(studentDTO.getLastName());
        oldStudent.setAddress(studentDTO.getAddress());
        return ResponseEntity.ok("Student saved Successfully");
    }
    @DeleteMapping("/students")
    public ResponseEntity<?> deleteStudent(@RequestParam Long studentId){
        studentRepository.delete(studentId);
        return ResponseEntity.ok("student deleted");
        
    }

}
