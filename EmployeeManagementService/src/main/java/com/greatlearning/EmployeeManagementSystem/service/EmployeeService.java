package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;

public interface EmployeeService {

	// Save operation
	Employee saveEmployee(Employee employee);

	// Read operation
	List<Employee> fetchEmployeeList();

	// Update operation
	Employee updateEmployee(Employee employee, Integer Id);

	// Delete operation
	void deleteEmployeeById(Integer Id);

	// Employee search by ID
	Employee fetchEmployeeById(Integer Id);

	// Employee search by First Name
	List<Employee> fetchEmployeeListByFirstName(String FristName);

	// Employee Record Sorting by First Name
	List<Employee> fetchEmployeeListSorted(String order);
}
