<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!-- Html Code -->

<html>
<head>
<link rel="stylesheet" href="MainBookStoreCss.css" />
</head>
<body>
	<%
	if (request.getAttribute("successMsg") != null) {
	%>
	<h1 style="color: green"><%=request.getAttribute("successMsg")%></h1>
	<%
	}
	%>
	<%
	if (request.getAttribute("errorMsg") != null) {
	%>
	<h1 style="color: red"><%=request.getAttribute("errorMsg")%></h1>
	<%
	}
	%>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<div id="mymenu">
		<ul>

			<li><a href="Login.jsp">Login</a></li>
			<li><a href="RegisTraion.jsp">Registration</a></li>
		</ul>
	</div>
	<div id="data">

		<center>
			<form action="LoginController" method="post">
				<table cellpadding="15px">
					<tr>
						<td>Enter email</td>
						<td><input type="email" name="loginUserEmail" id="email"
							placeholder="Enter Email"></td>
					</tr>
					<tr>
						<td>Enter Pass</td>
						<td><input type="password" name="loginUserPassword"
							placeholder="Enter Password"></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input class="B" type="submit"
							value="Login"></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>

