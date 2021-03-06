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
import com.itntraining.studentmanagement.services.StudentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
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
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentService studentService;
  
    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println("requested");
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAddress(studentDTO.getAddress());

        Department department = departmentRepository.findByDepartmentName(studentDTO.getDepartmentName());
        student.setDepartment(department);
        studentRepository.save(student);
        return ResponseEntity.ok(student);

    }
    
    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return ResponseEntity.ok(studentList);
    }
   
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
    
    @GetMapping(value = "/students/export")
    public ResponseEntity<?> exportCsv(){
        String csv=studentService.getCsv();
        String filename="studentExport.csv";
        byte[] byteArray=csv.getBytes();
        ByteArrayResource resource=new ByteArrayResource(byteArray);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+filename)
                .header(HttpHeaders.CONTENT_TYPE, "text/csv;charset=utf-8")
                .contentLength(byteArray.length)
                .body(resource);
    }

}
