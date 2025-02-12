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
<table>
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Leave Applied From</th>
<th>Leave Applied Till</th>
<th>Leave Type</th>
<th>No of Days</th>
</tr>
<tr>
<td><c:out value="${employees['empid']}"></c:out></td>
<td><c:out value="${employees['empname']}"></c:out></td>
<td><c:out value="${employees['fromdate']}"></c:out></td>
<td><c:out value="${employees['todate']}"></c:out></td>
<td><c:out value="${employees['leavereason']}"></c:out></td>
<td><c:out value="${employees['noofdays']}"></c:out></td>
</tr>
</table>
</body>
</html>