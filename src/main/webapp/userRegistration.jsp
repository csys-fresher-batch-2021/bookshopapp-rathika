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
					<td><input type="text" name="userName"  pattern="[A-Za-z\s]{3,}" title="Name must have 3 Character"
						placeholder="Enter user name" id="userId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">EMAIL</th>
					<td><input type="email" name="email" placeholder="Enter Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}"
						title="Sample email:admin12@gmail.com"  id="emailId" required></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" name="mobile" onchange="phonenumberValid()"
						title=" A 10 digit number start from 6-9"   placeholder="Enter mobile number" id="mobileId" required></td>
				<tr>
					<th scope="col">ADDRESS</th>
					<td><input type="text" name="address"  pattern="[A-Za-z0-9\s]{3,}" title="Address must contain 3 charachter"
						placeholder="Enter Address" id="addressId" required></td>
				</tr>
				<tr>
					<th scope="col">AGE</th>
					<td><input type="number" name="age" placeholder="Enter AGE" onchange="ageValid()"
						id="ageId" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="pass" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
						title="Must contain special character,number and length=8" placeholder="Enter Password" id="passId" required></td>
				</tr>
				<tr>
					<th scope="col">RE-ENTER PASSWORD</th>
					<td><input type="password" name="reenterPass" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
						title="Must match your password" placeholder="Re-Enter Password" id="passId" required></td>
				</tr>
			</table>
			
			<button type="submit" class="btn btn-success">REGISTER</button>
		
		</form>
		<script>
			
			function ageValid() {
				let age = document.querySelector("#ageId").value;
				if (age>0 && age<=100) {

				} else {
					alert("Invalid Age");
					event.preventDefault();
				}
			}
			function phonenumberValid() {
				let mobileNumber = document.querySelector("#mobileId").value;
				if (mobileNumber.trim().length == 10) {

				} else {
					alert("Incorrect Mobile Number");
					event.preventDefault();
				}
			}
			</script>
	</main>
</body>
</body>
</html>