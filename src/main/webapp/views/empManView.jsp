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
<strong>Employee Details:</strong>

<table>
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Designation</th>
<th>Manager Name</th>
</tr>
      <tr>
      <td><c:out value="${employees.empID}" /></td>
      <td><c:out value="${employees.empname}" /></td>
      <td><c:out value="${employees.designation}" /></td>
      <td><c:out value="${employees.manager_name}" /></td>
    </tr>

</table>

</body>
</html>