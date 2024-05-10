<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <div class="container">
    <h1>Welcome to General Bank</h1>
    <form action="user" method="post">
      <div class="actions">
      	<input type="number" name="accNo" placeholder="Enter your account number">
      	<input type="number" name="pin" placeholder="Enter your pin-code">
        <input type="submit">
      </div>
    </form>
  </div>
</body>
</html>
