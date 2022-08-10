package com.onlinebookstore.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookstore.model.UserModel;


public class UserBuyHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 ArrayList list= UserModel.purchesedBookList();
			request.setAttribute("listData", list);
			request.getRequestDispatcher("UserBuyedHistory.jsp").forward(request, response);
		 
		 
		 
	}
}
