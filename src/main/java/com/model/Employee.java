package com.model;

import java.io.Serializable;


import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="employee_id")
    private Long employeeId;

	@Column(name = "name")
    private String employeeName;   

	@Column(name = "department")
    private String department;
    
	@Column(name ="salary")
	private double salary;
	
	@Column(name="email")
	@Email
	private String email;
	
	@OneToOne
	private Address address;
	
	public Employee(){
		System.out.println("in user model - default ctor");
	}

	public Employee(Long employeeId, String employeeName, String department, double salary,String email) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.department = department;
		this.salary = salary;
		this.email = email;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department
				+ ", salary=" + salary + ", address=" + address +", email="+email+ "]";
	}

	
}