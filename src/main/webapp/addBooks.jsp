<%@page import="java.util.* " %>
<%@page import="in.rathika.service.*" %>
 <!DOCTYPE>
<html>
<head>
<title>Book Shopping App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Books</h3>
		<form>
     <table class="table-table-bordered" border="2">
     <thead>
       <th>S.NO</th>
     <th>BOOK NAME</th>
     <th>LANGUAGE</th>
     <th>NO OF BOOKS</th>
     <th>COST</th>
     </thead>
     <tbody>
      <%
      List<Book> books = BookManager.addBookDetails();
      int i=0;
      for(Book book : books){
    	  i++;
      %>
      <tr>
         <td><%=i %>
         <td><%= book.bookName %></td>
         <td><%= book.language %></td>
         <td><%= book.noOfBooks %></td>
         <td><%= book.cost %></td>
     </tr>
     <% } %>
     </tbody>
   </table>  
        
</form>
		
	</main>
</body>
</html>
