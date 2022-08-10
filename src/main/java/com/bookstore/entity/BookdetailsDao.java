package com.bookstore.entity;

import javax.mail.Part;

public class BookdetailsDao {
	private String bookName, bookPrice, authorName;
	private javax.servlet.http.Part bookPDF, bookImage;

	public String getBookName() {
		return bookName;
	}

	public String setBookName(String bookName) {
		return this.bookName = bookName;
	}

	public javax.servlet.http.Part getBookPDF() {
		return (javax.servlet.http.Part) bookPDF;
	}

	public void setBookPDF(javax.servlet.http.Part part) {
		this.bookPDF = (javax.servlet.http.Part) part;
	}

	public javax.servlet.http.Part getBookImage() {
		return bookImage;
	}

	public void setBookImage(javax.servlet.http.Part part) {
		this.bookImage = (javax.servlet.http.Part) part;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
