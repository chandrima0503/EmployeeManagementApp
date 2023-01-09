package com.greatlearning.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.greatlearning.EmployeeManagementSystem.entity.Role;
import com.greatlearning.EmployeeManagementSystem.service.RoleService;

@Controller
@RequestMapping("/api")
public class RoleManagementController {

	@Autowired
	private RoleService roleService;

	// Save or Create Operation
	@PostMapping("/role")
	@ResponseBody
	public Role AddRole(@Validated @RequestBody Role role) {
		return roleService.saveRole(role);

	}

	// Read Operations
	@GetMapping("/role")
	@ResponseBody
	public List<Role> GetRoleList() {

		return roleService.fetchRoleList();

	}

	// Update Operation
	@PutMapping("/role/{Id}")
	@ResponseBody
	public Role UpdateRole(@RequestBody Role role, @PathVariable("Id") Integer Id) {
		return roleService.updateRole(role, Id);

	}

	// Delete Operation
	@DeleteMapping("/role/{Id}")
	@ResponseBody
	public String DeleteRoleById(@PathVariable("Id") Integer role_id) {

		roleService.deleteRoleById(role_id);
		return "Deleted employee id - " + role_id;

	}

}
