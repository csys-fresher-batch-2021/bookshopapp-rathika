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
					<td><input type="text" name="bookName"
						placeholder="Enter book name" id="bookId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">LANGUAGE</th>
					<td><select name="language" id="lang">
							<option>TAMIL</option>
							<option>ENGLISH</option>
							<option>HINDHI</option>
					</select></td>
				</tr>
				<tr>
					<th scope="col">NO OF BOOKS</th>
					<td><input type="number" name="noOfBooks"
						placeholder="Enter No of Books" id="noOfBookId" required></td>
				</tr>
				<tr>
					<th scope="col">COST</th>
					<td><input type="number" name="cost"
						placeholder="Enter Book Cost" id="costId" required></td>
				</tr>

			</table>
			<button type="submit" class="btn btn-success">SUBMIT</button>
		</form>
		<br /> <a href="view.jsp" class="btn btn-primary">VIEW</a> <a
			href="display.jsp" class="btn btn-danger">DELETE</a>
	</main>
</body>
</html>