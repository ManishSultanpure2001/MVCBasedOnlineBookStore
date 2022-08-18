package com.bookstore.util;

/*This class is responsible to Send Email to User */

import java.io.File;
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
import javax.servlet.http.HttpServlet;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.junit.Test;

public class EmailService extends HttpServlet {
	
	/* This is responsible to get and send the message and User Email 
	 * to  sendAttachment() method*/
	
	public static void emailSend(String message, String userEmail) {
		System.out.println("Preparing to send message");

		String subject = "Online Book Store: conformation";
		String from = "manishsultanpure538@gmail.com";
		sendAttachment(message, subject, userEmail, from);

	} 
	
	/* This is responsible to send the message with attachment */

	private static void sendAttachment(String message, String subject, String to, String from) {
		// Variable for gmail.
		String host = "smtp.gmail.com"; // get the System properties
		Properties properties = System.getProperties();
		System.out.println("Properties= " + properties);
		// Setting important information to properties Object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");// 465 is default port number of google
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		//to get the session Object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("manishsultanpure538@gmail.com", "upemktvnaqwifgnc");
			}
		});
		session.setDebug(true);

		//Compose the message
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

				e.printStackTrace();
			}
			mimeMessage.setContent(mimeMultipart);
			//Send the message using Transport Class
			Transport.send(mimeMessage);
			System.out.println("Success Fully Send");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
