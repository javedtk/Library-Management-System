package com.Packages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Packages.dao.BookDao;
import com.Packages.model.Admin;
import com.Packages.model.Book;
import com.Packages.service.AdminService;
import com.Packages.service.BookService;

@RestController
@RequestMapping("/admin/s1")
public class AdminController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private BookDao bookDao;
	
	 //Url:  http://localhost:8082/admin/s1/admin/registerAdmin
	@PostMapping("/admin/registerAdmin")  
	public String addAdmin(@RequestBody Admin adm) {
		return adminService.adminRegister(adm);
	}
	
	 //Url:  http://localhost:8082/admin/s1/admin/adminLogin
	@GetMapping("/admin/adminLogin")  
	public String adminLogin(@RequestParam String adminusername, @RequestParam String password) {
		return adminService.adminLogin(adminusername, password);
	}
	
	//Url:  http://localhost:8082/admin/s1/admin/addBook
	@PostMapping("/admin/addBook")   
	public String addNewBook(@RequestBody Book bok) {
		return bookService.addBook(bok);
	}
	
	//Url:  http://localhost:8082/admin/s1/admin/updateBook
	@PutMapping("/admin/updateBook")   
	public String updateBook(@RequestBody Book bok) {
		return bookService.updateBook(bok);
	}
	
	//Url:  http://localhost:8082/admin/s1/admin/getAllBook
	@GetMapping("/admin/getAllBook")   
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	//Url:  http://localhost:8082/admin/s1/admin/deleteBook/{bkid}
	@DeleteMapping("/admin/deleteBook/{bkid}")   
	public void deleteBook(@PathVariable("bkid") int bkid) {
		bookService.deleteBookById(bkid);
	}
	
	//Url:  http://localhost:8082/admin/s1/admin/getBookByIdOrByAuthorName
	@GetMapping("/admin/getBookByIdOrByAuthorName")  
	public ResponseEntity<String> serachBook(@RequestParam(required = false) int bkid, 
			String authorname) {
		Book book = bookService.serachNewBook(bkid);
		if(book == null) {
			return new ResponseEntity<String>("Book is not Available for this " + 
		bkid + "Book Id And " + authorname + "Author Name", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Book Title: "+ book.getTitle() +
			 "\nBook Price: "+book.getPrice() +
			"\nBook Publication: "+book.getPublicationname() +
			"\nBook Code: "+book.getBookcode(), HttpStatus.OK);
		}
	}
}
