package com.onlinebookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import com.bookstore.entity.RegistrationDao;
import com.bookstore.util.*;
import com.onlinebookstore.model.Authontication;

/**
 * Servlet implementation class UserLoginMVC
 */

public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RegistrationDao registrationDao = new RegistrationDao();
		registrationDao.setUserEmail(request.getParameter("loginUserEmail"));
		registrationDao.setUserPassword(request.getParameter("loginUserPassword"));
		Authontication authontication = new Authontication();

		String responString = authontication.login(registrationDao);
		if (registrationDao != null) {
			System.out.print("come");
			if (responString.equals("Admin")) {
				request.setAttribute("userEmail", registrationDao.getUserEmail());
				request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
			} else if (responString.equals("User")) {

				request.setAttribute("userEmail", registrationDao.getUserEmail());
				request.getRequestDispatcher("UserHomeProfile.jsp").forward(request, response);
			}
		} else {
			System.out.print("Not come");
			request.setAttribute("errorMsg", "Not Registation SuccessFull");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}
}
