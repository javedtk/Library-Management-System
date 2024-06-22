package com.Packages.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Packages.dao.BookDao;
import com.Packages.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public String addBook(Book bok) {
		Book book = bookDao.save(bok);
		return "Book Added Successfully";
	}

	@Override
	public String updateBook(Book bok) {
		Book book = bookDao.save(bok);
		return "Book Updated Successfully";
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public void deleteBookById(int bkid) {
		bookDao.deleteById(bkid);
	}

	@Override
	public Book serachNewBook(int bkid) {
		Book book = bookDao.findByBkid(bkid);
		return book;
	}
}
