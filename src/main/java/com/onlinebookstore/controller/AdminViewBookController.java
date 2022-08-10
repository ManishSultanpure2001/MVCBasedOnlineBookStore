package com.onlinebookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.annotation.MultipartConfig;
import com.bookstore.entity.Book;
import com.onlinebookstore.model.BookModel;


@MultipartConfig(maxFileSize = 16177215)

public class AdminViewBookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	ArrayList<Book>list=BookModel.viewBook();
			request.setAttribute("list", list);
			request.getRequestDispatcher("AdminViewAllBook.jsp").forward(request, response);
		} 
	}