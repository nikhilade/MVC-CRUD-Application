<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="master.jsp"></jsp:include>
<br><br>
	<div class="container p-5">
		<form action="saveemp" name="frm" method="POST">
		<input type="text" name="name" value="" class="control"><br><br>
	<input type="text" name="email" value="" class="control"><br><br>
	<input type="text" name="contact" value="" class="control"><br><br>
	<input type="submit" name="s" value="Add New Employee" class="control"><br><br>
	</form>
	${msg}
	</div>
</body>
</html>