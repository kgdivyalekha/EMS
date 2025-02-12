package com.spring.ems.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeLeave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
int leaveid;
int empid;
String fromdate;
String todate;
String leavetype;
String managerid;
public EmployeeLeave() {
	super();
}
public EmployeeLeave(int leaveid, int empid, String fromdate, String todate, String leavetype, String managerid) {
	super();
	this.leaveid = leaveid;
	this.empid = empid;
	this.fromdate = fromdate;
	this.todate = todate;
	this.leavetype = leavetype;
	this.managerid = managerid;
}
public int getLeaveid() {
	return leaveid;
}
public void setLeaveid(int leaveid) {
	this.leaveid = leaveid;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getFromdate() {
	return fromdate;
}
public void setFromdate(String fromdate) {
	this.fromdate = fromdate;
}
public String getTodate() {
	return todate;
}
public void setTodate(String todate) {
	this.todate = todate;
}
public String getLeavetype() {
	return leavetype;
}
public void setLeavetype(String leavetype) {
	this.leavetype = leavetype;
}
public String getManagerid() {
	return managerid;
}
public void setManagerid(String managerid) {
	this.managerid = managerid;
}

}
