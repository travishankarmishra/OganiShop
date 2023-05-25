<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard Page</title>
</head>
<body>
<form action="productregister" method="post" enctype="multipart/form-data">
	<input type="text" placeholder="category" name="category"><br>
	<input type="text" placeholder="name" name="name"><br>
	<input type="number" placeholder="rate" name="rate"><br>
    <input type="number" placeholder="price" name="price"><br>
    <input type="text" placeholder="currency" name="currency"><br>
	<input type="text" placeholder="brief intro" name="briefintro"><br>
	<input type="number" placeholder="Available quantity" name="Availablequantity"><br>
	<input type="number" placeholder="pincode" name="pincode"><br>
	<input type="number" placeholder="weight" name="weight"><br>
	<input type="text" placeholder="description" name="description"><br>
	<input type="file" name="image">
	<input type="submit">
</form>
</body>
</html>