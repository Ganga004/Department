
package com.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.department.entity.Department;
import java.sql.Date;
import java.time.LocalDate;
@Repository
public interface DepartementRepository extends JpaRepository<Department, Long> 
{
}	
