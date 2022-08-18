package com.onlinebookstore.controller;

/* This class is responsible to get User Details from Login.jsp Page
 * and Authenticate from Database on the basis of 
 * Input field Data from Login.jsp page*/

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.entity.RegistrationDao;
import com.onlinebookstore.model.Authontication;

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
			/* if login() Method return Admin in responString */
			if (responString.equals("Admin")) {
				request.setAttribute("userEmail", registrationDao.getUserEmail());
				request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
			}
			/* if login() Method return User in responString */
			else if (responString.equals("User")) {

				request.setAttribute("userEmail", registrationDao.getUserEmail());
				request.getRequestDispatcher("UserHomeProfile.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMsg", "Registation Not SuccessFull");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}
}
