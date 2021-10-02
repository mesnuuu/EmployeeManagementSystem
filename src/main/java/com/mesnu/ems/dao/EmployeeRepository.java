package com.mesnu.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mesnu.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
