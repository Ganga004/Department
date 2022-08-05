package com.department.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.entity.Department;
import com.department.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentservice;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "It is working..";
		
	}

	@PostMapping("/alldata")
	public Department saveAllData(@RequestBody Department department)
	{
	return departmentservice.saveDepartment(department);	
	}
	
	
	//this needs to be tried with path variable
	@PutMapping("/updateValues/{id}")
	public Department updateDepartmentData(@PathVariable("id") Long departmentId, @RequestBody Department department)
	{
	return departmentservice.updateDepartment(departmentId,department);	
	}
	
	@GetMapping("/getrecord/{id}")
	public Optional<Department> getDepartmentData(@PathVariable("id") Long departmentId)
	{
		return departmentservice.getDepartmentData(departmentId);
		
	}
	@DeleteMapping("/deleteData/{id}")
	public Optional<Department> deleteDepartmentData(@PathVariable("id") Long departmentId)
	{
		return departmentservice.deleteData(departmentId);
		
	}
}
