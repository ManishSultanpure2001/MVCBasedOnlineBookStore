<%@page import="com.onlinebookstore.controller.UpdateBook"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.bookstore.entity.Book"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<link rel='stylesheet' href='MainBookStoreCss.css'>
</head>
<body>
	<div id='data'>

		<center>
			<h2 class='AddBookHeading'>Welcome in View Book Section</h2>
		</center>
		<div id='mymenu'>
			<ul>

				<li><a href='AdminHome.jsp'>Home Page</a></li>
				<li><a href='AddBook.jsp'>Add Book</a></li>
				<li><a href='UpdateBook'>Update Book Detail</a></li>
				<li><a href='DeleteBook.jsp'>Delete Book</a></li>
				<li><a href='Login.jsp'>Logout</a></li>
			</ul>
		</div>
		<center>
			<table cellpadding='15px'>
				<tr>
					<td>BookName</td>
					<td>BookPDF</td>
					<td>BookImage</td>
					<td>BookPrice</td>
					<td>BookAuthor</td>
				</tr>
				<%
				ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("list");
				for (Book book : list) {
				%>
				<tr>
					<td><%=book.getBookName()%></td>
					<td><%=book.getBookPDF()%></td>
					<td><img src="Image\\<%=book.getBookImage()%>" width='50'
						height='50'></td>
					<td><%=book.getBookPrice()%></td>
					<td><%=book.getBookAuthor()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</center>
	</div>
</body>
</html>
;
