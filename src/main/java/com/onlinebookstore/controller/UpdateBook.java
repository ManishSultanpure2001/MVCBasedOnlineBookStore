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

import com.online.bookstore.DatabaseConnectivity;

public class UpdateBook extends HttpServlet {

	ArrayList<String> arrayList = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String queryString = "Select DISTINCT bookname from bookdetails";
		int i = 0;
		try (Connection con = DatabaseConnectivity.dbConnection();) {
			arrayList.clear();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				arrayList.add(rs.getString(1));
			}
			System.out.print(arrayList);
			request.setAttribute("list", arrayList);
			request.getRequestDispatcher("UpdateBookMVC.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
