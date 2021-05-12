<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add books</title>
</head>
<body>
<h1>ADD BOOKS</h1>
	<form action="AddProductServlet" method="post">
<table>
        <tr><td>BOOKNAME</td>
            <td><input type="text" name="bookName" placeholder = "Enter book name" id="bookId"required autofocus></td>
            </tr>
            <tr><td>LANGUAGE</td>
                <td><select name="language" id="lang">
  <option>TAMIL</option>
  <option>ENGLISH</option>
  <option>HINDHI</option>
</select></td>
                </tr>
    <tr><td>NO OF BOOKS</td>
    <td><input type="number" name="noOfBooks" placeholder = "Enter No of Books" id="noOfBookId" required autofocus></td>
    </tr>
    <tr><td>COST</td>
    <td><input type="number" name="cost" placeholder="Enter Book Cost" id="costId" required></td>
    </tr>
    
</table>
<button type="submit">SUBMIT</button>
</form>
</body>
</html>