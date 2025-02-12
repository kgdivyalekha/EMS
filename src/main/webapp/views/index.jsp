<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMS</title>
</head>
<body>
<p>Welcome To Employee Management System</p> 
<form action="listEmployees" method=get>
<input type="submit" value="List All Employees"/>
</form>

<hr/>
<form action="searchByOption" method=get>
	<select name="searchoption" id="search">
	  <option value="dept">Department</option>
	  <option value="designation">Designation</option>
	  <option value="technology">Technology</option>
	  <option value="address">City</option>
	</select>
<input type="text" name="searchtext" placeholder="Enter search phrase"/>
<input type="submit" value="Search"/>
</form>
<hr/>
<form action="searchEmpManager" method=get>
<!-- <input type="text" name="empname" placeholder="Enter Empoyee Name"/>
<strong>OR</strong> -->
<input type="number" name="empID" placeholder="Enter Employee ID"/>
<input type="submit" value="Search"/>
</form>
<hr/>
<form action="addEmployee" method=post>
Enter Emp ID:  <input type="number" name="empID" placeholder="Employee ID"/><br/>
Enter Emp Name:  <input type="text" name="empname" placeholder="Employee Name"/><br/>
Enter Qualification:<input type="text" name="qualification" placeholder="Qualification"/><br/>
Enter Mobile No:<input type="number" name="mobileno" placeholder="Mobile No"/><br/>
Enter E-Mail ID:<input type="text" name="emailid" placeholder="E-Mail ID"/><br/>
Enter Department:<input type="text" name="dept" placeholder="Department"/><br/>
Enter YoE:<input type="number" name="yoe" placeholder="Years of Experience"/><br/>
Enter Designation:<input type="text" name="designation" placeholder="Designation"/><br/>
Enter Manager ID:<input type="text" id="managerid" name="managerid" placeholder="Manager ID"/><br/>
Enter Technology:<input type="text" name="tech" placeholder="Technology"/><br/>
Enter City:<input type="text" name="address" placeholder="Address"/><br/><br/>
<input type="submit" value="Add Employee"/>
</form>
<hr/>
<form action="applyLeaveNav">
<strong>Apply Leave? <input type="submit" value="Click Here"/></strong>
</form>
<hr/>
<form action="bulkUpload" method="post" enctype="multipart/form-data">
<strong>Bulk Upload New Employees</strong><br/>
<input type="file" name="filename" value="Choose File"/><br/>
<input type="submit" value="Submit"/>
</form>
<!-- <form action="searchByAny" method=get>
	<select name="searchAny" id="searchAny">
	  <option value="dept">Department</option>
	  <option value="designation">Designation</option>
	  <option value="technology">Technology</option>
	  <option value="address">City</option>
	  	<option value="email">Email</option>
	  <option value="name">Name</option>
	  <option value="yoe">Years of Experience</option>
	</select>
<input type="text" name="searchtext" placeholder="Enter search phrase"/>
<input type="submit" value="Search"/>
</form> -->
</body>
</html>