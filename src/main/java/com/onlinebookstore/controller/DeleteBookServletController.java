package com.onlinebookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.annotation.MultipartConfig;
import com.online.bookstore.DatabaseConnectivity;
import com.onlinebookstore.model.BookdetailsDao;

/**
 * Servlet implementation class DeleteBookServletController
 */
@MultipartConfig(maxFileSize = 16177215)
/* @WebServlet("/DeleteBookServletController") */
public class DeleteBookServletController extends HttpServlet {
	
	
		private static final long serialVersionUID = 1L;

		String bookName, authorName;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			response.getWriter().append("Served at: ").append(request.getContextPath());
			BookdetailsDao bDao=new BookdetailsDao();
		bDao.setBookName(request.getParameter("bookName")); 
		bDao.setAuthorName(request.getParameter("authorName")); 
 
			String queryString = "DELETE FROM bookdetails WHERE bookname=? and authorName=?";

			try (Connection con = DatabaseConnectivity.dbConnection();) {

				PreparedStatement preparedStatement = con.prepareStatement(queryString);
				preparedStatement.setString(1, bDao.getBookName());
				preparedStatement.setString(2, bDao.getAuthorName());

				int responceGet = preparedStatement.executeUpdate();
				if (responceGet > 0) {
					File image = new File(
							"C:\\Users\\salon\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\MVCBasedOnlineBookStore\\src\\main\\webapp\\Image\\"
									+  bDao.getBookName() + ".png");
					File pdf = new File(
							"C:\\Users\\salon\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\MVCBasedOnlineBookStore\\src\\main\\webapp\\PDF\\"
									+  bDao.getBookName() + ".pdf");
					if (image.delete() && pdf.delete()) {
						System.out.print("deleteed");
					}
					response.sendRedirect("DeleteBook.jsp?output=true");
				} else {
					System.out.println("not Success");
					response.sendRedirect("DeleteBook.jsp?output=false");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

