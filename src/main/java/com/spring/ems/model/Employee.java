package com.spring.ems.model;

public class Employee {
    private int empID;
    private String empName;
    private String qualification;
    private String tech;
    private String addr;

    public Employee() {
    }

    public Employee(int empID, String empName, String qualification, String tech, String addr) {
        this.empID = empID;
        this.empName = empName;
        this.qualification = qualification;
        this.tech = tech;
        this.addr = addr;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee ID=" + empID +
                ", Employee Name='" + empName + '\'' +
                ", Qualification='" + qualification + '\'' +
                ", Technology='" + tech + '\'' +
                ", Address='" + addr + '\'' +
                '}';
    }
}
