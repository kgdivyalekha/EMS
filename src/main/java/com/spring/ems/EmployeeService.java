package com.spring.ems;

import com.spring.ems.dao.EmployeeDAO;
import com.spring.ems.dao.EmployeeLeaveDAO;
import com.spring.ems.dao.EmployeeManagerDAO;
import com.spring.ems.model.Employee;
import com.spring.ems.model.EmployeeLeave;
import com.spring.ems.model.EmployeeManager;

import jakarta.transaction.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Component
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO empDao;
	@Autowired
	EmployeeManagerDAO empManDao;
	@Autowired
	EmployeeLeaveDAO empLeaveDao;
	@Autowired
	ThreadPoolTaskExecutor executor;
@Autowired
	private JavaMailSender jms;
		public List<Employee> listAllEmployees() {
		return empDao.findAll();
	}

@Transactional
	public List<Employee> searchByOption(String searchOption, String searchText) {
		List<Employee> empList=null;
		switch(searchOption)
		{
		case "dept":
			empList= empDao.findByDept(searchText);
			break;
		case "designation":
			empList= empDao.findByDesignation(searchText);
			break;
		case "technology":
			empList= empDao.findByTech(searchText);
			break;
		case "address":
			empList= empDao.findByAddress(searchText);
			break;
		}
		return empList;
	}
@Transactional
public EmployeeManager searchEmpManager(int empID) {
	EmployeeManager empMan= empManDao.findEmployeeManagerByEmpID(empID);
	return empMan;
}
@Transactional
public Employee addEmployee(Employee emp) {
	empDao.save(emp);
	return emp;
}
@Transactional
public Map<String,String> applyLeave(int empid, String fdate, String tdate, String leavereason) {
Employee emp=empDao.findById(empid).orElse(null)	;
String managerid=emp.getManagerid();
DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
LocalDate fromdate = LocalDate.parse(fdate, formatter);
LocalDate todate = LocalDate.parse(tdate, formatter);
Period period=Period.between(fromdate, todate);
empLeaveDao.applyLeave(empid, fromdate, todate, leavereason, managerid);
DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
String fromdateStr=fromdate.format(dtf);
String todateStr=todate.format(dtf);
Map<String,String> empLeaveMap=new HashMap<String, String>();
empLeaveMap.put("empid", String.valueOf(empid));
empLeaveMap.put("empname", emp.getEmpname());
empLeaveMap.put("fromdate", fromdateStr);
empLeaveMap.put("todate", todateStr);
empLeaveMap.put("leavereason", leavereason);
empLeaveMap.put("noofdays", String.valueOf(period.getDays()+1));
empLeaveMap.put("emailid", emp.getEmailid());
sendEmailApplyLeave(empLeaveMap,emp);
return empLeaveMap;
}

private void sendEmailApplyLeave(Map<String, String> empLeaveMap, Employee emp) {
	SimpleMailMessage smm = new SimpleMailMessage();
	smm.setFrom("kgdivyalekha@gmail.com");
	smm.setTo(empLeaveMap.get("emailid"));
	smm.setSubject("Leave Request Submitted");
	String emailMsg="Dear "+empLeaveMap.get("empname") + ",\n\n"+"Your leave request has been "
			+ "submitted successfully with your manager "+emp.getManagerid()+"\n\n Please find the details below:"
			+ "\n\nStart Date: " + empLeaveMap.get("fromdate")
			+ "\nEnd Date: " + empLeaveMap.get("todate")
			+ "\nLeave Type: " + empLeaveMap.get("leavereason")
			+ "\nNo of Days: " + empLeaveMap.get("noofdays")
			+"\n\n\n Thank You.";
	smm.setText(emailMsg);
	try {
		jms.send(smm);
		System.out.println("Email sent successfully");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}

public List<Employee> bulkUploadEmployees(MultipartFile bulkFile) throws IOException {
	List<Employee> parsedEmpList=parseCSVFile(bulkFile);
	BlockingQueue<Employee> bq= new LinkedBlockingQueue<>(parsedEmpList);
	List<Future<?>> futures = new ArrayList<>();
	for(int i=0;i<5;i++)
	{
		futures.add(executor.submit(()->
		{
			while(true)
			{
				try
				{
					Employee emp=bq.take();
					insertEmployee(emp);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
					break;			
				}
				catch(Exception e)
				{
					System.err.println("Error processing Employee:" +e.getMessage());
				}
			}
		}));
	}
	
	
	return parsedEmpList;
}
@Async
private void insertEmployee(Employee emp) {
	try
	{
		Thread.sleep(2000);
		empDao.save(emp);
	}
	catch (InterruptedException e)
	{
		Thread.currentThread().interrupt();
	}
	catch(Exception e)
	{
		System.err.println("Error adding new employee:" +e.getMessage());
	}
	
}

private List<Employee> parseCSVFile(MultipartFile bulkFile) throws IOException {
	List<Employee> parsedEmpList=new ArrayList<>();
	try 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(bulkFile.getInputStream()));
		String line;
		br.readLine();//for the header
		while((line=br.readLine())!=null)
		{
			String[] data=line.split(",");
			Employee newEmp= new Employee(Integer.parseInt(data[0]),data[1],data[2],data[9],data[10],
					Long.parseLong(data[3]),data[4],data[5],Integer.parseInt(data[6]),data[7],data[8]);
			parsedEmpList.add(newEmp);
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return parsedEmpList;
}
    
}
