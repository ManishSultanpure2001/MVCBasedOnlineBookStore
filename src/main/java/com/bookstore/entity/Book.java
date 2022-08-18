package com.bookstore.entity;

/*This entity class is created for get and set
 * all the details related to Book*/


public class Book {
	private String bookName, bookPDF, bookImage, bookPrice, bookAuthor;
	private String selectedItem;
	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}
	public String getSelectedItem() {
		return selectedItem;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookPDF() {
		return bookPDF;
	}

	public void setBookPDF(String bookPDF) {
		this.bookPDF = bookPDF;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

}
