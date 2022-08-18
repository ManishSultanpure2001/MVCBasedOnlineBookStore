package com.onlinebookstore.controller;

/* This is responsible to get Book Details from AddBook.jsp Page
 * and store the details in Database*/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import com.bookstore.entity.BookdetailsDao;
import com.onlinebookstore.model.BookModel;

@MultipartConfig(maxFileSize = 16177215)

public class AddBookController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BookdetailsDao bookdetailsDao = new BookdetailsDao();
		bookdetailsDao.setBookName(request.getParameter("addBookName"));
		bookdetailsDao.setBookPDF(request.getPart("addFileName"));
		bookdetailsDao.setBookImage(request.getPart("addImageName"));
		bookdetailsDao.setBookPrice(request.getParameter("addBookPrice"));
		bookdetailsDao.setAuthorName(request.getParameter("addAuthorName"));
		BookModel book = new BookModel();
		boolean flag = book.addBook(bookdetailsDao);
		// if addBook() return true in flag
		if (flag) {
			request.setAttribute("successMsg", "Book Added SuccessFull");
			request.getRequestDispatcher("AddBook.jsp").forward(request, response);
		}
		// if addBook() return false in flag
		else {
			request.setAttribute("errorMsg", "Book Not Added  SuccessFull");
			request.getRequestDispatcher("AddBook.jsp").forward(request, response);
		}
	}
}
