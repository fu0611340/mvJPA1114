<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>
</head>
<body>
	<table border="1" style="width: 50%">
		<tr>
			<th>Student ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="s" items="${students}">
		<tr>
			<td>${s.sid}</td>
			<td><c:out value="${s.sname}" /></td>
			<td><c:out value="${s.age}" /></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>