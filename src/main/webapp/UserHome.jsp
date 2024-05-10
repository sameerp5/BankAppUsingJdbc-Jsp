<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="container">
    <h1>Welcome to General Bank</h1>
    <h1></h1>
    <form action="userhome" method="post">
      <div class="actions">
        <input type="submit" value="Deposit Money" name="userAction">
        <input type="submit" value="Send Money" name="userAction">
        <input type="submit" value="Withdraw Money" name="userAction">
        <input type="submit" value="Update Profile" name="userAction">
        <input type="submit" value="Logout" class="logout-btn" name="userAction">
      </div>
    </form>
  </div>
</body>
</html>