<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Account</title>
<link rel="stylesheet" href="styles.css">

</head>
<body>
	<div class="container">
		<h1>Check Account Details</h1>
		<form action="view" method="post">
			<div class="actions">
				<input type="number" name="accNo" placeholder="Enter Your Account Number">
				<input type="submit">
			</div>
		</form>
	</div>
</body>
</html>