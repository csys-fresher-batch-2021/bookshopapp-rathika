<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>add books</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h1>ADD BOOKS</h1>
		<form action="AddBooksServlet" method="post">
			<table>
				<caption>BOOK DETAILS</caption>
				<tr>
					<th scope="col">BOOKNAME</th>
					<td><input type="text" name="bookName" pattern="[A-Za-z\s]{3,}" title="Name must have 3 Character"
						placeholder="Enter book name" id="bookId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">LANGUAGE</th>
					<td><select name="language" id="lang">
							<option>TAMIL</option>
							<option>ENGLISH</option>
							<option>HINDI</option>
					</select></td>
				</tr>
				<tr>
					<th scope="col">NO OF BOOKS</th>
					<td><input type="number" name="noBookId" onchange="ValidNoOfBooks()"
						placeholder="Enter No of Books" id="noBookId" required></td>
				</tr>
				<tr>
					<th scope="col">COST IN Rs</th>
					<td><input type="number" name="costId" onchange="validCost()"
						placeholder="Enter Book Cost" id="costId" required></td>
				</tr>

			</table>
			<button type="submit" class="btn btn-success">SUBMIT</button>
		</form>
		<br /> <a href="view.jsp" class="btn btn-primary">VIEW</a> <a
			href="display.jsp" class="btn btn-danger">DELETE</a>
			<a href="viewOrder.jsp" class="btn btn-success">VIEW ORDER</a>
			<script>
			
			function validCost() {
				let cost = document.querySelector("#costId").value;
				if (cost>0 && cost<=5000) {

				} else {
					alert("Invalid Cost");
					event.preventDefault();
				}
			}
			function ValidNoOfBooks() {
				let noOfBooks = document.querySelector("#noBookId").value;
				if (noOfBooks>0 && noOfBooks<10000) {

				} else {
					alert("Incorrect No Of Books");
					event.preventDefault();
				}
			}
			</script>
	</main>
</body>
</html>