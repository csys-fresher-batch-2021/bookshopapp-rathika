<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="in.rathika.model.*"%>
<%@ page import="in.rathika.dao.UserDao"%>
<%@ page import="in.rathika.service.UserService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Estimation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
    
	<%
	String userName = (String) session.getAttribute("LOGGED_IN_USER");
	Double total = (Double) session.getAttribute("TOTAL");
	%>
	
	<table class="table table-bordered" border='1'>
		<thead>
		</thead>
		<tr>
			<th scope="col">USER NAME</th>
			<td><%=userName%></td>

		</tr>
		<%
					
					List<User> users = UserDao.getUserDetails(userName);
					
					for (User userDetails : users) {
						
					%>
					<tr>
					<th scope="col">EMAIL ID</th>
					<td><%=userDetails.getEmail() %></td>
					</tr>
					<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><%=userDetails.getMobile() %></td>
					</tr>
					<tr>
					<th scope="col">ADDRESS</th>
					<td><%=userDetails.getAddress() %></td>
					</tr>
					
				</tr>
				<%
				break;}
				%>
		<tr>
            <th scope="col">TOTAL AMOUNT</th>
			<td><%=total%> Rs</td>
		</tr>
	</table>

	<a href="addCart.jsp" class="btn btn-success">HOME
		</a>
		</main>
</body>
</html>