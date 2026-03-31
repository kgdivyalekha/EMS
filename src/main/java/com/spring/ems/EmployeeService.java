package com.spring.ems;

import com.spring.ems.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>();
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> listAllEmployees() {

        return employeeList;
    }

    public List<Employee> listEmployeesByCity(String city)
    {
        return employeeList.stream().filter(str -> str.getAddr().toLowerCase().equals(city.toLowerCase())).collect(Collectors.toList());
    }

    public List<Employee> searchEmpByText(String text) {
        String textLower=text.toLowerCase();
        return employeeList.stream().filter(emp-> emp.getEmpName().toLowerCase().contains(textLower)||
                emp.getEmpName().toLowerCase().contains(textLower)||
                emp.getQualification().toLowerCase().contains(textLower)||
                emp.getTech().toLowerCase().contains(textLower)||
                emp.getAddr().toLowerCase().contains(textLower)).collect(Collectors.toList());
    }

    public List<Employee> listEmployeesAlphabetically() {
        return employeeList.stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
    }
}
