<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.Map"%>
<%@ page import="in.rathika.model.*"%>
<%@ page import="in.rathika.dao.BookDao"%>
<%@ page import="in.rathika.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<form method="post">

		<h3>Books</h3>
		<table class="table table-bordered">
			<caption></caption>
			<thead>
				<tr>
				   <%
				   HttpSession sess = request.getSession();
				   session.setAttribute("JOB", "SEARCHING");
				   String role = (String) session.getAttribute("ROLE");
					if(role =="ADMIN" || role == null) {
					%>
					<th scope="col">S.NO</th>
					<th scope="col">Book Name</th>
					<th scope="col">Language</th>
					<th scope="col">No Of Books</th>
					<th scope="col">Cost</th>
					
					<%
					BookDao bookDao = new BookDao();
					List<Book> language = bookDao.getSearch();
					int i = 0;
					for (Book bookDetails : language) {
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=bookDetails.getBookName() %></td>
					<td><%=bookDetails.getLanguage() %></td>
					<td><%=bookDetails.getNoOfBooks() %></td>
					<td><%=bookDetails.getCost() %></td>
					
				</tr>
				<%
				}
				%>
				</thead>
		</table>
				
					<%
					} else {
					%>
		
		<table class="table table-bordered">
			<caption></caption>
			<thead>	
						
					<th scope="col">S.NO</th>
					<th scope="col">Book Name</th>
					<th scope="col">Language</th>
					<th scope="col">No Of Books</th>
					<th scope="col">Cost</th>
					
					<%
					BookDao bookDao = new BookDao();
					List<Book> language = bookDao.getSearch();
					int i = 0;
					for (Book bookDetails : language) {
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=bookDetails.getBookName() %></td>
					<td><%=bookDetails.getLanguage() %></td>
					<td><%=bookDetails.getNoOfBooks() %></td>
					<td><%=bookDetails.getCost() %></td>
					<td><a href="OrderBookServlet?bookName=<%=bookDetails.getBookName()%>" class="btn btn-success">ADD TO CART</a></td>
				</tr>
				<%
				}
				%>
					</thead>
		</table>
				<a href="viewCart.jsp" class="btn btn-success">VIEW CART</a>
						<%
					    }
						%>
					
				 	
		

      
</form>
	
	
	</main>
</body>
</html>