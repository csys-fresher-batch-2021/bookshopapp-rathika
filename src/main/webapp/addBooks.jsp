<%@page import="java.util.* " %>
<%@page import="in.rathika.service.*" %>
 <!DOCTYPE html>
<html lang="en">
<head>
<title>Book Shopping App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Books</h3>
		<form>
     <table class="table-table-bordered" border="2">
     <caption>BOOK DETAILS</caption>
     <thead>
       <th scope="col">S.NO</th>
     <th scope="col">BOOK NAME</th>
     <th scope="col">LANGUAGE</th>
     <th scope="col">NO OF BOOKS</th>
     <th scope="col">COST</th>
     </thead>
     <tbody>
      <%
      Book b1 = new Book();
     // Book bookObj = new Book();
      List<Book> books = BookManager.addBookDetails();
      int i=0;
      for(Book book : books){
    	  i++;
      %>
      <tr>
         <td><%=i %>
         <td><%= book.bookName%></td>
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
