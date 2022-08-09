package com.onlinebookstore.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bookstore.DatabaseConnectivity;
import com.onlinebookstore.model.RegistrationDao;

public class RegistrationMVC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RegistrationDao registrationDao = new RegistrationDao();
		registrationDao.setUserName(request.getParameter("UserName"));
		registrationDao.setUserEmail(request.getParameter("UserEmail"));
		registrationDao.setUserRole(request.getParameter("UserRole"));
		registrationDao.setUserPassword(request.getParameter("UserPassword"));
		String queryString = "Insert into registration values(?,?,?,?)";
		try {
			Connection con = DatabaseConnectivity.dbConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, registrationDao.getUserName());
			preparedStatement.setString(2, registrationDao.getUserEmail());
			preparedStatement.setString(3, registrationDao.getUserRole());
			preparedStatement.setString(4, registrationDao.getUserPassword());
			int insertResponse = preparedStatement.executeUpdate();
			if (insertResponse > 0) {
				this.emailSend("Dear [" + registrationDao.getUserName()
						+ "]Thank you for completing your registration with [Webkorps]This email serves as a confirmation that your account is activated and that you are officially a part of the [Online Book Store] family Enjoy",
						registrationDao.getUserEmail());
				System.out.print("Success");
				request.setAttribute("registrationObject", registrationDao);
				response.sendRedirect("Login.jsp");
			} else {
				response.sendRedirect("RegistrationMVC.jsp");
				System.out.print(" not Success");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void emailSend(String message, String userEmail) {
		System.out.println("Preparing to send message");

		String subject = "Online Book Store: conformation";
		String from = "manishsultanpure538@gmail.com";
		sendAttachment(message, subject, userEmail, from);

	} // This is responsible to send the message with attachment

	private static void sendAttachment(String message, String subject, String to, String from) {
		// Variable for gmail.
		String host = "smtp.gmail.com"; // get the System properties
		Properties properties = System.getProperties();
		System.out.println("Properties= " + properties);
		// Setting important information to properties Object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");// 465 is default port number of g
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1:- to get the session Object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("manishsultanpure538@gmail.com", "upemktvnaqwifgnc");
			}
		});
		session.setDebug(true);

		// Step 2:- Compose the message
		try {
			MimeMessage mimeMessage = new MimeMessage(session); // from email
			mimeMessage.setFrom("manishsultanpure538@gmail.com"); // Adding resipient to message
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message); // Attachments +

			// FilePath

			String path = "E:\\BackgroundOfBook.jpg";
			MimeMultipart mimeMultipart = new MimeMultipart();

			// Text and File
			MimeBodyPart textMime = new MimeBodyPart();
			MimeBodyPart fileMime = new MimeBodyPart();
			try {
				textMime.setText(message);

				File file = new File(path);
				fileMime.attachFile(file);

				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);

			} catch (Exception e) {
				System.out.print("First");
				e.printStackTrace();
			}
			mimeMessage.setContent(mimeMultipart);
			// Step 3:- Send the message using Transport Class
			Transport.send(mimeMessage);
			System.out.println("Success Fully Send");
		} catch (Exception e) { // TODO: handle exception
			System.out.print("Second");
			e.printStackTrace();

		}

	}
}
