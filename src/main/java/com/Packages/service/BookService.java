package com.Packages.service;

import java.util.List;

import com.Packages.model.Book;

public interface BookService {

	public String addBook(Book bok);
	
	public String updateBook(Book bok);
	
	public List<Book> getAllBooks();
	
	public void deleteBookById(int bkid);
	
	public Book serachNewBook(int bkid);
//	public String getByBkidOrAuthorname(int bkid, String authorname);
}
