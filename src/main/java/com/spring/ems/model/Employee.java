package com.spring.ems.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Employee {
	@Id
    private int empID;
    private String empname;
    private String qualification;
    private String tech;
    private String address;
    private long mobileno;
    private String emailid;
    private String dept;
    private int yoe;
    private String designation;
    private String managerid;

      public Employee() {
		super();
	}

	public Employee(int empID, String empname, String qualification, String tech, String address, long mobileno,
			String emailid, String dept, int yoe, String designation, String managerid) {
		super();
		this.empID = empID;
		this.empname = empname;
		this.qualification = qualification;
		this.tech = tech;
		this.address = address;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.dept = dept;
		this.yoe = yoe;
		this.designation = designation;
		this.managerid = managerid;
	//	this.manager = manager;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getYoe() {
		return yoe;
	}

	public void setYoe(int yoe) {
		this.yoe = yoe;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empname=" + empname + ", qualification=" + qualification + ", tech="
				+ tech + ", address=" + address + ", mobileno=" + mobileno + ", emailid=" + emailid + ", dept=" + dept
				+ ", yoe=" + yoe + ", designation=" + designation + ", managerid=" + managerid + "]";
	}


	/*
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="managerid") private Manager manager;
	 */
}
    

    

