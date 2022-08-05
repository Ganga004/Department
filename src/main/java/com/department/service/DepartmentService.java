package com.department.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.department.entity.Department;
import com.department.repository.DepartementRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;


@Service
public class DepartmentService {

	@Autowired
	private DepartementRepository departmentrepository;
	
	public Department saveDepartment(Department department) {
		return departmentrepository.save(department);
	}

	public Optional<Department> getDepartmentData(Long departmentId) {
		return departmentrepository.findById(departmentId);
	}

	public Optional<Department> deleteData(Long departmentId) {
		departmentrepository.deleteById(departmentId);
		System.out.println("Record deleted..");
		return Optional.empty();
		
	
	}

	public Department updateDepartment(Long departmentId,Department department) {
		Optional<Department> departmentData = departmentrepository.findById(departmentId);
		Department dept=departmentData.get();
		if(departmentData.isPresent())
		{
		dept.setDepartmentName(department.getDepartmentName());
		dept.setDepartmentAddress(department.getDepartmentAddress());
		dept.setDepartmentCode(department.getDepartmentCode());
		departmentrepository.save(dept);
		System.out.println("Details updated..");
		}
		else {
			System.out.println("Record not found");
		}
		return dept;
	}

	


	
}
