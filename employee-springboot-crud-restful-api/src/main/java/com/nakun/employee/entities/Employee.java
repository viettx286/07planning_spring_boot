package com.nakun.employee.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long empId;
	private String empNo;
	private String empName;

	public Employee() {

	}

	public Employee(Long empId, String empNo, String empName) {
		this.empId = empId;
		this.empNo = empNo;
		this.empName = empName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "empId", unique = true, nullable = false)
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	@Column(name = "empNo", unique = true, nullable = false, length = 10)
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	@Column(name = "empName", length = 20)
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}