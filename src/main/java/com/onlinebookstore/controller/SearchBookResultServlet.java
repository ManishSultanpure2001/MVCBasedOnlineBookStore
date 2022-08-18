package com.onlinebookstore.controller;

/* This is responsible to Searched Book Available or not 
 * on the bases of input from SearchBookResult.jsp Page 
 * and set in all Books in comboBox */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.entity.BookdetailsDao;
import com.onlinebookstore.model.UserModel;

public class SearchBookResultServlet extends HttpServlet {

	ArrayList<String> list = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookdetailsDao book = new BookdetailsDao();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		book.setBookName(request.getParameter("bookName"));
		ArrayList list = UserModel.searchBook(book);

		/* searchBook() return list of Available books */

		if ((boolean) list.get(1)) {
			request.setAttribute("bookDetails", list.get(0));
			request.getRequestDispatcher("SearchBookResult.jsp").forward(request, response);
		} else {
			String output = "false";
			response.sendRedirect("SearchBuyBook.jsp?output=false");
		}
	}
}
