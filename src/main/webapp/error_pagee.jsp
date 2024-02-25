<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page isErrorPage="true" %>
<%@ page errorPage="error_page" %>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%!
			int a = 100;
			int b = 10;
		%>
		
		<h1>Division is = <%=a/b %> </h1>
		
	</body>
</html>