package com.spring.ems;

import com.spring.ems.model.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee(101,"Aaron","BE","DevOps","Chennai"));
        employeeService.addEmployee(new Employee(102,"Barry","BTech","Backend Developer","Hyderabad"));
        employeeService.addEmployee(new Employee(103,"Cookie","MCA","Architect","Chennai"));
        employeeService.addEmployee(new Employee(104,"Danny","BSc","Support Engineer","Mumbai"));
        employeeService.addEmployee(new Employee(105,"Ethan","BSc","Hardware Engineer","Mumbai"));
        employeeService.addEmployee(new Employee(106,"Frank","ME","Sr Engineer","Chennai"));
        employeeService.addEmployee(new Employee(107,"Ginny","MS","Architect","Hyderabad"));
        employeeService.addEmployee(new Employee(108,"Honey","BE","IT Engineer","Kolkata"));
        employeeService.addEmployee(new Employee(110,"Jenny","BE","AI","Chennai"));
        employeeService.addEmployee(new Employee(111,"Kiera","BTech","QE","Hyderabad"));
        employeeService.addEmployee(new Employee(109,"Isaac","MTech","Cloud Engineer","Kolkata"));

        /*//Print all Employees
        List<Employee> empList = employeeService.listAllEmployees();
        empList.stream().forEach(System.out::println);*/

        /*//Get Employee by City
        String city="mumbai";
        List<Employee> empListByCity = employeeService.listEmployeesByCity(city);
        empListByCity.stream().forEach(System.out::println);

        //Search any value with text
        String text="nn";
        List<Employee> empListByText=employeeService.searchEmpByText(text);
        empListByText.stream().forEach(System.out::println);*/

        //Order all employees alphabetically
        List<Employee> empListSorted=employeeService.listEmployeesAlphabetically();
        empListSorted.stream().forEach(System.out::println);

    }
}
