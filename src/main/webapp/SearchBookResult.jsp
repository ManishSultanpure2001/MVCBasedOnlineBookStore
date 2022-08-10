<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bookstore.entity.*"%>
<html>
<head>
<link rel='stylesheet' href='MainBookStoreCss.css'>
</head>
<body>
	<div id='data'>
		<center>
			<h2 class='AddBookHeading'>Welcome in Buy Book Section</h2>
		</center>
		<div id='mymenu'>
			<ul>
				<li><a href='UserHomeProfile.jsp'>Home Page</a></li>
				<li><a href='SearchBuyBook.jsp'>Search Book</a></li>
				<li><a href=UserBuyHistoryServlet>Your Profile</a></li>
			</ul>
		</div>
		<center>
			<form action='SuccessFullPerches'>
				<%
				BookdetailsDao book = (BookdetailsDao) request.getAttribute("bookDetails");
				%>
				<table cellpadding='15px'>
					<tr>
						<td>Enter Email FOr Conformation Mail</td>
						<td><input type='text' name='email'
							placeholder='Enter Email ID'></td>
					</tr>
					<tr>
						<td>Book Name</td>
						<td><input type='text' name='bookName'
							value=<%=book.getBookName()%> placeholder="Enter Name" readonly></td>
						<td><img src="Image\\<%=book.getBookName()%>.png" width='100'
							height='100'></td>
					</tr>
					<tr>
						<td>Book Price</td>
						<td><input type='number' name='bookPrice'
							value="<%=book.getBookPrice()%>" placeholder='Enter Book Price'
							readonly></td>
					</tr>
					<tr>
						<td align='center' colspan='2'><input class='B' type='submit'
							value='Buy Book'></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>