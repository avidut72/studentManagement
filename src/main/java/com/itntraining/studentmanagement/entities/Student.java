package com.itntraining.studentmanagement.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Avidut
 */
@Entity
@Table(name= "student_info")

public class Student {
	@Id
	@GeneratedValue
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	@Column(name="last_Name",nullable=false)
	private String lastName;
	@JoinColumn(name="department_id")
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Department department;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
