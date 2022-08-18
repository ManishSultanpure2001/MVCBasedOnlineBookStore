package com.onlinebookstore.controller;

/* This class is responsible to get User Or Admin Details from RegisTraion.jsp Page
 * and Store the details in Database on the basis of 
 * Input field Data from RegisTraion.jsp page for Registration */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.onlinebookstore.model.Authontication;
import com.bookstore.entity.RegistrationDao;

public class RegistrationController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RegistrationDao registrationDao = new RegistrationDao();
		registrationDao.setUserName(request.getParameter("UserName").trim());
		registrationDao.setUserEmail(request.getParameter("UserEmail").trim());
		registrationDao.setUserRole(request.getParameter("UserRole").trim());
		registrationDao.setUserPassword(request.getParameter("UserPassword").trim());
		Authontication authontication = new Authontication();
		boolean flag = authontication.registration(registrationDao);
		/* if registration() return true */
		if (flag) {
			request.setAttribute("successMsg", "Registation SuccessFull");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		/* if registration() return false */
		else {
			request.setAttribute("errorMsg", "Registation Not SuccessFull");
			request.getRequestDispatcher("RegisTraion.jsp").forward(request, response);
		}
	}
}
