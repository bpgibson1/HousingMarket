<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addSellerServlet" method="post">
		<label for="sellerFirstName">Enter seller first name:</label> <input
			type="text" id="sellerFirstName" name="sellerFirstName"
			placeholder="Jane" size="10"> <label for="sellerLastName">Enter
			seller last name:</label> <input type="text" id="sellerLastName"
			name="sellerLastName" placeholder="Doe" size="10"> <input
			type="submit" value="Add Seller">
	</form>

</body>
</html>