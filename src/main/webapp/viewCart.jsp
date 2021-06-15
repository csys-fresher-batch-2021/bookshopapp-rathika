<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
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
</style>
</head>
<body>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
      <h3>Books</h3>
		<table class="table table-bordered" id="books">
			<caption></caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">BOOK NAME</th>
					<th scope="col">LANGUAGE</th>
					<th scope="col">TOTAL BOOKS</th>
					<th scope="col">PRICE</th>
					<th scope="col">ORDER BOOKS</th>
					<th scope="col">CONFRIM</th>
					<th scope="col">DELETE</th>
					
					<%
					HttpSession sess = request.getSession();
					session.setAttribute("JOB", "REMOVE");
					OrderDao orderDao = new OrderDao();
					List<Order> orders = OrderDao.getOrder();
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=orderDetails.getBookName() %></td>
					<td><%=orderDetails.getLanguage() %></td>
					<td><%=orderDetails.getNoOfBooks() %></td>
					<td><%=orderDetails.getCost() %> Rs</td>
					
				
					<td><form action="CofirmOrderServlet"> <input type="number" name="noBooks"
					placeholder="Enter Number of books" id="bookId" required ></td>
					<td><button class="btn btn-success"  type="submit">CONFRIM ORDER</button></td>
					
					<td><a href="DeleteBookServlet?bookName=<%=orderDetails.getBookName()%>" class="btn btn-danger">DELETE</a></td>
				</tr>
				<%
				session.setAttribute("bookName",orderDetails.getBookName());
				%>
				</form>
		   <%
			}
			%>
		</thead>
		</table>
	
				 
		
    <a href="addCart.jsp" class="btn btn-primary">BUY MORE</a>
    <a href="displayOrder.jsp" class="btn btn-primary">view</a>
	
	
	</main>
</body>
</html>