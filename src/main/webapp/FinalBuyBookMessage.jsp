<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='MainBookStoreCss.css'>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id='data'>
		<center>
			<%
			String name = (String) request.getAttribute("bookName");
			%>
			<h1 class='AddBookHeading'>
				Congratulations You have successFully purchased
				<%=name%>
				Book
			</h1>
		</center>
	</div>
</body>
</html>