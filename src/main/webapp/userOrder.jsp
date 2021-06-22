<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="in.rathika.model.Order"%>
    <%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="in.rathika.dao.OrderDao"%>
<%@ page import="in.rathika.dao.UserDao"%>
<%@ page import="in.rathika.service.OrderService"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<style>
.btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}

/* Darker background on mouse-over */
.btn:hover {
  background-color: RoyalBlue;
}
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
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="addCart.jsp">
			<h3 id="heading">YOUR ORDERS</h3>
			<table class="table table-bordered" id="books">
				<caption></caption>
				<%
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
			%>
				<thead>
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">ORDER ID</th>
						<th scope="col"> USER ID</th>
						<th scope="col"> USER NAME</th>
						<th scope="col">BOOK NAME</th>
						<th scope="col">LANGUAGE</th>
						<th scope="col">TOTAL BOOKS</th>
						<th scope="col">PRICE</th>
						<th scope="col">ORDER DATE</th>
						<th scope="col">DELIVERY DATE</th>
						<th scope="col">STATUS</th>

					</tr>

					<%
					OrderDao orderDao = new OrderDao();
					HttpSession sess = request.getSession();
					String userName = (String) sess.getAttribute("LOGGED_IN_USER");
					int id = UserDao.getId(userName);
					List<Order> orders = OrderDao.getUserOrder(id);
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>

					<tr>
						<td><%=i%></td>
						<td><%=orderDetails.getId() %></td>
						<td><%=orderDetails.getUserId() %></td>
						<td><%=orderDetails.getUserName() %></td>
						<td><%=orderDetails.getBookName()%></td>
						<td><%=orderDetails.getLanguage()%></td>
						<td><%=orderDetails.getNoOfBooks()%></td>
						<td><%=orderDetails.getCost() %></td>
						<td><%=formatter.format(orderDetails.getOrderDate()) %> </td>
					    <td><%=formatter.format(orderDetails.getDeliveryDate()) %> </td>
						<td><%=orderDetails.getStatus() %></td>
						
					</tr>
					<%
					}
					%>

				</thead>
			</table>
			<button class="btn" type="submit"><em class="fa fa-home"></em> Home</button>
		</form>
	</main>
</body>
</html>