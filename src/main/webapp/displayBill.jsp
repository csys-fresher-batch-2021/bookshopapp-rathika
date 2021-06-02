<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="in.rathika.model.*"%>
<%@ page import="in.rathika.dao.OrderDao"%>
<%@ page import="in.rathika.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BILL</title>
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
						<th scope="col">Total</th>


						<%
						List<Order> orders = OrderDao.getConfrimOrder();
						int i = 0;
						for (Order orderDetails : orders) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=orderDetails.getBookName()%></td>
						<td><%=orderDetails.getLanguage()%></td>
						<td><%=orderDetails.getNoOfBooks()%></td>
						<td><%=orderDetails.getCost()%></td>
						<td><%=orderDetails.getNoOfBooks() * orderDetails.getCost()%></td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>

		</form>
		<%
		String userName = (String) session.getAttribute("LOGGED_IN_USER");
		Double total = (Double) session.getAttribute("TOTAL");
		%>
		<h1>YOUR TOTAL BILL</h1>
		<table class="table table-bordered">
			<thead>
			</thead>
			<tr>
				<th scope="col">USER NAME</th>
				<th scope="col">TOTAL AMOUNT</th>
			</tr>
			<tr>
				<td><%=userName%>
				<td><%=total%>
			</tr>
		</table>

		<a href="addCart.jsp" class="btn btn-success">CONFRIM BOOKING</a>
	</main>
</body>
</html>