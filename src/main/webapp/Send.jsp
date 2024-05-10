<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Money</title>
<link rel="stylesheet" href="styles.css">

</head>
<body>
	<body>
	<div class="container">
		<h1>Transfer Money to Others</h1>
		<form action="transfer" method="post">
			<div class="actions">
				<input type="number" name="accNo" placeholder="Enter receivers Account number">
				<input type="number" name="money" placeholder="Enter amount to be sent">
				<input type="submit">
			</div>
		</form>
	</div>
</body>
</html>