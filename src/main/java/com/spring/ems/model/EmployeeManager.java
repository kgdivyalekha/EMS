package com.spring.ems.model;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Immutable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeManager {
	@Id
	private int empID;
	private String empname;
	private String designation;
	private String managerid;
	private int managerempID;
	private String manager_name;
	
	public EmployeeManager() {
		super();
	}
	
	public EmployeeManager(int empID, String empname, String designation, String managerid, int managerempID,
			String manager_name) {
		super();
		this.empID = empID;
		this.empname = empname;
		this.designation = designation;
		this.managerid = managerid;
		this.managerempID = managerempID;
		this.manager_name = manager_name;
	}

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getManagerId() {
		return managerid;
	}
	public void setManagerId(String managerid) {
		this.managerid = managerid;
	}
	public int getManagerempID() {
		return managerempID;
	}
	public void setManagerempID(int managerempID) {
		this.managerempID = managerempID;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	@Override
	public String toString() {
		return "EmployeeManager [empID=" + empID + ", empname=" + empname + ", designation=" + designation
				+ ", manager_id=" + managerid + ", managerempID=" + managerempID + ", manager_name=" + manager_name
				+ "]";
	}


}
