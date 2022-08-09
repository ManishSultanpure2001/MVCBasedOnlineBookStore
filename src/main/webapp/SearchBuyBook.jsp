<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
String output = request.getParameter("output");

if (output != null) {
	if (output.equals("false")) {
%>
<div>
	<h2 id="failHeading">
		"Try Again Book Not Avilable"
		<h2>
</div>
<%
}
}
%>

<html>
<head>
<!-- Css Code -->
<link rel="stylesheet" href="MainBookStoreCss.css">
</head>
<body>

	<div id="data">
		<div id='mymenu'>
			<ul>
				<li><a href='UserHomeProfile.jsp'>Home Page</a></li>
				<li><a href='UserBuyHistoryServlet'>Your Profile</a></li>
			</ul>
		</div>
		<center>
			<h1 class="AddBookHeading">
				Welcome in Search Book Section for Perchash Book
				<h1>
					<form action="SearchBookResultServlet">
						<table cellpadding="15px">

							<tr>
								<td>Name of Book</td>
								<td><input type="text" name="bookName"
									placeholder="Enter Name of Book"></td>
							</tr>

							<tr>
								<td align="center" colspan="2"><input class="B"
									type="submit" value="Search Book"></td>
							</tr>
						</table>
					</form>
		</center>
	</div>

</body>
</html>
