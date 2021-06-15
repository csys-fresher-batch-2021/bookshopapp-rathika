<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="java.time.format.DateTimeFormatter"%>
    <%@page import="java.util.Map"%>
<%@ page import="in.rathika.model.Order"%>
<%@ page import="in.rathika.dao.OrderDao"%>
<%@ page import="in.rathika.service.OrderService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
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
#heading{
  color:#04AA6D;
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
</style>
</head>
<body>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
      <h3 id="heading">VIEW ORDERD BOOKS</h3>
		<table class="table table-bordered" id="books">
			<caption></caption>
			<%
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
			%>
			<thead>
				<tr>
					<th scope="col">ORDER ID</th>
					<th scope="col">USER ID</th>
					<th scope="col">USER NAME</th>
					<th scope="col">BOOK NAME</th>
					<th scope="col">LANGUAGE</th>
					<th scope="col">TOTAL BOOKS</th>
					<th scope="col">PRICE</th>
					
					<th scope="col">ORDER DATE</th>
					<th scope="col">DELIVERY DATE</th>
					<th scope="col">STATUS</th>
					<th scope="col">DELIVER</th>
					<th scope="col">CANCEL</th>
					
					<%
					
					OrderDao orderDao = new OrderDao();
					List<Order> orders = OrderDao.getOrderDetails();
					
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>
				
				<tr>
					<%-- <td><%=i%></td> --%>
					<td><%=orderDetails.getId() %></td>
					<td><%=orderDetails.getUserId() %></td>
					<td><%=orderDetails.getUserName() %></td>
					<td><%=orderDetails.getBookName() %></td>
					<td><%=orderDetails.getLanguage() %></td>
					<td><%=orderDetails.getNoOfBooks() %></td>
					<td><%=orderDetails.getCost() %> Rs</td>
					
					<td><%=formatter.format(orderDetails.getOrderDate()) %> </td>
					<td><%=formatter.format(orderDetails.getDeliveryDate()) %> </td>
					
					<td><%=orderDetails.getStatus() %></td>
					<td><a href="AcceptOrderServlet?orderId=<%=orderDetails.getId() %>" class="btn btn-success">DELIVERED</a></td>
					<td><a href="RejectOrderServlet?orderId=<%=orderDetails.getId()%>" class="btn btn-danger">CANCELLED</a></td>
				<%-- <td><a
							href="OrderBookServlet?bookName=<%=bookDetails.getBookName()%>"
							class="btn btn-success">ADD TO CART</a></td> --%>
					
				</tr>
				
		   <%
			}
			%>
		</thead>
		</table>
	<a href="addBookDetails.jsp" class="btn btn-primary">BACK</a>
	
	</main>

</body>
</html>