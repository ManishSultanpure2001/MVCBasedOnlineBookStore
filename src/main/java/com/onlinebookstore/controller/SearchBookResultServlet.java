package com.onlinebookstore.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.cj.xdevapi.Statement;
import com.online.bookstore.DatabaseConnectivity;
import com.onlinebookstore.model.BookdetailsDao;

public class SearchBookResultServlet extends HttpServlet {

	ArrayList<String> list = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookdetailsDao book = new BookdetailsDao();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		book.setBookName(request.getParameter("bookName"));
		try {
			Connection con = DatabaseConnectivity.dbConnection();
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from bookdetails where bookname='" + book.getBookName() + "' ");
			if (rs.next()) {
				book.setBookName(rs.getString(1));
				book.setBookPrice(rs.getString(4));
				request.setAttribute("bookDetails", book);
				request.getRequestDispatcher("SearchBookResult.jsp").forward(request, response);
			} else {
				String output = "false";
				response.sendRedirect("SearchBuyBook.jsp?output=false");
			}
			con.close();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}
