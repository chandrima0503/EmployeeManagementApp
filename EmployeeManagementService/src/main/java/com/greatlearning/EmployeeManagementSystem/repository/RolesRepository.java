package com.greatlearning.EmployeeManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.greatlearning.EmployeeManagementSystem.entity.Role;

public interface RolesRepository extends CrudRepository<Role, Integer> {

}
