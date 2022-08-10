package com.onlinebookstore.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookstore.model.BookModel;

public class UpdateBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<String> arrayList=BookModel.updateBook();
		System.out.print(arrayList);
		request.setAttribute("list", arrayList);
		request.getRequestDispatcher("UpdateBookMVC.jsp").forward(request, response);

	}

}
