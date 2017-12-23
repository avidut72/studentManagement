/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itntraining.studentmanagement.services;

import com.itntraining.studentmanagement.DepartmentDTO;
import com.itntraining.studentmanagement.entities.Department;
import java.util.List;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Avidut
 */
public interface DepartmentService {
    void saveDepartment(Department department,BindingResult errors);
    List<DepartmentDTO> findAllDepartments();
    
}
