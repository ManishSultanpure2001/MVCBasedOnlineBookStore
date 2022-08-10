package com.onlinebookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.onlinebookstore.model.BookModel;

public class UpdateDataBaseBook extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Book book=new Book();
		book.setSelectedItem(request.getParameter("selectedIteam"));
		book.setBookName(request.getParameter("updateName"));
		book.setBookPDF(request.getParameter("updatePDF"));
		book.setBookImage(request.getParameter("updateImage"));
		book.setBookPrice(request.getParameter("updatePrice"));
		book.setBookAuthor(request.getParameter("updateAuthor"));
	boolean flag=	BookModel.updateBookDatabases(book);
	if(flag) {
		response.sendRedirect("UpdateBookMVC.jsp?output=true");
	}else {
		response.sendRedirect("UpdateBookMVC.jsp?output=false");
	}
	}

}
