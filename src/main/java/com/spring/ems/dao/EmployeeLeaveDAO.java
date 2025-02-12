package com.spring.ems.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.ems.model.EmployeeLeave;

public interface EmployeeLeaveDAO extends JpaRepository<EmployeeLeave, Integer>{
	@Modifying
	@Query(value="INSERT INTO EMPLOYEELEAVE VALUES (0,:empid,:fromdate,:todate,:leavetype,:managerid)",nativeQuery=true)
	public void applyLeave(int empid,LocalDate fromdate,LocalDate todate,String leavetype,String managerid);

}
