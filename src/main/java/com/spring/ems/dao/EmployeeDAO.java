package com.spring.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.ems.model.Employee;
import com.spring.ems.model.EmployeeManager;
@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

	List<Employee> findByDept(String searchText);
	List<Employee> findByAddress(String searchText);
	List<Employee> findByDesignation(String searchText);
	List<Employee> findByTech(String searchText);

}
