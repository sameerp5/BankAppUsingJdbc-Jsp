<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<div class="container">
		<h1>Welcome to General Bank</h1>
		<h1>Accountant Home Page</h1>
		<form action="adminhome" method="post">
			<div class="actions">
				<input type="submit" value="Add Account" name="adminAction"> 
				<input type="submit" value="View Account By Account Number" name="adminAction"> 
				<input type="submit" value="View All Accounts" name="adminAction"> 
				<input type="submit" value="Logout" class="logout-btn" name="adminAction">
			</div>
		</form>
	</div>
</body>
</html>