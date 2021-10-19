<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Seller</title>
</head>
<body>
	
<form action="createNewSeller" method="post">

	<label for="sellerFirstName">Enter seller first name:</label>
	<input type="text" id="sellerFirstName" name="sellerFirstName" placeholder="Jane" size="10">
	
	 <label for="sellerLastName">Enter seller last name:</label>
	 <input type="text" id="sellerLastName" name="sellerLastName" placeholder="Doe" size="10"><br />
	 
	Available Houses: <br />
	<select name="allHousesToAdd" multiple size="6">
	<c:forEach items="${requestScope.allHouses}" var="currentitem">
		<option value="${currentitem.houseId}"> ${currentitem.address} | ${currentitem.sellingPrice}</option>
	</c:forEach>
	</select> <br />
	<input type="submit" value="Create Seller and Add Houses">
</form>
<a href="index.html">Go add new house instead</a>
</body>
</html>