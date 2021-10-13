<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Houses</title>
</head>
<body>
	<form method="post" action="/houseNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allHouses}" var="currenthouse">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.houseId}"></td>
			<td>${currentitem.address}</td>
			<td>${currentitem.zipcode}</td>
			<td>${currentitem.sellingPrice}</td>
			<td>${currentitem.marketDate}</td>
		</tr>
	</c:forEach>
	</table>
		<input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem">
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>