package com.onlinebookstore.controller;

/* This class is responsible to 
 * Update Book details in database on the basis of
 * Input from UpdateBookMVC.jsp page */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.entity.Book;
import com.onlinebookstore.model.BookModel;

public class UpdateDataBaseBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		Book book = new Book();
		book.setSelectedItem(request.getParameter("selectedIteam"));
		book.setBookName(request.getParameter("updateName"));
		book.setBookPDF(request.getParameter("updatePDF"));
		book.setBookImage(request.getParameter("updateImage"));
		book.setBookPrice(request.getParameter("updatePrice"));
		book.setBookAuthor(request.getParameter("updateAuthor"));
		boolean flag = BookModel.updateBookDatabases(book);

		/* updateBookDatabases() return true if book Updated Successfully */

		if (flag) {
			response.sendRedirect("UpdateBookMVC.jsp?output=true");
		} else {
			response.sendRedirect("UpdateBookMVC.jsp?output=false");
		}
	}

}
