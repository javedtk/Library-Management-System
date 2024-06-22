package com.Packages.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bok_tbl")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bkid;
	private String title;
	private String authorname;
	private String publicationname;
	private String price;
	private String bookcode;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getBkid() {
		return bkid;
	}

	public void setBkid(int bkid) {
		this.bkid = bkid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getPublicationname() {
		return publicationname;
	}

	public void setPublicationname(String publicationname) {
		this.publicationname = publicationname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBookcode() {
		return bookcode;
	}

	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}

	public Book(int bkid, String title, String authorname, String publicationname, String price, String bookcode) {
		super();
		this.bkid = bkid;
		this.title = title;
		this.authorname = authorname;
		this.publicationname = publicationname;
		this.price = price;
		this.bookcode = bookcode;
	}

	
	
	
}
