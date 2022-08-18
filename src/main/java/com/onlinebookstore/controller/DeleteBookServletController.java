package com.onlinebookstore.controller;

/* This class is responsible to get Book Name from DeleteBook.jsp Page
 * and Delete the details from Database on the basis of 
 * Book Name and Author Name*/

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import com.bookstore.entity.BookdetailsDao;
import com.onlinebookstore.model.BookModel;

@MultipartConfig(maxFileSize = 16177215)
public class DeleteBookServletController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		BookdetailsDao bDao = new BookdetailsDao();
		bDao.setBookName(request.getParameter("bookName"));
		bDao.setAuthorName(request.getParameter("authorName"));
		boolean flag = BookModel.deleteBook(bDao);
		/* if deleteBook() return true */
		if (flag) {
			request.setAttribute("successMsg", "Book Deleted SuccessFull");
			request.getRequestDispatcher("DeleteBook.jsp").forward(request, response);
		}
		/* if deleteBook() return false */
		else {
			request.setAttribute("errorMsg", "Book Not Deleted SuccessFull");
			request.getRequestDispatcher("DeleteBook.jsp").forward(request, response);

		}

	}
}
