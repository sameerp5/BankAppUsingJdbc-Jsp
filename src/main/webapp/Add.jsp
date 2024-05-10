<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account</title>
<link rel="stylesheet" href="styles.css">

</head>
<body>
 <div class="container">
   <h1>Create new account</h1>
	<form action="add" method="post">
		<input type="text" name="name" placeholder="Enter Your Name">
		<input type="number" name="phone" placeholder="Enter Your Phone Number">
		<input type="number" name="balance" placeholder="Enter Starting Balance" >
		<input type="number" name="pin" placeholder="Enter Your Desired PinCode">
		<input type="submit">
	</form>
</div>
</body>
</html>