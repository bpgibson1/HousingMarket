<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit House</title>
</head>
<body>
	<form action = "editHouseServlet" method="post">
	Address: <input type="text" name="address" value="${houseToEdit.address}">
	Zipcode: <input type="text" name="zipcode" value="${houseToEdit.zipcode}">
	Selling Price: $<input type="text" name="sellingPrice" value="${houseToEdit.sellingPrice}">
	Market Date: <input type="text" name="marketDate" placeholder="YYYY-MM-DD" value="${houseToEdit.marketDate}">
	<input type="hidden" name="id" value="${houseToEdit.houseId}">
	<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>