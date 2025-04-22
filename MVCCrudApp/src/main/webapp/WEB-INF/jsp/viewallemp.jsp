<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="search('')">
	<jsp:include page="master.jsp" />
	<br>
	<br>
	<div class="container">
		<input type='text' name='search' value='' style='width: 100%' class='control' onkeyup="search(this.value)" /> <br />
		<br />
		<div id="grid">
			<table class="table table-striped" id="tbl">

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
						<td><a href="del?empid=${employee.getId()}">DELETE</a></td>
						<td><a
							href="upd?empid=${employee.getId()}&empname=${employee.getName()}&empemail=${employee.getEmail()}&empcontact=${employee.getContact()}">UPDATE</a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>