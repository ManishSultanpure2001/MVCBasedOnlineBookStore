package com.onlinebookstore.controller;

/* This class is responsible to get 
 * Book Name and Book Price from SearchBookResult.jsp Page
 * and send Email to User With 
 * Book Name and Book Price*/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.entity.UserEmail;
import com.onlinebookstore.model.UserModel;

public class SuccessFullPerches extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserEmail email = new UserEmail();

		/* Responsible to set email Id to send Email After User Successfully Buy Book */

		email.setUserEmail(request.getParameter("email"));
		Book book = new Book();
		book.setBookName(request.getParameter("bookName"));
		book.setBookPrice(request.getParameter("bookPrice"));
		boolean flag = UserModel.purchesedBookData(book, email);

		/* If user Successfully Buy Book and purchesedBookData() return true */

		if (flag) {
			request.setAttribute("bookName", book.getBookName());
			request.getRequestDispatcher("FinalBuyBookMessage.jsp").forward(request, response);
		}

	}
}