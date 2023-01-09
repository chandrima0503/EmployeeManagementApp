package com.greatlearning.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;
import com.greatlearning.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeManagementSystemController {
	@Autowired
	private EmployeeService employeeService;

	// Save or Create Operation
	@PostMapping("/employee")
	@ResponseBody
	public Employee AddEmployee(@Validated @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	// Read Operations
	@GetMapping("/employee")
	@ResponseBody
	public List<Employee> GetEmployeeList() {

		return employeeService.fetchEmployeeList();

	}

	// Update Operation
	@PutMapping("/employee/{Id}")
	@ResponseBody
	public Employee UpdateEmployeeById(@RequestBody Employee employee, @PathVariable("Id") Integer Id) {
		return employeeService.updateEmployee(employee, Id);

	}

	// Search Employee by ID Operation
	@GetMapping("/employee/{Id}")
	@ResponseBody
	public Employee GetEmployeeById(@PathVariable("Id") Integer Id) {

		return employeeService.fetchEmployeeById(Id);

	}

	// Delete Operation
	@DeleteMapping("/employee/{Id}")
	@ResponseBody

	public String DeleteEmployeeById(@PathVariable("Id") Integer Id) {
		
		employeeService.deleteEmployeeById(Id);
		return "Deleted employee who has id = " + Id;

	}

	// Search By First Name Operations
	@GetMapping("/employee/search/{FirstName}")
	@ResponseBody
	public List<Employee> SearchByFirstName(@PathVariable("FirstName") String FirstName) {

		return employeeService.fetchEmployeeListByFirstName(FirstName);

	}

	// Sort By First Name Operations
	@GetMapping("/employee/sort")
	@ResponseBody
	public List<Employee> sortByFirstName(@RequestParam String order) {

		return employeeService.fetchEmployeeListSorted(order);

	}

}
