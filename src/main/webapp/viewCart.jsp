<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.Map"%>
<%@ page import="in.rathika.model.Order"%>
<%@ page import="in.rathika.dao.OrderDao"%>
<%@ page import="in.rathika.service.OrderService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">


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
					<th scope="col">OREDR BOOKS</td></th>
					
					<%
					HttpSession sess = request.getSession();
					session.setAttribute("JOB", "REMOVE");
					OrderDao orderDao = new OrderDao();
					List<Order> orders = orderDao.getOrder();
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=orderDetails.getBookName() %></td>
					<td><%=orderDetails.getLanguage() %></td>
					<td><%=orderDetails.getNoOfBooks() %></td>
					<td><%=orderDetails.getCost() %></td>
					
				
					<td><form action="CofirmOrderServlet" method="post"> <input type="number" name="noBooks"
					placeholder="Enter Number of books" id="bookId" required ></form></td>
					<td><button type="submit" class="btn btn-success">Confirm Order</button></td>
					<td><a href="DeleteBookServlet?bookName=<%=orderDetails.getBookName() %>" class="btn btn-danger">DELETE</a></td>
				</tr>
				<%
				}
				%>
			</thead>
		</table>
      
     
	
	 <a href="viewCart.jsp" class="btn btn-primary">VIEW RESPONSE</a>
	</main>
</body>
</html>