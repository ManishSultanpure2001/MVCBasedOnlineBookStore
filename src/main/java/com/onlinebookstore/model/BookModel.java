package com.onlinebookstore.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import com.bookstore.entity.BookdetailsDao;
import com.bookstore.util.DatabaseConnectivity;
import com.bookstore.entity.Book;

public class BookModel {

	/************* Add Book Logic *********************/

	InputStream inputStreamPDF, inputStreamImage;

	private FileOutputStream fileOutputStreamImage, fileOutputStreamPDF;
	int bytesImage = 0;
	int bytesPDF = 0;
	BookdetailsDao bookdetailsDao;

	public boolean addBook(BookdetailsDao bookdetailsDao) {
		this.bookdetailsDao = bookdetailsDao;
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
				return true;

			}

		} catch (SQLException | IOException | MessagingException e) {

			e.printStackTrace();
		}
		return false;
	}

	// File Input
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

				fileOutputStreamPDF.write(bytesPDF);
			}
			while ((bytesImage = inputStreamImage.read()) != -1) {

				fileOutputStreamImage.write(bytesImage);
			}
		} finally {
			fileOutputStreamImage.close();
			fileOutputStreamPDF.close();
		}
	}

	/***************** View Book ****************/
	public static ArrayList<Book> viewBook() {
		ArrayList<Book> list = new ArrayList<>();

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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	/****************Update Book****************/
	public static ArrayList<String> updateBook() {

		ArrayList<String> arrayList = new ArrayList<>();
		String queryString = "Select DISTINCT bookname from bookdetails";
		int i = 0;
		try (Connection con = DatabaseConnectivity.dbConnection();) {
			arrayList.clear();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				arrayList.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public static boolean updateBookDatabases(Book book) {
		String queryString = "UPDATE bookdetails SET  bookname=? ,bookpdf=? , pic=? ,bookprice=? , authorname=?  WHERE  bookname=?";
		try {
			Connection con = DatabaseConnectivity.dbConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, book.getBookName());
			preparedStatement.setString(2, book.getBookPDF());
			preparedStatement.setString(3, book.getBookImage());
			preparedStatement.setString(4, book.getBookPrice());
			preparedStatement.setString(5, book.getBookAuthor());
			preparedStatement.setString(6, book.getSelectedItem());
			int insertResponse = preparedStatement.executeUpdate();
			if (insertResponse > 0) {
					return true;	
			} 
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	/********Delete Boook *******/
	public static boolean deleteBook(BookdetailsDao bDao) {

		String queryString = "DELETE FROM bookdetails WHERE bookname=? and authorName=?";

		try (Connection con = DatabaseConnectivity.dbConnection();) {

			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, bDao.getBookName());
			preparedStatement.setString(2, bDao.getAuthorName());

			int responceGet = preparedStatement.executeUpdate();
			if (responceGet > 0) {
				File image = new File(
						"C:\\Users\\salon\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\MVCBasedOnlineBookStore\\src\\main\\webapp\\Image\\"
								+ bDao.getBookName() + ".png");
				File pdf = new File(
						"C:\\Users\\salon\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\MVCBasedOnlineBookStore\\src\\main\\webapp\\PDF\\"
								+ bDao.getBookName() + ".pdf");
				if (image.delete() && pdf.delete()) {
				return true;
				}
			}
			
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return false;
	}
}
