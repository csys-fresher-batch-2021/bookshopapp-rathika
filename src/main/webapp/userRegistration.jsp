<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="RegistrationServlet" method="post">
			<table>
				<caption>USER REGISTRATION</caption>
				<tr>
					<th scope="col">NAME</th>
					<td><input type="text" name="userName"
						placeholder="Enter user name" id="userId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">EMAIL</th>
					<td><input type="email" name="email" placeholder="Enter Email"
						id="emailId" required></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" name="mobile"
						placeholder="Enter mobile number" id="mobileId" required></td>
				<tr>
					<th scope="col">ADDRESS</th>
					<td><input type="text" name="address"
						placeholder="Enter Address" id="addressId" required></td>
				</tr>
				<tr>
					<th scope="col">AGE</th>
					<td><input type="number" name="age" placeholder="Enter AGE"
						id="ageId" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="pass"
						placeholder="Enter Password" id="passId" required></td>
				</tr>
				<tr>
					<th scope="col">RE-ENTER PASSWORD</th>
					<td><input type="password" name="reenterPass"
						placeholder="Re-Enter Password" id="passId" required></td>
				</tr>
			</table>
			
			<button type="submit" class="btn btn-success">REGISTER</button>
		</form>
	</main>
</body>
</body>
</html>