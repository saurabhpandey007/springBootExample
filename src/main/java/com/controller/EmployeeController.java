package com.controller;





import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeService;
import com.service.MailService;



@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/*@Autowired
	private MailService mailService;
	*/
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee transientEmployee,HttpServletResponse response)
	{
		System.out.println("before created "+transientEmployee);
		Employee persistEmployee;
		try {
			persistEmployee = employeeService.saveEmployee(transientEmployee);
			System.out.println("after created "+persistEmployee);
			return persistEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			return transientEmployee;
		}
		
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public Employee deleteEmployee(@PathVariable("id") Long employeeId,HttpServletResponse response)
	{
		System.out.println("before delete. id "+ employeeId);
		try {
			Employee detachedEmployee = employeeService.deleteEmployee(employeeId);
			return detachedEmployee;
		} catch (Exception e) {
			response.setStatus(500);
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee transientEmployee,HttpServletResponse response)
	{
		System.out.println("before update employee "+transientEmployee);
		try {
			Employee persistEmployee = employeeService.updateEmployee(transientEmployee);
			return persistEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			return transientEmployee;
		}
	}
	
	@RequestMapping(value="/list")
	public List<Employee> listEmployees(HttpServletResponse response)
	{
		System.out.println("before list");
		List<Employee> empList;
		try {
			empList = employeeService.listAllEmployees();
			return empList;
		} catch (Exception e) {
			response.setStatus(500);
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="/employee/{id}")
	public Employee findEmployeeByName(@PathVariable("id")Long empId,HttpServletResponse response)
	{
		System.out.println("before find id "+empId);
		try {
			Employee emp = employeeService.findEmployeeById(empId);
			System.out.println("employee "+emp);
			if(emp == null)
				throw new Exception();
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			return null;
		}
		
	}
	
	@RequestMapping(value="/employeeNameState")
	public List<Employee> findEmployeeByNameAndState(@QueryParam("employeeName")String employeeName,@QueryParam("state")String state,HttpServletResponse response)
	{
		System.out.println("hello "+ employeeName + " "+state);
		try {
			List<Employee> empList = employeeService.findEmployeeByNameAndState(employeeName, state);
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			return null;
		}
		
	}
	
}
