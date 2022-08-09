package com.onlinebookstore.controller;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.annotation.MultipartConfig;
import com.online.bookstore.DatabaseConnectivity;
import com.onlinebookstore.model.BookdetailsDao;

@MultipartConfig(maxFileSize = 16177215)

public class AddBookController extends HttpServlet {

	InputStream inputStreamPDF, inputStreamImage;

	private FileOutputStream fileOutputStreamImage, fileOutputStreamPDF;
	int bytesImage = 0;
	int bytesPDF = 0;
	BookdetailsDao bookdetailsDao = new BookdetailsDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		bookdetailsDao.setBookName(request.getParameter("addBookName"));
		bookdetailsDao.setBookPDF(request.getPart("addFileName"));
		bookdetailsDao.setBookImage(request.getPart("addImageName"));
		bookdetailsDao.setBookPrice(request.getParameter("addBookPrice"));
		bookdetailsDao.setAuthorName(request.getParameter("addAuthorName"));

		String queryString = "Insert into bookdetails values(?,?,?,?,?)";

		try (Connection con = DatabaseConnectivity.dbConnection();) {
			PreparedStatement preparedStatement = con.prepareStatement(queryString);

			preparedStatement.setString(1, bookdetailsDao.getBookName());
			preparedStatement.setString(2, bookdetailsDao.getBookName() + ".pdf");
			preparedStatement.setString(3, bookdetailsDao.getBookName() + ".png");
			preparedStatement.setString(4, bookdetailsDao.getBookPrice());
			preparedStatement.setString(5, bookdetailsDao.getAuthorName());
			int responceGet = preparedStatement.executeUpdate();
			if (responceGet > 0) {
				this.fileStore(bookdetailsDao.getBookName());
				String success = "Successfull";
				request.setAttribute("message", success);
				response.sendRedirect("AddBook.jsp?output=true");
			} else {
				response.sendRedirect("AddBook.jsp?output=false");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileStore(String bookName) throws IOException, MessagingException {
		System.out.print("method called");
		inputStreamImage = bookdetailsDao.getBookImage().getInputStream();
		inputStreamPDF = bookdetailsDao.getBookPDF().getInputStream();
		try {
			fileOutputStreamImage = new FileOutputStream(
					"C:\\Users\\salon\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\MVCBasedOnlineBookStore\\src\\main\\webapp\\Image\\"
							+ bookName + ".png");
			fileOutputStreamPDF = new FileOutputStream(
					"C:\\Users\\salon\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\MVCBasedOnlineBookStore\\src\\main\\webapp\\PDF\\"
							+ bookName + ".pdf");
			while ((bytesPDF = inputStreamPDF.read()) != -1) {

				System.out.print("first called");
				fileOutputStreamPDF.write(bytesPDF);
			}
			while ((bytesImage = inputStreamImage.read()) != -1) {

				System.out.print("Second called");
				fileOutputStreamImage.write(bytesImage);
			}
		} finally {
			fileOutputStreamImage.close();
			fileOutputStreamPDF.close();
		}
	}
}
