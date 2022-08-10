package com.onlinebookstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookdetailsDao;
import com.bookstore.entity.UserEmail;
import com.bookstore.util.DatabaseConnectivity;
import com.bookstore.util.EmailService;
import com.onlinebookstore.controller.RegistrationController;

public class UserModel {
	
	/*Searched Book*/
		public static ArrayList searchBook(BookdetailsDao book) 
		{
			ArrayList list=new ArrayList();
			try {
				Connection con = DatabaseConnectivity.dbConnection();
				java.sql.Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from bookdetails where bookname='" + book.getBookName() + "' ");
				if (rs.next()) {
					book.setBookName(rs.getString(1));
					book.setBookPrice(rs.getString(4));
					list.add(book);
					list.add(true);
					return list;
				}  
				con.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			list.add(book);
			list.add(false);
			return list;
		}
		
		
		/*Purchesd Book List*/
		public static ArrayList purchesedBookList() {
			String email = UserEmail.getUserEmail();
			System.out.print("Email=" + email);
			ArrayList<String> list = new ArrayList<>();
			String queryString = "SELECT DISTINCT email,name FROM userbuydata where email=?";
			try (Connection con = DatabaseConnectivity.dbConnection();) {

				PreparedStatement preparedStatement = con.prepareStatement(queryString);
				preparedStatement.setString(1, email);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()){
					list.add(rs.getString(2));
				}
		}
		 catch (SQLException e) {

			e.printStackTrace();
		}
			return list;	
}
		
		public static boolean purchesedBookData(Book book,UserEmail email) {
			String message = "Thanks for Having Interest in our Store You have successfully purchased [ " + book.getBookName()
					+ "  ] Book" + "   Whose Price is    [ " + book.getBookPrice() + " ]";

			String queryString = "Insert into userbuydata values(?,?,?)";
			System.out.println("Registration.doGet().before connection calling ");
			try {
				Connection con = DatabaseConnectivity.dbConnection();
				PreparedStatement preparedStatement = con.prepareStatement(queryString);
				preparedStatement.setString(1, email.getUserEmail());
				preparedStatement.setString(2, book.getBookName());
				preparedStatement.setString(3, book.getBookPrice());
				int insertResponse = preparedStatement.executeUpdate();
				if (insertResponse > 0) {
					EmailService.emailSend(message, email.getUserEmail());
					return true;
				} 
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return false;
		}
}
