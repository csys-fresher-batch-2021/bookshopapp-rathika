<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="in.rathika.model.Order"%>
<%@ page import="in.rathika.dao.OrderDao"%>
<%@ page import="in.rathika.service.OrderService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="BillServlet" method="post">
			<h3>Books</h3>
			<table class="table table-bordered">
				<caption></caption>
				<thead>
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">BOOK NAME</th>
						<th scope="col">LANGUAGE</th>
						<th scope="col">TOTAL BOOKS</th>
						<th scope="col">COST</th>
						<th scope="col">BUY MORE</th>

					</tr>

					<%
					OrderDao orderDao = new OrderDao();
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
						<td><a
							href="DeleteCartServlet?bookName=<%=orderDetails.getBookName()%>"
							class="btn btn-danger">CANCEL</a></td>

					</tr>
					<%
					}
					%>

				</thead>
			</table>
			<button class="btn btn-success">BILL</button>
			<a href="addCart.jsp" class="btn btn-primary">BUY MORE</a>
		</form>
	</main>
</body>
</html>