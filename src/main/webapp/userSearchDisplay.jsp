<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.Map"%>
<%@ page import="in.rathika.model.*"%>
<%@ page import="in.rathika.dao.BookDao"%>
<%@ page import="in.rathika.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Search</title>
<style>
#books {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#books td, #books th {
	border: 1px solid #ddd;
	padding: 8px;
}

#books tr:nth-child(even) {
	background-color: #f2f2f2;
}

#books tr:hover {
	background-color: #ddd;
}

#books th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}

#heading {
	color: #04AA6D;
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form method="post">
			<h3 id="heading">Books</h3>
			<table class="table table-bordered" id="books">
				<caption></caption>
				<thead>
					<tr>
						<%
						HttpSession sess = request.getSession();
						session.setAttribute("JOB", "SEARCHING");
						String role = (String) session.getAttribute("ROLE");
						String user = (String) session.getAttribute("LOGGED_IN_USER");

						if (role == "ADMIN" || user == null) {
						%>
						<th scope="col">S.NO</th>
						<th scope="col">BOOK NAME</th>
						<th scope="col">LANGUAGE</th>
						<th scope="col">NO OF BOOKS</th>
						<th scope="col">PRICE</th>

						<%
						BookDao bookDao = new BookDao();
						List<Book> language = BookDao.getSearch();
						int i = 0;
						for (Book bookDetails : language) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=bookDetails.getBookName()%></td>
						<td><%=bookDetails.getLanguage()%></td>
						<td><%=bookDetails.getNoOfBooks()%></td>
						<td><%=bookDetails.getCost()%> Rs</td>

					</tr>
					<%
					}
					%>
				</thead>
			</table>

			<%
			} else {
			%>

			<table class="table table-bordered" id="books">
				<caption></caption>
				<thead>
					<tr>
                      <th scope="col">S.NO</th>
						<th scope="col">BOOK NAME</th>
						<th scope="col">LANGUAGE</th>
						<th scope="col">NO OF BOOKS</th>
						<th scope="col">PRICE</th>
						<th scope="col">ADD TO CART</th>


						<%
						BookDao bookDao = new BookDao();
						List<Book> language = BookDao.getSearch();
						int i = 0;
						for (Book bookDetails : language) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=bookDetails.getBookName()%></td>
						<td><%=bookDetails.getLanguage()%></td>
						<td><%=bookDetails.getNoOfBooks()%></td>
						<td><%=bookDetails.getCost()%></td>
						<td><a
							href="OrderBookServlet?bookName=<%=bookDetails.getBookName()%>"
							class="btn btn-success">ADD TO CART</a></td>
					</tr>
					<%
					}
					%>

				</thead>
			</table>

			<a href="displayOrder.jsp" class="btn btn-info">VIEW CART</a>
		
		<a href="userOrder.jsp" class="btn btn-success">VIEW ORDER HISTORY</a>
			<%
			}
			%>





		</form>


	</main>
</body>
</html>