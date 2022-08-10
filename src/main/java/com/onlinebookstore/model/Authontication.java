package com.onlinebookstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.bookstore.entity.RegistrationDao;
import com.bookstore.util.DatabaseConnectivity;
import com.bookstore.util.EmailService;
import com.bookstore.entity.UserEmail;

public class Authontication {

	/************Registration Logic************/
	public boolean registration(RegistrationDao dao) {
		String queryString = "Insert into registration values(?,?,?,?)";
		try {
			Connection con = DatabaseConnectivity.dbConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, dao.getUserName());
			preparedStatement.setString(2, dao.getUserEmail());
			preparedStatement.setString(3, dao.getUserRole());
			preparedStatement.setString(4, dao.getUserPassword());
			int insertResponse = preparedStatement.executeUpdate();
			if (insertResponse > 0) {
				EmailService.emailSend("Dear [" + dao.getUserName()
						+ "]Thank you for completing your registration with [Webkorps]This email serves as a confirmation that your account is activated and that you are officially a part of the [Online Book Store] family Enjoy",
						dao.getUserEmail());
				System.out.print("Success");
				return true;
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/*********************Login Logic********************/
	
	public String login(RegistrationDao dao) {
		try {
			Connection con = DatabaseConnectivity.dbConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from registration where email='" + dao.getUserEmail()
					+ "' and password='" + dao.getUserPassword() + "'");

			if (rs.next()) {

				
				if (rs.getString(2).equals(dao.getUserEmail()) && rs.getString(3).equals("Admin")
						&& rs.getString(4).equals(dao.getUserPassword())) {
						return "Admin";
				} else {
					UserEmail userEmail2 = new UserEmail();
					userEmail2.setUserEmail(dao.getUserEmail());
					return "User";
				}
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "null";
	}

}
