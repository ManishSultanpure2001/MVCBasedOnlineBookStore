package com.onlinebookstore.controller;

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
		registrationDao.setUserName(request.getParameter("UserName"));
		registrationDao.setUserEmail(request.getParameter("UserEmail"));
		registrationDao.setUserRole(request.getParameter("UserRole"));
		registrationDao.setUserPassword(request.getParameter("UserPassword"));
		Authontication authontication = new Authontication();
		boolean flag = authontication.registration(registrationDao);
		if (flag) {
		
			request.setAttribute("successMsg", "Registation SuccessFull");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Not Registation SuccessFull");
			request.getRequestDispatcher("RegisTraion.jsp").forward(request, response);
		}
	}
}
