package com.onlinebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookdetailsDao;
import com.bookstore.entity.UserEmail;
import com.bookstore.util.DatabaseConnectivity;
import com.onlinebookstore.model.UserModel;

public class SuccessFullPerches extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserEmail email=new UserEmail();
		email.setUserEmail(request.getParameter("email"));
		Book book=new Book();
		book.setBookName(request.getParameter("bookName"));
		book.setBookPrice(request.getParameter("bookPrice"));
		boolean flag=	UserModel.purchesedBookData(book,email);
		if(flag){
		request.setAttribute("bookName", book.getBookName());
		request.getRequestDispatcher("FinalBuyBookMessage.jsp").forward(request, response);
		}
		
	}
}