<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Sellers</title>
</head>
<body>
	<form method="post" action="sellerNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allSellers}" var="currentseller">
				<tr>
					<td><input type="radio" name="id"
						value="${currentseller.sellerId}"></td>
					<td>${currentseller.firstName}</td>
					<td>${currentseller.lastName}</td>
					<c:forEach items="${requestScope.currentseller.listOfHouses}" var="currenthouse">
						<tr><td></td>
						<tr>
							<td colspan="4">${currenthouse.address}, ${currenthouse.zipcode}, ${currenthouse.sellingPrice}, ${currenthouse.marketDate}</td>
						</tr>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem"> 
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>