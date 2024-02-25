<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! int a= 9;
		int b=13;
	%>
	
	<h1><%=a %></h1>
	<%
		out.print(b);
	%>
</body>
</html>