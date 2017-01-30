package com.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Address;
import com.repository.AddressRepository;
import com.model.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Employee saveEmployee(Employee transientEmployee) throws Exception {
		
		Address persistAddress = addressRepository.save(transientEmployee.getAddress());
		Employee persistEmployee = employeeRepository.save(transientEmployee);
		return persistEmployee;
	}

	@Override
	public Employee updateEmployee(Employee transientEmployee) throws Exception {
		Employee persistEmployee = findEmployeeById(transientEmployee.getEmployeeId());
		Address persistAddress = persistEmployee.getAddress();
		transientEmployee.getAddress().setAddressId(persistAddress.getAddressId());
		addressRepository.save(transientEmployee.getAddress());
		employeeRepository.save(transientEmployee);
		return transientEmployee;
	}

	@Override
	public List<Employee> listAllEmployees() throws Exception {
		Iterable<Employee> iterableList = employeeRepository.findAll();
		List<Employee> empList = new LinkedList<>();
		for (Employee employee : iterableList) {
			empList.add(employee);
		}
		return empList;
	}

	@Override
	public Employee deleteEmployee(Long empId) throws Exception {
		Employee detachedEmployee = findEmployeeById(empId);
		employeeRepository.delete(detachedEmployee.getEmployeeId());
		addressRepository.delete(detachedEmployee.getAddress());
		
		return detachedEmployee;
	}

	@Override
	public Employee findEmployeeById(Long empId) throws Exception {
		Employee persistEmployee = employeeRepository.findOne(empId);
		return persistEmployee;
	}

	@Override
	public List<Employee> findEmployeeByNameAndState(String name, String state) throws Exception {
		
		return employeeRepository.findByEmployeeNameAndAddressState(name, state);
	}

}
