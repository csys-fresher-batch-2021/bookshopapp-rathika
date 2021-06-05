<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>USER LOGIN</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="UserLoginServlet" method="post">
			<table>
				<caption>USER LOGIN</caption>
				<tr>
					<th scope="col">EMAIL</th>
					<td><input type="text" name="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}"
						title="Sample email:admin12@gmail.com"
						placeholder="Enter Email ID" id="email" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="passCode" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
						title="Must contain special character,number and length=8"
						placeholder="Enter password" id="passId" required></td>
				</tr>
			</table>

			<button type="submit" class="btn btn-success">SUBMIT</button>

			<a href="userRegistration.jsp" class="btn btn-primary">New User</a>
		</form>
		
	</main>
</body>
</html>