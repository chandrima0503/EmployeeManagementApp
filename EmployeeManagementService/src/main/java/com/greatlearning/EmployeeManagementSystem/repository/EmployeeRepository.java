package com.greatlearning.EmployeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaRepository<Employee, Integer> {

	// Object findById(int id);

	// List<Employee> findByfristNameContainsAndlastNameContainsAllIgnoreCase(String
	// fristName,String lastName);

	@Query("SELECT u FROM Employee u WHERE u.firstName = ?1")
	public List<Employee> getEmployeeByFirstName(String firstName);

	// @Query("Select From Employee Order By firstName ")
	// public List<Employee> getEmployeeListSorted( String order);
}
