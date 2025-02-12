<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMS</title>
</head>
<body>
<form action="applyLeave" method=post>
Enter Employee ID:  <input type="number" name="empID" placeholder="Employee ID"/><br/>
<!-- Enter Manager ID:  <input type="text" name="manID" placeholder="Manager ID"/><br/> -->
<select name="leavereason" id="leave">
	  <option value="Sick Leave">Sick Leave</option>
	  <option value="Casual Leave">Casual Leave</option>
	  <option value="Earned Leave">Earned Leave</option>
	  <option value="Maternity Leave">Maternity Leave</option>
	</select>
	<br/>
 <label for="fromdate"> Enter From date:</label>
        <input type="date" name="fromdate" id="fromdate" placeholder="dd-mm-yyyy" value="" 
           min="1997-01-01" max="2030-12-31"/>
 <label for="todate"> Enter To date:</label>
        <input type="date" name="todate" id="todate" pattern="\d{2}-\d{2}-\d{4}" placeholder="dd-mm-yyyy" value="" 
           min="1997-01-01" max="2030-12-31"/>
  <br/><br/>
<input type="submit" value="Submit"/><br/><br/>

<strong><a href="views/index.jsp"> Home</a></strong>
</form>
</body>
</html>