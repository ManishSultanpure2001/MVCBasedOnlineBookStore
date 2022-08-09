package com.onlinebookstore.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bookstore.DatabaseConnectivity;
import com.onlinebookstore.model.UserEmail;

public class UserBuyHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = UserEmail.getUserEmail();
		System.out.print("Email=" + email);
		ArrayList<String> list = new ArrayList<>();
		String queryString = "SELECT DISTINCT email,name FROM userbuydata where email=?";
		try (Connection con = DatabaseConnectivity.dbConnection();) {

			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(2));
			}
			
			request.setAttribute("listData", list);
			request.getRequestDispatcher("UserBuyedHistory.jsp").forward(request, response);
			;
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
