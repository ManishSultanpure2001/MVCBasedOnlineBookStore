<%@page import="com.onlinebookstore.model.Book"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.online.bookstore.*"%>

<%@ page import="com.online.bookstore.DatabaseConnectivity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Book book = new Book();
String selected = request.getParameter("id");
List<String> obj = new ArrayList<String>();
try (Connection con = DatabaseConnectivity.dbConnection();) {
	String queryString = "Select * from bookdetails where bookname=?";
	PreparedStatement preparedStatement = con.prepareStatement(queryString);
	preparedStatement.setString(1, selected);
	ResultSet rs = preparedStatement.executeQuery();

	if (rs.next()) {
		obj.add(rs.getString(1));
		obj.add(rs.getString(2));
		obj.add(rs.getString(3));
		obj.add(rs.getString(4));
		obj.add(rs.getString(5));
	}
	out.print(obj);
	out.flush();
}

catch (Exception e) {

	e.printStackTrace();
}
%>