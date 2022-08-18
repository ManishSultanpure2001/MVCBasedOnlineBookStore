package com.onlinebookstore.controller;

/* This class is responsible to 
 * show all Purchased Book  by User */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebookstore.model.UserModel;

public class UserBuyHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList list = UserModel.purchesedBookList();

		/* purchesedBookList() return list Of buyed books by user */

		request.setAttribute("listData", list);
		request.getRequestDispatcher("UserBuyedHistory.jsp").forward(request, response);
	}
}
