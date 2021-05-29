<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="in.rathika.model.*"%>
<%@ page import="in.rathika.dao.BookDao"%>
<%@ page import="in.rathika.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="login.jsp" method="post">

			<h3>Books</h3>
			<table class="table table-bordered">
				<caption></caption>
				<thead>
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">Book Name</th>
						<th scope="col">Language</th>
						<th scope="col">No Of Books</th>
						<th scope="col">Cost</th>

						<%
						BookDao bookDao = new BookDao();
						List<Book> books = bookDao.getBook();
						int i = 0;
						for (Book bookDetails : books) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=bookDetails.getBookName()%></td>
						<td><%=bookDetails.getLanguage()%></td>
						<td><%=bookDetails.getNoOfBooks()%></td>
						<td><%=bookDetails.getCost()%></td>
						<td><a
							href="DeleteBookServlet?bookName=<%=bookDetails.getBookName()%>"
							class="btn btn-danger">Delete</a></td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>

			<button type="submit">order</button>
		</form>

		<!-- <a href="addBookDetails.jsp">Add Book</a> -->
	</main>
</body>
</html>