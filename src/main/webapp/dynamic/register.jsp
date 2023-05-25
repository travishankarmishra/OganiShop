<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>

<form action="register" method="post" enctype="multipart/form-data">
	<input type="text" placeholder="Name" name="name"><br>
	<input type="email" placeholder="Email" name="email"><br>
	<input type="password" placeholder="Password" name="password"><br>
	<input type="tel" placeholder="Mobile" name="mobile"><br>
	<input type="file" name="file">
<input type="submit">
</form>

</body>
</html>