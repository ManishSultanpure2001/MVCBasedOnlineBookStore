package com.online.bookstore;

import java.sql.*;

public class DatabaseConnectivity {
	static Connection con;
	static ResultSet rs;
	static Statement st;
	static int getResponse;

	public static Connection dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///onlinebookstore?allowPublicKeyRetrieval=true&useSSL=false",
					"root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}