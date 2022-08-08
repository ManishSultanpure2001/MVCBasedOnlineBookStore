<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="MainBookStoreCss.css" />

<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
>

</head>
<body class="container" id="USerAdminPage">
	<center>
		<div class="row" id="heading">

			<h2 id="mainHeader">Welcome Admin to Online Book Store portal</h2>
		</div>
	</center>
	<div id="mymenu">
		<ul>
			<li><a href="AddBook.jsp">Add Book</a></li>
			<li><a href="AdminViewBookController">View Book</a></li>
			<li><a href="UpdateBook.jsp">Update Book Detail</a></li>
			<li><a href="DeleteBook.jsp">Delete Book</a></li>
			<li><a href='Login.jsp'>Logout</a></li>
		</ul>
	</div>
	<div class="row" id="descriptionHeading">
		<div class="col-6">
			<center>
				<form action="Login.jsp">

					<h1 class="homeLabel">Logout</h1>
					<div id="peragraphDiv">
						<p>* Once you learn to read,</p>
						<p>you will be forever free.</p>
						<p id="AuthorName">- Frederick Douglass</p>
						<p>* a book which people praise and don't read.</p>
						<p id="AuthorName">- Mark Twain</p>
						<input type="submit" value="Logout" class="HomeButton">
					</div>
				</form>
			</center>
		</div>
	</div>
</body>
</html>