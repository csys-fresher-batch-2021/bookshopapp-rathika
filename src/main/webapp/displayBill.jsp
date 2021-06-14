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

#books tr:nth-child(even){background-color: #f2f2f2;}

#books tr:hover {background-color: #ddd;}

#books th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="login.jsp" method="post">

			<h3>Books</h3>
			<table class="table table-bordered" id="books">
				<caption>bill</caption>
				<thead>
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">Book Name</th>
						<th scope="col">Language</th>
						<th scope="col">No Of Books</th>
						<th scope="col">Cost</th>
						<th scope="col">Total</th>


						<%
						List<Order> orders = OrderService.getOrderDetails();
						int i = 0;
						for (Order orderDetails : orders) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=orderDetails.getBookName()%></td>
						<td><%=orderDetails.getLanguage()%></td>
						<td><%=orderDetails.getNoOfBooks()%></td>
						<td><%=orderDetails.getCost()%> Rs</td>
						<td><%=orderDetails.getNoOfBooks() * orderDetails.getCost()%> Rs</td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>

		</form>
		
	</main>
</body>
</html>