<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="master.jsp"/>
	<br><br>
	<table border="5" align="center" width="60%">
	
		<tr>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>
		<c:forEach var="employee" items="${empList}">
		<tr>
			<td>${employee.getName()}</td>
			<td>${employee.getEmail()}</td>
			<td>${employee.getContact()}</td>
			<td><a href="">DELETE</a></td>
			<td><a href="">UPDATE</a></td>
			
		</tr>
	</c:forEach>
	</table>
	
	
</body> 
</html>