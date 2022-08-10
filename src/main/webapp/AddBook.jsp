<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<!-- Css Code -->
<link rel="stylesheet" href="MainBookStoreCss.css">
</head>
<body>
	<%if(request.getAttribute("successMsg")!=null) {%>
<h1 style="color:green"><%=request.getAttribute("successMsg") %></h1>
<%} %>
<%if(request.getAttribute("errorMsg")!=null) {%>
<h1 style="color:red"><%=request.getAttribute("errorMsg") %></h1>
<%} %>	<div id="data">
		<center>
			<h1 class="AddBookHeading">
				Welcome in Add Book Section
				<h1>
		</center>
		<div id="mymenu">
			<ul>
				<li><a href="AdminHome.jsp">Home Page</a></li>
				<li><a href="AdminViewBookController">View Book</a></li>
				<li><a href=UpdateBook>Update Book Detail</a></li>
				<li><a href="DeleteBook.jsp">Delete Book</a></li>
				<li><a href='Login.jsp'>Logout</a></li>
			</ul>
		</div>
		<center>

			<form action="AddBookController" enctype='multipart/form-data'
				method='Post'>
				<table cellpadding="15px">

					<tr>
						<td>Name of Book</td>
						<td><input type="text" name="addBookName"
							placeholder="Enter Name"></td>
					</tr>
					<tr>
						<td>Book pdf upload</td>
						<td><input type="file" id="myFile" name="addFileName"></td>
					</tr>
					<tr>
						<td>Book image</td>

						<td><input type="file" id="myImage" name="addImageName"></td>

					</tr>
					<tr>
						<td>Enter Price</td>
						<td><input type="number" name="addBookPrice"
							placeholder="Enter Book Price"></td>
					</tr>
					<tr>
						<td>Enter Author Name</td>
						<td><input type="text" name="addAuthorName"
							placeholder="Enter Author Name"></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input class="B" type="submit"
							value="Add Book"></td>
					</tr>
				</table>
			</form>
		</center>
	</div>

</body>
</html>
