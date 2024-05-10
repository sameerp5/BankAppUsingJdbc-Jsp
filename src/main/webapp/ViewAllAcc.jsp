<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.bank.databaseconn.ConnectDatabase"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Accounts</title>
<link rel="stylesheet" href="style3.css">

</head>
<body>
	<% 
	Connection con = ConnectDatabase.connectDB();
	PreparedStatement ps = con.prepareStatement("select * from Account");
	ResultSet rs = ps.executeQuery();
	
	%>
	<table >
		<th>Account No</th>
		<th>Name</th>
		<th>Balance</th>
		<th>Phone No</th>
		<th>PinCode</th>
		<% while(rs.next()){ %>
		<tr>
			<td><%=rs.getLong(2) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%= rs.getDouble(5) %></td>
			<td><%= rs.getLong(6) %></td>
			<td><%=rs.getInt(3) %></td>
		</tr>
		<% } %>
	</table>
	
</body>
</html>