package com.itntraining.studentmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itntraining.studentmanagement.entities.Department;
import com.itntraining.studentmanagement.repositories.DepartmentRepository;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	@PostMapping("/departments")
	public ResponseEntity<?>saveDepartment(@RequestBody Department department){
		departmentRepository.save(department);
		return ResponseEntity.ok("saved");
		
	}
	@GetMapping("/departments")
	public ResponseEntity<?>getAllDepartments(){
		List<Department> departmentList=departmentRepository.findAll();
		return ResponseEntity.ok(departmentList);
	}
	@Transactional
	@PutMapping("/departments")
	public ResponseEntity<?> updateDepartment(@RequestParam Long departmentId, @RequestBody Department department){
		Department oldDepartment=departmentRepository.findOne(departmentId);
		oldDepartment.setDepartmentName(department.getDepartmentName());
		return ResponseEntity.ok("Department saved Successfully");
	}
	@DeleteMapping("/departments")
	public ResponseEntity<?> deleteDepartment(@RequestParam Long departmentId){
		departmentRepository.delete(departmentId);
		return ResponseEntity.ok("department deleted successfully");
	}
}
