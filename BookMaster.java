package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book")
public class BookMaster {
	
	@Id
	private int book_id;
	
	private String book_title;
	
	private String book_author;
	
	private int book_copies;
	
	private String book_status;
	
	public BookMaster() {
		// TODO Auto-generated constructor stub
	}
	
	public BookMaster(int book_id, String book_title, String book_author, int book_copies, String book_status) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_copies = book_copies;
		this.book_status = book_status;
	}

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public int getBook_copies() {
		return book_copies;
	}
	public void setBook_copies(int book_copies) {
		this.book_copies = book_copies;
	}
	public String getBook_status() {
		return book_status;
	}
	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}

	
}
