package com.onlinebookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.MultipartConfig;

import com.online.bookstore.DatabaseConnectivity;
import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.BookdetailsDao;

@MultipartConfig(maxFileSize = 16177215)

public class AdminViewBookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String bookName, authorName;
	String htmlRespone;
	OutputStream os;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Book> list = new ArrayList<>();
		PrintWriter out = response.getWriter();

		String queryString = "Select * from bookdetails";

		try (Connection con = DatabaseConnectivity.dbConnection();) {

			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Book bDao = new Book();
				bDao.setBookName(rs.getString(1));
				bDao.setBookPDF(rs.getString(2));
				bDao.setBookImage(rs.getString(3));
				bDao.setBookPrice(rs.getString(4));
				bDao.setBookAuthor(rs.getString(5));
				list.add(bDao);
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("AdminViewAllBook.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}