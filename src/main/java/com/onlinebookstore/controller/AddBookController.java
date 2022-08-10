package com.onlinebookstore.controller;

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

		
		BookdetailsDao bookdetailsDao = new BookdetailsDao();

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			response.getWriter().append("Served at: ").append(request.getContextPath());
			bookdetailsDao.setBookName(request.getParameter("addBookName"));
			bookdetailsDao.setBookPDF(request.getPart("addFileName"));
			bookdetailsDao.setBookImage(request.getPart("addImageName"));
			bookdetailsDao.setBookPrice(request.getParameter("addBookPrice"));
			bookdetailsDao.setAuthorName(request.getParameter("addAuthorName"));
			BookModel book=new BookModel();
			boolean flag= book.addBook(bookdetailsDao);
			if(flag) {
				request.setAttribute("successMsg", "Book Added SuccessFull");
				request.getRequestDispatcher("AddBook.jsp").forward(request, response);
			}else {
				request.setAttribute("errorMsg", "Book Not Added  SuccessFull");
				request.getRequestDispatcher("AddBook.jsp").forward(request, response);
			}
		}
	}	


