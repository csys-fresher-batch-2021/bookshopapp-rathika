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
					<td><input type="text" name="emailId"
						placeholder="Enter Email ID" id="email" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="passCode"
						placeholder="Enter password" id="passId" required></td>
				</tr>
			</table>

			<button type="submit" class="btn btn-success">SUBMIT</button>

			<a href="userRegistration.jsp" class="btn btn-primary">New User</a>
		</form>
	</main>
</body>
</html>