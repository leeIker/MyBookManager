package org.huijingyuan.entity;

public class BookType {
	private String booktype;
	private String bookDes;
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getBookDes() {
		return bookDes;
	}
	public void setBookDes(String bookDes) {
		this.bookDes = bookDes;
	}
	public BookType(String booktype, String bookDes) {
		super();
		this.booktype = booktype;
		this.bookDes = bookDes;
	}
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
