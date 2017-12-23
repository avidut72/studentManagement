package com.itntraining.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itntraining.studentmanagement.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
