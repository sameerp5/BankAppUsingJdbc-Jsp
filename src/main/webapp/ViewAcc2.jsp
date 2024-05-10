<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.bank.databaseconn.ConnectDatabase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Account</title>
<link rel="stylesheet" href="style3.css">
</head>
<body>
	<% 
	ResultSet rs = (ResultSet)request.getAttribute("res");
	rs.next();
	%>
	<table >
		<th>Account No</th>
		<th>Name</th>
		<th>Balance</th>
		<th>Phone No</th>
		<th>PinCode</th>
		
		<tr>
			<td><%=rs.getLong(2) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%= rs.getDouble(5) %></td>
			<td><%= rs.getLong(6) %></td>
			<td><%=rs.getInt(3) %></td>
		</tr>
	</table>

</body>
</html>