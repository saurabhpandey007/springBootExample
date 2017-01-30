package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee transientEmployee) throws Exception;
	public Employee updateEmployee(Employee transientEmployee) throws Exception;
	public List<Employee> listAllEmployees() throws Exception;
	public Employee deleteEmployee(Long empId) throws Exception;
	public Employee findEmployeeById(Long empId)throws Exception;
	public List<Employee> findEmployeeByNameAndState(String name,String state)throws Exception;
}
