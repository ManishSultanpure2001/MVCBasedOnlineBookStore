package com.bookstore.util;

/*DataBase Connectivity Code for return the Connection object  */

import java.sql.*;


public class DatabaseConnectivity {
	static Connection con;
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