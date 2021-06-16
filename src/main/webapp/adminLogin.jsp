<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="LoginServlet" method="post">
			<table>
				<caption>ADMIN LOGIN</caption>
				<tr>
					<th scope="col">USER NAME</th>
					<td><input type="text" name="userName" pattern="[A-Za-z\s]{3,}" title="Name must have 3 Character"
						placeholder="Enter user name" id="userId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
						title="Must match your password" placeholder="Enter password" id="passId" required></td>
				</tr>
			</table>

			<button type="submit" class="btn btn-primary">SUBMIT</button>
		</form>
	</main>
</body>
</html>