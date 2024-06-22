package com.Packages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Packages.dao.BookDao;
import com.Packages.model.Book;
import com.Packages.model.User;
import com.Packages.service.BookService;
import com.Packages.service.UserService;

@RestController
@RequestMapping("/user/s1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookService bookService;
	
	
	//Url:  http://localhost:8082/user/s1/User/registerUser
	@PostMapping("/User/registerUser")  
	public String addNewUser(@RequestBody User usr) {
		return userService.registerUser(usr);
	}
	
	//Url:  http://localhost:8082/user/s1/user/userLogin
	@GetMapping("/user/userLogin")    
	public String userLogin(@RequestParam String username, @RequestParam String password) {
		return userService.userLogin(username, password);
	}
	
	
	 //Url:  http://localhost:8082/user/s1/user/getAllBooksList
	@GetMapping("/user/getAllBooksList")  
	public List<Book> getallbook(){
		return bookService.getAllBooks();
	}
	
	//Url:  http://localhost:8082/user/s1/user/findbyauthorname
	@GetMapping("/user/findbyauthorname")  
	public ResponseEntity<List<Book>> getbookdetailsbyauthorname(@RequestParam(name = 
	"authorname", required = false) String authorname){
		return new ResponseEntity<List<Book>>(bookDao.findByAuthorname(authorname),
				HttpStatus.OK);
	}
	
	 //Url:  http://localhost:8082/user/s1/user/findbytitle
	@GetMapping("/user/findbytitle")  
	public ResponseEntity<List<Book>> getbookdetailsbybooktitle(@RequestParam(name = 
	"title", required = false) String title){
		return new ResponseEntity<List<Book>>(bookDao.findByTitle(title), 
				HttpStatus.OK);
	}
	
	//Url:  http://localhost:8082/user/s1/user/findbypublicationname
	@GetMapping("/user/findbypublicationname")   
	public ResponseEntity<List<Book>> findbypublicationname(@RequestParam(name = 
	"publicationname", required = false) String publicationname){
		return new ResponseEntity<List<Book>>(bookDao.findByPublicationname(publicationname), 
				HttpStatus.OK);
	}
 	
	 //Url:  http://localhost:8082/user/s1/user/findbybookid
	@GetMapping("/user/findbybookid")  
	public ResponseEntity<String> findbybookid(@RequestParam(name = 
	"bkid", required = false) int bkid){
		Book book = bookService.serachNewBook(bkid);
		if(book == null) {
			return new ResponseEntity<String>("Book is not Available for Book Id " + 
		bkid, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Book Title: "+ book.getTitle() +
			 "\nBook Price: "+book.getPrice() +
			"\nBook Publication: "+book.getPublicationname() +
			"\nBook Code: "+book.getBookcode(), HttpStatus.OK);
		}
	}
	
	
	//Url:  http://localhost:8082/user/s1/user/sortbyprice
	@GetMapping("/user/sortbyprice")  
	public ResponseEntity<List<Book>> sortbyprice(){
		return new ResponseEntity<List<Book>>(bookDao.findByOrderByPriceAsc(), HttpStatus.OK);
	}
	
	 //Url:  http://localhost:8082/user/s1/user/addbookinlike
	@GetMapping("/user/addbookinlike")  
	public ResponseEntity<String> addbookinyourfevourate(@RequestParam(name = "bkid"
	, required = false) int bkid){
		Book book = bookService.serachNewBook(bkid);
		if(book == null) {
			return new ResponseEntity<String>("Book is not Available for Book Id " 
		+bkid, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("This Book is Added in your like Box", 
					HttpStatus.OK);
		}
	}
	
	 //Url:  http://localhost:8082/user/s1/user/getbookbypricerange
	@GetMapping("/user/getbookbypricerange") 
	public ResponseEntity<List<Book>> getbookbypricerange(@RequestParam String startPrice, 
			@RequestParam String endPrice){
		return new ResponseEntity<List<Book>>(bookDao.findByPriceBetween(startPrice, 
				endPrice), HttpStatus.OK);
	}
}
