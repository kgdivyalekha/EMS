package com.spring.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.ems.model.Employee;
import com.spring.ems.model.EmployeeManager;
import com.spring.ems.model.Manager;

public interface EmployeeManagerDAO extends JpaRepository<EmployeeManager, Integer> {
	@Query("select em from EmployeeManager em where em.empID= :empID")
	EmployeeManager findEmployeeManagerByEmpID(int empID);
}
