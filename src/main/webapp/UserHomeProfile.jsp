 
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
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body class="container" id="USerAdminPage">
	<div class="row" id="heading">
		 
		<h2 id="mainHeader">Welcome User to Online Book Store portal</h2>
	</div>

	<div class="row" id="descriptionHeading">
		<div class="col-6">
			<form action="SearchBook.jsp">

				<h1 class="homeLabel">Buy Book</h1>
				<div id="peragraphDiv">
					<p>* Once you learn to read,</p>
					<p>you will be forever free.</p>
					<p id="AuthorName">- Frederick Douglass</p>
					<p>* a book which people praise and don't read.</p>
					<p id="AuthorName">- Mark Twain</p>
					<input type="submit" value="Buy Book" class="HomeButton">
				</div>
			</form>
		</div>
		<div class="col-6">
			<form action="UserBuyBookData.jsp">
				<h1 class="profileLabel">Profile</h1>

				<div id="peragraphDiv">
					<p>* Think before you speak.</p>
					<p>Read before you think.</p>
					<p id="AuthorName">- Fran Lebowitz</p>
					<p>* Today a reader, tomorrow a leader.</p>
					<p id="AuthorName">- Margaret Fuller</p>
					<input type="submit" value="Profile" class="profileButton">
				</div>
			</form>
		</div>
	</div>
</body>
</html>