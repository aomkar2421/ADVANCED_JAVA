<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String a = request.getParameter("sanme");
	%>

	<form action="hide">
		<input type="hidden" value="a">
		<input type="submit" value="Go To Sevlet" name="abc">
	</form>
</body>
</html>