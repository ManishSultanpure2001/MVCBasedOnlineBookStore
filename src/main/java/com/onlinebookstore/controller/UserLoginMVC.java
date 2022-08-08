package com.onlinebookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.online.bookstore.*;
import com.onlinebookstore.model.RegistrationDao;
 

/**
 * Servlet implementation class UserLoginMVC
 */
 
public class UserLoginMVC extends HttpServlet {
	 

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			RegistrationDao registrationDao=new RegistrationDao();
			 registrationDao.setUserEmail(request.getParameter("loginUserEmail"));
			 registrationDao.setUserPassword(request.getParameter("loginUserPassword"));
			try {
				Connection con = DatabaseConnectivity.dbConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(
						"Select * from registration where email='" + registrationDao.getUserEmail() + "' and password='" + registrationDao.getUserPassword() + "'");

				if (rs.next()) {

					if (rs.getString(2).equals(registrationDao.getUserEmail()) && rs.getString(3).equals("Admin")
							&& rs.getString(4).equals(registrationDao.getUserPassword())) {
						response.sendRedirect("AdminHome.jsp");
					} else {
						request.setAttribute("userEmail", registrationDao.getUserEmail());
						request.getRequestDispatcher("UserHomeProfile.jsp").forward(request, response);
					}
				} else {
					response.sendRedirect("Login.jsp");
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
