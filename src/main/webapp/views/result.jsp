<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMS</title>
</head>
<body>
<strong>List of Employees:</strong>

<table>
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Mobile No</th>
<th>Email ID</th>
<th>Designation</th>
<th>Manager ID</th>
</tr>
  <c:forEach items="${employees}" var="employee">
    <tr>
      <td><c:out value="${employee.empID}" /></td>
      <td><c:out value="${employee.empname}" /></td>
      <td><c:out value="${employee.mobileno}" /></td>
      <td><c:out value="${employee.emailid}" /></td>
      <td><c:out value="${employee.designation}" /></td>
      <td><c:out value="${employee.managerid}" /></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>