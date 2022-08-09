<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<!-- Css Code -->
<link rel="stylesheet" href="MainBookStoreCss.css">
</head>
<body>
	<%
	String output = request.getParameter("output");
	if (output != null) {
		if (output.equals("true")) {
	%>
	<div>
		<h2 id="successHeading">
			"Success Fully Book Deleted"
			<h2>
	</div>
	<%
	} else if (output.equals("false")) {
	%>
	<div>
		<h2 id="failHeading">
			"Try Again Book Not Deleted"
			<h2>
	</div>
	<%
	}
	}
	%>
	<div id="data">
		<center>
			<h1 class="AddBookHeading">
				Welcome in Delete Book Section
				<h1>
		</center>
		<div id="mymenu">
			<ul>
				<li><a href="AdminHome.jsp">Home Page</a></li>
				<li><a href="AddBook.jsp">Add Book</a></li>
				<li><a href="AdminViewBookController">View Book</a></li>
				<li><a href="UpdateBook">Update Book Detail</a></li>
				<li><a href='Login.jsp'>Logout</a></li>
			</ul>
		</div>
		<center>

			<form action="DeleteBookServletController" method="post">

				<table cellpadding="15px">

					<tr>
						<td>Name of Book</td>
						<td><input type="text" name="bookName"
							placeholder="Enter Name"></td>
					</tr>
					<tr>
						<td>Enter Author Name</td>
						<td><input type="text" name="authorName"
							placeholder="Enter Author Name"></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input class="B" type="submit"
							value="Delete Book"></td>
					</tr>
				</table>
			</form>
		</center>
	</div>

</body>
</html>
