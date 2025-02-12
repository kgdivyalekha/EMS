package com.spring.ems;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.ems.model.*;
  
  @Controller 
  
  public class EMSController {
  @Autowired
  EmployeeService empService;

  @RequestMapping("/") 
  public String home() 
  { 
	  return "index"; 
  } 
  @GetMapping("listEmployees")
  public String listAllEmployees(Model m)
  {	  	  
	  m.addAttribute("employees", empService.listAllEmployees());
	  return "result";
  }
  @GetMapping("searchByOption")
  public String searchByOption(@RequestParam("searchoption") String searchOption, @RequestParam("searchtext") String searchText, Model m)
  {	  
		
		  if(searchText.equals(null)||searchText.isEmpty()) 
			  home();
		  else { 
	  m.addAttribute("employees", empService.searchByOption(searchOption,searchText));}
	  return "result";
  }
  @GetMapping("searchEmpManager")
  public String searchEmpManager(@RequestParam("empID") int empid, Model m)
  {	  
		
		  if(empid==0) 
			  home(); 
		  else
		  {
		EmployeeManager empMan=  empService.searchEmpManager(empid);
		m.addAttribute("employees", empMan);
		}
	  return "empManView";
  }
  @PostMapping("/addEmployee")
  public String addEmployee(@ModelAttribute Employee emp, Model m)
  {
	  m.addAttribute("employee", empService.addEmployee(emp));
	  return "addemployee";
  }
  @PostMapping("/applyLeave")
  public String applyLeave(@RequestParam("empID") int empid, @RequestParam("fromdate") String fromdate, @RequestParam("todate") String todate,
		  @RequestParam("leavereason") String leavereason,Model m)
  {
	  m.addAttribute("employees", empService.applyLeave(empid, fromdate,todate,leavereason)); 
	  return "empleave";
  }
  @GetMapping("applyLeaveNav") 
  public String applyLeaveNav() 
  { 
	  return "applyleave"; 
  } 
  @PostMapping("/bulkUpload")
  public String bulkUploadEmployee(@RequestParam("filename") MultipartFile fileName, Model m)
  {
	  try {
		m.addAttribute("employees", empService.bulkUploadEmployees(fileName));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	  return "result";
  }
}
 