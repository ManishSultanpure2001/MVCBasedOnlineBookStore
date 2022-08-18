package com.onlinebookstore.controller;

/* This class is responsible to set available Books Name 
 * in ComboBox of  UpdateBookMVC.jsp Page for 
 * Update Book details */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookstore.model.BookModel;

public class UpdateBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<String> arrayList = BookModel.updateBook();

		/* updateBook() return list of Book in arrayList variable */

		request.setAttribute("list", arrayList);
		request.getRequestDispatcher("UpdateBookMVC.jsp").forward(request, response);

	}

}
