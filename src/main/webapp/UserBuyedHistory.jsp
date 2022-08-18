<%-- <%@page import="com.online.bookstore.UserEmail"%> --%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.FileInputStream"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.bookstore.util.DatabaseConnectivity"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Buy Data</title>
<link rel='stylesheet' href='MainBookStoreCss.css'>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>

	<div id='data'>
		<center>
			<h2 class='AddBookHeading'>Welcome in User Profile Section</h2>
		</center>
		<div id='mymenu'>
			<ul>
				<li><a href='UserHomeProfile.jsp'>Home Page</a></li>
				<li><a href='SearchBuyBook.jsp'>Buy Book</a></li>
				<li><a href='Login.jsp'>Logout</a></li>
			</ul>
		</div>
		<center>
			<table cellpadding='15px'>
				<tr>
					<td>Your Books</td>

					<td><select name="userSelectedIteam" onchange="demo()"
						id="userComboSelectedValue">
							<option>Select Book</option>
							<%
							ArrayList<String> list = (ArrayList) request.getAttribute("listData");
							System.out.print(list);
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
							%>
							<option><%=list.get(i)%></option>
							<%
							}
							}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Name of Book</td>
					<td><input type='text' name='bookName' id="bName"
						placeholder='Enter Name' readonly></td>
				</tr>

				<tr>
					<td>Download pdf upload</td>
					<td><a id="bPDF"> Download</td>
					<td></a></td>
					<td><img id="myImg" alt='Select Any Book' width='100'
						height='100'></td>

				</tr>
				<tr>
					<td>Download Book image</td>
					<td><a id="bImage" download>Download</a></td>

				</tr>
				<tr>
					<td>Enter Price</td>
					<td><input type='number' name='bookPrice' id="bPrice"
						placeholder='Enter Book Price' readonly></td>
				</tr>
				<tr>
					<td>Enter Author Name</td>
					<td><input type='text' name='authorName' id="bAuthor"
						placeholder='Enter Author Name' readonly></td>
			</table>
		</center>
	</div>

</body>
</html>



<script src="component/jquery/jquery.js" type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="component/jquery/jquery.min.js" type="text/javascript"></script>
<script src="component/jquery.validate.min.js" type="text/javascript"></script>
<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	function demo() {

		var id = document.getElementById('userComboSelectedValue').value;
		$
				.ajax({
					type : "GET",
					url : "Edit_returnAjax.jsp",
					data : {
						"id" : id
					},

					success : function(data) {
						data = data.replace(/(\r\n|\n|\r\t)/gm, "");
						data = data.trim();
						data = data.substring(1, data.length - 1).trim();
						var t = data.split(",");
						document.getElementById("bName").value = t[0];
						document.getElementById("bPDF").href = "PDF/" + t[0]
								+ ".pdf";
						document.getElementById("bImage").href = "Image/"
								+ t[0] + ".png";
						document.getElementById("myImg").src = "Image/" + t[0]
								+ ".png";

						var value = parseFloat(t[3]);
						document.getElementById("bPrice").value = value;
						document.getElementById("bAuthor").value = t[4];
						for (var i = 0; i < t.length; i++) {
							console.log(t[i]);
						}

					}

				});
	}
</script>
